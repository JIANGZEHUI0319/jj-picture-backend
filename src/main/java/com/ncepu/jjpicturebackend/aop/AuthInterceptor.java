package com.ncepu.jjpicturebackend.aop;

import com.ncepu.jjpicturebackend.annotation.AuthCheck;
import com.ncepu.jjpicturebackend.exception.BusinessException;
import com.ncepu.jjpicturebackend.exception.ErrorCode;
import com.ncepu.jjpicturebackend.model.entity.User;
import com.ncepu.jjpicturebackend.model.enums.UserRoleEnum;
import com.ncepu.jjpicturebackend.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Aspect 是 Spring AOP（面向切面编程）中的一个重要注解，它主要用于定义一个切面类。
 * 使用场景
 * 日志记录：在方法执行前后记录日志，方便后续的调试和监控。
 * 事务管理：在方法执行前后开启和提交事务，或者在方法抛出异常时回滚事务。
 * 权限验证：在方法执行前检查用户是否具有相应的权限。
 * 性能监控：记录方法的执行时间，分析系统的性能瓶颈。
 */
@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    /**
     * 执行拦截
     * 先在方法上添加自定义注解表明执行该方法需要的权限
     * 如果注解没有添加任何权限，表示不需要权限即可访问，放行
     * 否则，先获取当前会话请求，通过请求得到当前登录的用户
     * 检查当前登录用户的角色权限
     * 如果该角色没有任何权限，则拒绝访问
     * 否则进行权限比较
     * 如果该方法需要管理员权限，而用户不是管理员权限，则拒绝
     * 否则放行
     *
     * @param joinPoint 切入点
     * @param authCheck 权限校验注解
     */
    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        String mustRole = authCheck.mustRole();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 当前登录用户
        User loginUser = userService.getLoginUser(request);
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);
        // 不需要权限，放行
        if (mustRoleEnum == null) {
            return joinPoint.proceed();
        }
        // 以下为：必须有该权限才通过
        // 获取当前用户具有的权限
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());
        // 没有权限，拒绝
        if (userRoleEnum == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 要求必须有管理员权限，但用户没有管理员权限，拒绝
        if (UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(userRoleEnum)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 通过权限校验，放行
        return joinPoint.proceed();
    }
}
