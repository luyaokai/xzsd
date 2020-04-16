package com.xzsd.pc.goodsclassify.controller;

import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfo;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfoVo;
import com.xzsd.pc.goodsclassify.service.GoodsClassifyService;
import com.xzsd.pc.user.controller.DemoController;
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
 * @date 2020-04-14
 */
@RestController
@RequestMapping("/goodsclassify")
public class GoodsClassifyController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private GoodsClassifyService goodsClassifyService;

    /**
     * 新增商品分类
     *
     * @param goodsClassifyInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-04-14
     */
    @PostMapping("saveGoodsClassify")
    public AppResponse saveGoodsClassify(GoodsClassifyInfo goodsClassifyInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsClassifyInfo.setCreateUser1(userId);
            AppResponse appResponse = goodsClassifyService.saveGoodsClassify(goodsClassifyInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     *
     * @param classifyCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-14
     */
    @PostMapping("deleteGoodsClassify")
    public AppResponse deleteGoodsClassify(String classifyCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return goodsClassifyService.deleteGoodsClassify(classifyCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品分类
     *
     * @param goodsClassifyInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-25
     */
    @PostMapping("updateGoodsClassify")
    public AppResponse updateGoodsClassify(GoodsClassifyInfo goodsClassifyInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsClassifyInfo.setCreateUser1(userId);
            goodsClassifyInfo.setUpdateUser1(userId);
            return goodsClassifyService.updateGoodsClassify(goodsClassifyInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类详情
     *
     * @param classifyCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-14
     */
    @RequestMapping(value = "getGoodsClassifyByClassifyCode")
    public AppResponse getGoodsClassifyByClassifyCode(String classifyCode) {
        try {
            return goodsClassifyService.getGoodsClassifyByClassifyCode(classifyCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 商品分类列表
     *
     * @param goodsClassifyInfoVo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-14
     */
    @RequestMapping(value = "listGoodsClassify")
    public AppResponse listGoodsClassify(GoodsClassifyInfoVo goodsClassifyInfoVo) {
        try {
            return goodsClassifyService.listGoodsClassify(goodsClassifyInfoVo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
