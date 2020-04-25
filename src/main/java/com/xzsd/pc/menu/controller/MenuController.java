package com.xzsd.pc.menu.controller;

import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairfuieng
 * @date 2020-04-18
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * menu 新增菜单
     *
     * @param menuInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-04-18
     */
    @PostMapping("saveMenu")
    public AppResponse saveMenu(MenuInfo menuInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            menuInfo.setCreateUser1(userId);
            AppResponse appResponse = menuService.saveMenu(menuInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * menu 菜单列表
     *
     *
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-18
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu() {
        try {
            return menuService.listMenu();
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * menu 用户菜单列表
     *
     * @param role
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-18
     */
    @RequestMapping(value = "listMenuHome")
    public AppResponse listMenuHome(String role) {
        try {
            return menuService.listMenuHome(role);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * menu 删除菜单
     *
     * @param menuCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-18
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return menuService.deleteMenu(menuCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * menu 修改菜单
     *
     * @param menuInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-18
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            menuInfo.setCreateUser1(userId);
            menuInfo.setUpdateUser1(userId);
            return menuService.updateMenu(menuInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * menu 查询菜单详情
     *
     * @param menuCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-18
     */
    @RequestMapping(value = "getMenuByMenuCode")
    public AppResponse getMenuByMenuCode(String menuCode) {
        try {
            return menuService.getMenuByMenuCode(menuCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
