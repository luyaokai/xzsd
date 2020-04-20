package com.xzsd.pc.driver.controller;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverInfoVO;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.user.controller.DemoController;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-20
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private DriverService driverService;

    /**
     * driver 新增司机
     *
     * @param driverInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-04-20
     */
    @PostMapping("saveDriver")
    public AppResponse saveDriver(DriverInfo driverInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            driverInfo.setCreateUser1(userId);
            AppResponse appResponse = driverService.saveDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * driver 司机列表(分页)
     *
     * @param driverInfoVO
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @RequestMapping(value = "listDriver")
    public AppResponse listDriver(DriverInfoVO driverInfoVO) {
        try {
            return driverService.listDriver(driverInfoVO);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * driver 删除司机
     *
     * @param userCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String userCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return driverService.deleteDriver(userCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * driver 修改司机
     *
     * @param driverInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            driverInfo.setCreateUser1(userId);
            driverInfo.setUpdateUser1(userId);
            return driverService.updateDriver(driverInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * drier 查询司机详情
     *
     * @param userCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @RequestMapping(value = "getUserByUserCode")
    public AppResponse getUserByUserCode(String userCode) {
        try {
            return driverService.getUserByUserCode(userCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
