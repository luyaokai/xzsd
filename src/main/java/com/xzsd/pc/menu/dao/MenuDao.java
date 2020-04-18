package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuInfoVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-18
 */
@Mapper
public interface MenuDao {

    /**
     * 新增菜单
     * @param menuInfo 菜单信息
     * @return
     */
    int saveMenu(MenuInfo menuInfo);

    /**
     * 获取所有菜单信息
     *
     * @return 所有菜单信息
     */
    List<MenuInfoVO> listMenu();

    /**
     * 根据角色编号获取菜单信息
     * @param role
     * @return 所有菜单信息
     */
    List<MenuInfoVO> listMenuHome(@Param("role") String role);

    /**
     * 删除菜单信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */
    int deleteMenu(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改菜单信息
     * @param menuInfo 菜单信息
     * @return 修改结果
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 查询菜单信息
     * @param menuCode 用户编号
     * @return 菜单信息
     */
    MenuInfo getMenuByMenuCode(@Param("menuCode") String menuCode);
}
