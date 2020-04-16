package com.xzsd.pc.slideshow.dao;

import com.xzsd.pc.goods.entity.GoodsInfoVO;
import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-10
 */
@Mapper
public interface SlideshowDao {
    /**
     * 统计轮播图排序数量
     * @param slideshowInfo 轮播图信息
     * @return
     */
    int countSlideshowSort(SlideshowInfo slideshowInfo);

    /**
     * 新增轮播图
     * @param slideshowInfo 轮播图信息
     * @return
     */
    int saveSlideshow(SlideshowInfo slideshowInfo);

    /**
     * 获取所有轮播图信息
     * @param slideshowInfoVO 轮播图信息
     * @return 所有轮播图信息
     */
    List<SlideshowInfoVO> listSlideshowByPage(SlideshowInfoVO slideshowInfoVO);

    /**
     * 删除轮播图图信息
     * @param listCode 选中的轮播图编号集合
     * @param userId 更新人
     * @return
     */
    int deleteSlideshow(List<String> listCode, @Param("userId") String userId);

    /**
     * 修改轮播图状态
     * @param listCode 选中的轮播图编号集合
     * @param userId 更新人
     * @param slideshowState 轮播图状态
     * @return 修改结果
     */
    int updateSlideshowState(List<String> listCode, @Param("userId") String userId, int slideshowState);

    /**
     * 查询轮播图信息
     * @param slideshowCode 轮播图编号
     * @return 修改结果
     */
    SlideshowInfo getSlideshowBySlideshowCode(@Param("slideshowCode") String slideshowCode);

    /**
     * 获取所有商品信息
     * @param slideshowInfoVO1 商品信息
     * @return 所有商品信息
     */
    List<SlideshowInfoVO1> listGoodsByPage(SlideshowInfoVO1 slideshowInfoVO1);
}
