package com.xzsd.pc.shop.dao;

import com.xzsd.pc.shop.entity.ShopInfo;
import com.xzsd.pc.shop.entity.ShopInfoVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairfuieng
 * @date 2020-04-20
 */
@Mapper
public interface ShopDao {

    /**
     * 统计用户编号数量
     * @param shopInfo 用户信息
     * @return
     */
    int countUserCode(ShopInfo shopInfo);

    /**
     * 新增门店
     * @param shopInfo 门店信息
     * @return
     */
    int saveShop(ShopInfo shopInfo);

    /**
     * 获取所有门店信息
     * @param shopInfoVO 用户信息
     * @return 所有门店信息
     */
    List<ShopInfoVO> listShopByPage(ShopInfoVO shopInfoVO);

    /**
     * 删除门店信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */
    int deleteShop(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改门店信息
     * @param shopInfo 门店信息
     * @return 修改结果
     */
    int updateShop(ShopInfo shopInfo);

    /**
     * 查询门店信息
     * @param shopCode 门店编号
     * @return 门店信息
     */
    ShopInfo getShopByShopCode(@Param("shopCode") String shopCode);
}
