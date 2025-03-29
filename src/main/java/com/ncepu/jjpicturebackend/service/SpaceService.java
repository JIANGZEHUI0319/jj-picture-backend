package com.ncepu.jjpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ncepu.jjpicturebackend.model.dto.space.SpaceAddRequest;
import com.ncepu.jjpicturebackend.model.dto.space.SpaceQueryRequest;
import com.ncepu.jjpicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ncepu.jjpicturebackend.model.entity.User;
import com.ncepu.jjpicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 14563
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-03-18 15:04:13
*/
public interface SpaceService extends IService<Space> {

    /**
     * 创建空间
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 得到查询条件
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 空间列表脱敏
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 空间脱敏
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 根据空间级别填充控件对象
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     *
     * @param space
     * @param add 是否为创建时校验
     */
    void validSpace(Space space, boolean add);

    /**
     * 校验空间权限
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}
