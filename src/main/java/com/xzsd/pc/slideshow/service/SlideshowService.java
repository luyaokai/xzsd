package com.xzsd.pc.slideshow.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.entity.GoodsInfoVO;
import com.xzsd.pc.slideshow.dao.SlideshowDao;
import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO1;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author 蔡瑞峰
 * @date 2020-04-10
 */
@Service
public class SlideshowService {

    @Resource
    private SlideshowDao slideshowDao;

    /**
     * demo 新增轮播图
     * @param slideshowInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveSlideshow(SlideshowInfo slideshowInfo) {
        // 校验排序是否存在
        int countSlideshowSort = slideshowDao.countSlideshowSort(slideshowInfo);
        if(0 != countSlideshowSort) {
            return AppResponse.bizError("轮播图排序冲突，请重新输入！");
        }
        int countGoodsCode = slideshowDao.countGoodsCode(slideshowInfo);
        if(0 != countGoodsCode) {
            return AppResponse.bizError("选择商品重复！");
        }
        slideshowInfo.setSlideshowCode(StringUtil.getCommonCode(2));
        slideshowInfo.setIsDeleted(0);
        // 新增轮播图
        int count = slideshowDao.saveSlideshow(slideshowInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * slideshow 查询轮播图列表（分页）
     * @param slideshowInfoVO
     * @return
     * @Author cairuifeng
     * @Date 2020-04-10
     */
    public AppResponse listSlideshow(SlideshowInfoVO slideshowInfoVO) {
        PageHelper.startPage(slideshowInfoVO.getPageNum(), slideshowInfoVO.getPageSize());
        List<SlideshowInfoVO> slideshowInfoVOList = slideshowDao.listSlideshowByPage(slideshowInfoVO);
        // 包装Page对象
        PageInfo<SlideshowInfoVO> pageData = new PageInfo<SlideshowInfoVO>(slideshowInfoVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * slideshow 删除轮播图
     * @param slideshowCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSlideshow(String slideshowCode, String userId) {
        List<String> listCode = Arrays.asList(slideshowCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = slideshowDao.deleteSlideshow(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改轮播图状态
     * @param slideshowCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideshowState(String slideshowCode, String userId, int slideshowState) {
        List<String> listCode = Arrays.asList(slideshowCode.split(","));
        AppResponse appResponse;
        // 修改轮播图状态
        int count = slideshowDao.updateSlideshowState(listCode,userId,slideshowState);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }else {
            if(0 == slideshowState){
                return AppResponse.success("启用成功");
            }
            return AppResponse.success("禁用成功");
        }
    }

    /**
     * demo 查询轮播图详情
     * @param slideshowCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-11
     */
    public AppResponse getSlideshowBySlideshowCode(String slideshowCode) {
        SlideshowInfo slideshowInfo = slideshowDao.getSlideshowBySlideshowCode(slideshowCode);
        return AppResponse.success("查询成功！",slideshowInfo);
    }

    /**
     * slideshow 轮播图查询商品列表（分页）
     * @param slideshowInfoVO1
     * @return
     * @Author cairuifeng
     * @Date 2020-04-16
     */
    public AppResponse listGoods(SlideshowInfoVO1 slideshowInfoVO1) {
        PageHelper.startPage(slideshowInfoVO1.getPageNum(), slideshowInfoVO1.getPageSize());
        List<SlideshowInfoVO1> slideshowInfoVO1List = slideshowDao.listGoodsByPage(slideshowInfoVO1);
        // 包装Page对象
        PageInfo<SlideshowInfoVO1> pageData = new PageInfo<SlideshowInfoVO1>(slideshowInfoVO1List);
        return AppResponse.success("查询成功！",pageData);
    }
}
