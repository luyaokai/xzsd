package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfoVO;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfoVO1;
import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-17
 */
@Mapper
public interface HotGoodsDao {
    /**
     * 统计商品编号数量
     * @param hotGoodsInfo 热门商品信息
     * @return
     */
    int countGoodsCode(HotGoodsInfo hotGoodsInfo);
    /**
     * 统计热门商品排序数量
     * @param hotGoodsInfo 热门商品信息
     * @return
     */
    int countHotGoodsSort(HotGoodsInfo hotGoodsInfo);

    /**
     * 新增热门商品
     * @param hotGoodsInfo 热门商品信息
     * @return
     */
    int saveHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 获取所有热门商品信息
     * @param hotGoodsInfoVO 热门商品信息
     * @return 所有热门商品信息
     */
    List<HotGoodsInfoVO> listHotGoodsByPage(HotGoodsInfoVO hotGoodsInfoVO);

    /**
     * 删除热门商品信息
     * @param listCode 选中的热门商品编号集合
     * @param userId 更新人
     * @return
     */
    int deleteHotGoods(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改热门商品信息
     * @param hotGoodsInfo 热门商品信息
     * @return 修改结果
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门商品信息
     * @param hotGoodsCode 热门商品编号
     * @return 修改结果
     */
    HotGoodsInfo getHotGoodsByHotGoodsCode(@Param("hotGoodsCode") String hotGoodsCode);

    /**
     * 获取热门商品展示数量
     *
     * @return 热门商品展示数量
     */
    HotGoodsInfoVO1 getHotGoodsShowNum();

    /**
     * 修改热门商品展示数量
     * @param hotGoodsInfoVO1 热门商品战术数量信息
     * @return 修改结果
     */
    int updateHotGoodsShowNum(HotGoodsInfoVO1 hotGoodsInfoVO1);

}
