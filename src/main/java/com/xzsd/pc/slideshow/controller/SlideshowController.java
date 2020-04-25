package com.xzsd.pc.slideshow.controller;

import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO1;
import com.xzsd.pc.slideshow.service.SlideshowService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairufieng
 * @date 2020-04-10
 */
@RestController
@RequestMapping("/slideshow")
public class SlideshowController {

    private static final Logger logger = LoggerFactory.getLogger(SlideshowController.class);

    @Resource
    private SlideshowService slideshowService;

    /**
     * slideshow 新增轮播图
     *
     * @param slideshowInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-10
     */
    @PostMapping("saveSlideshow")
    public AppResponse saveSlideshow(SlideshowInfo slideshowInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            slideshowInfo.setCreateUser1(userId);
            AppResponse appResponse = slideshowService.saveSlideshow(slideshowInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 轮播图列表(分页)
     *
     * @param slideshowInfoVO
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-10
     */
    @RequestMapping(value = "listSlideshow")
    public AppResponse listSlideshow(SlideshowInfoVO slideshowInfoVO) {
        try {
            return slideshowService.listSlideshow(slideshowInfoVO);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * slideshow 删除轮播图
     *
     * @param slideshowCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-10
     */
    @PostMapping("deleteSlideshow")
    public AppResponse deleteSlideshow(String slideshowCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return slideshowService.deleteSlideshow(slideshowCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改轮播图状态
     *
     * @param slideshowCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-13
     */
    @PostMapping("updateSlideshowState")
    public AppResponse updateSlideshowState(String slideshowCode, int slideshowState) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return slideshowService.updateSlideshowState(slideshowCode,userId,slideshowState);
        } catch (Exception e) {
            logger.error("修改轮播图状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图详情
     *
     * @param slideshowCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-03-11
     */
    @RequestMapping(value = "getSlideshowBySlideshowCode")
    public AppResponse getSlideshowBySlideshowCode(String slideshowCode) {
        try {
            return slideshowService.getSlideshowBySlideshowCode(slideshowCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  轮播图查询商品列表(分页)
     *
     * @param slideshowInfoVO1
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-16
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(SlideshowInfoVO1 slideshowInfoVO1) {
        try {
            return slideshowService.listGoods(slideshowInfoVO1);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
