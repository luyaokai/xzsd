package com.xzsd.pc.goods.controller;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsInfoVO;
import com.xzsd.pc.goods.entity.GoodsInfoVO1;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *增删查改Goods
 * @author Administrator
 * @date 2020-03-27
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 新增商品
     *
     * @param goodsInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-27
     */
    @PostMapping("saveGoods")
    public AppResponse saveGoods(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setCreateUser1(userId);
            AppResponse appResponse = goodsService.saveGoods(goodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  商品列表(分页)
     *
     * @param goodsInfoVO
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsInfoVO goodsInfoVO) {
        try {
            return goodsService.listGoods(goodsInfoVO);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除用户
     *
     * @param goodsCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-06
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品
     *
     * @param goodsInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-08
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setCreateUser1(userId);
            goodsInfo.setUpdateUser1(userId);
            return goodsService.updateGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     *
     * @param goodsCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-08
     */
    @RequestMapping(value = "getGoodsByGoodsCode")
    public AppResponse getGoodsByGoodsCode(String goodsCode) {
        try {
            return goodsService.getGoodsByGoodsCode(goodsCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  商品分类下拉框
     *
     * @param goodsInfoVO1
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-14
     */
    @RequestMapping(value = "listGoodsClassify")
    public AppResponse listGoodsClassify(GoodsInfoVO1 goodsInfoVO1) {
        try {
            return goodsService.listGoodsClassify(goodsInfoVO1);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     *
     * @param goodsCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-14
     */
    @PostMapping("updateGoodsState")
    public AppResponse updateGoodsState(String goodsCode, int goodsState) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return goodsService.updateGoodsState(goodsCode,userId,goodsState);
        } catch (Exception e) {
            logger.error("修改商品状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
