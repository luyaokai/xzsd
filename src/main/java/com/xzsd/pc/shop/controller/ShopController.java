package com.xzsd.pc.shop.controller;

import com.xzsd.pc.shop.entity.ShopInfo;
import com.xzsd.pc.shop.entity.ShopInfoVO;
import com.xzsd.pc.shop.service.ShopService;
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
@RequestMapping("/shop")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Resource
    private ShopService shopService;

    /**
     * shop 新增门店
     *
     * @param shopInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-04-20
     */
    @PostMapping("saveShop")
    public AppResponse saveShop(ShopInfo shopInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            shopInfo.setCreateUser1(userId);
            AppResponse appResponse = shopService.saveShop(shopInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * shop 门店列表(分页)
     *
     * @param shopInfoVO
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @RequestMapping(value = "listShop")
    public AppResponse listShop(ShopInfoVO shopInfoVO) {
        try {
            return shopService.listShop(shopInfoVO);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * shop 删除门店
     *
     * @param shopCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @PostMapping("deleteShop")
    public AppResponse deleteShop(String shopCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return shopService.deleteShop(shopCode, userId);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * shop 修改门店
     *
     * @param shopInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @PostMapping("updateShop")
    public AppResponse updateShop(ShopInfo shopInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            shopInfo.setCreateUser1(userId);
            shopInfo.setUpdateUser1(userId);
            return shopService.updateShop(shopInfo);
        } catch (Exception e) {
            logger.error("修改门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * shop 查询门店详情
     *
     * @param shopCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @RequestMapping(value = "getShopByShopCode")
    public AppResponse getShopByShopCode(String shopCode) {
        try {
            return shopService.getShopByShopCode(shopCode);
        } catch (Exception e) {
            logger.error("门店查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
