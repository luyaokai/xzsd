package com.xzsd.pc.hotgoods.controller;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfoVO;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfoVO1;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO;
import com.xzsd.pc.user.controller.DemoController;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotgoods")
public class HotGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * slideshow 新增热门商品
     *
     * @param hotGoodsInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-17
     */
    @PostMapping("saveHotGoods")
    public AppResponse saveHotGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsInfo.setCreateUser1(userId);
            AppResponse appResponse = hotGoodsService.saveHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotgoods 热门商品列表(分页)
     *
     * @param hotGoodsInfoVO
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-17
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsInfoVO hotGoodsInfoVO) {
        try {
            return hotGoodsService.listHotGoods(hotGoodsInfoVO);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotGoods 删除热门商品
     *
     * @param hotGoodsCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-17
     */
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return hotGoodsService.deleteHotGoods(hotGoodsCode, userId);
        } catch (Exception e) {
            logger.error("热门商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotgoods 修改热门商品
     * @param hotGoodsInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-17
     */
    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsInfo.setCreateUser1(userId);
            hotGoodsInfo.setUpdateUser1(userId);
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("修改热门商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotgoods 查询热门商品详情
     * @param hotGoodsCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-17
     */
    @RequestMapping(value = "getHotGoodsByHotGoodsCode")
    public AppResponse getHotGoodsByHotGoodsCode(String hotGoodsCode) {
        try {
            return hotGoodsService.getHotGoodsByHotGoodsCode(hotGoodsCode);
        } catch (Exception e) {
            logger.error("热门商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotgoods 热门商品展示数量
     *
     * @param hotGoodsInfoVO1
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-17
     */
    @RequestMapping(value = "getHotGoodsShowNum")
    public AppResponse getHotGoodsShowNum(HotGoodsInfoVO1 hotGoodsInfoVO1) {
        try {
            return hotGoodsService.getHotGoodsShowNum(hotGoodsInfoVO1);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotgoods 修改热门商品展示数量
     * @param hotGoodsInfoVO1
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-17
     */
    @PostMapping("updateHotGoodsShowNum")
    public AppResponse updateHotGoodsShowNum(HotGoodsInfoVO1 hotGoodsInfoVO1) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsInfoVO1.setUpdateUser1(userId);
            return hotGoodsService.updateHotGoodsShowNum(hotGoodsInfoVO1);
        } catch (Exception e) {
            logger.error("修改热门商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
