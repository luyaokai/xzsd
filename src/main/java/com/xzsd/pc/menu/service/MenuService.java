package com.xzsd.pc.menu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuInfoVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-18
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * menu 新增菜单
     * @param menuInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveMenu(MenuInfo menuInfo) {
        menuInfo.setMenuCode(StringUtil.getCommonCode(2));
        menuInfo.setIsDeleted(0);
        // 新增菜单
        int count = menuDao.saveMenu(menuInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * menu 查询菜单
     * @param
     * @return
     * @Author cairuifeng
     * @Date 2020-04-18
     */
    public AppResponse listMenu() {
        List<MenuInfoVO> menuInfoVOList = menuDao.listMenu();
        return AppResponse.success("查询成功！",menuInfoVOList);
    }

    /**
     * menu 根据用户查询菜单
     * @param role
     * @return
     * @Author cairuifeng
     * @Date 2020-04-18
     */
    public AppResponse listMenuHome(String role) {
        List<MenuInfoVO> menuInfoVOList = menuDao.listMenuHome(role);
        return AppResponse.success("查询成功！",menuInfoVOList);
    }

    /**
     * menu 删除菜单
     * @param menuCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode, String userId) {
        List<String> listCode = Arrays.asList(menuCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = menuDao.deleteMenu(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * menu 修改菜单
     * @param menuInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuInfo menuInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改菜单信息
        int count = menuDao.updateMenu(menuInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * menu 查询菜单详情
     * @param menuCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-18
     */
    public AppResponse getMenuByMenuCode(String menuCode) {
        MenuInfo menuInfo = menuDao.getMenuByMenuCode(menuCode);
        return AppResponse.success("查询成功！",menuInfo);
    }
}
