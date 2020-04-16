package com.xzsd.pc.user.controller;


import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.user.service.DemoService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查DEMO
 * @Author dingning
 * @Date 2020-03-21
 */
@RestController
@RequestMapping("/user")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private DemoService demoService;

    /**
     * demo 新增用户
     *
     * @param userInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-03-25
     */
    @PostMapping("saveUser")
    public AppResponse saveUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateUser1(userId);
            AppResponse appResponse = demoService.saveUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 用户列表(分页)
     *
     * @param userInfoVO
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfoVO userInfoVO) {
        try {
            return demoService.listUsers(userInfoVO);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除用户
     *
     * @param userCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-25
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return demoService.deleteUser(userCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改用户
     *
     * @param userInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-25
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateUser1(userId);
            userInfo.setUpdateUser1(userId);
            return demoService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询用户详情
     *
     * @param userCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-25
     */
    @RequestMapping(value = "getUserByUserCode")
    public AppResponse getUserByUserCode(String userCode) {
        try {
            return demoService.getUserByUserCode(userCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
