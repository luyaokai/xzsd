package com.xzsd.pc.goods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsInfoVO;
import com.xzsd.pc.goods.entity.GoodsInfoVO1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description Goods
 * @author cairuifeng
 * @date 2020-03-27
 */
@Mapper
public interface GoodsDao {
    /**
     * 统计商品是否为轮播图
     * @param goodsCode 商品信息
     * @return
     */
    int countSlideshow(@Param("goodsCode") String goodsCode );

    /**
     * 统计商品是否为热门商品
     * @param goodsCode 商品信息
     * @return
     */
    int countHotGoods(@Param("goodsCode") String goodsCode );

    /**
     * 新增商品
     * @param goodsInfo 商品信息
     * @return
     */
    int saveGoods(GoodsInfo goodsInfo);

    /**
     * 获取所有商品信息
     * @param goodsInfoVO 商品信息
     * @return 所有商品信息
     */
    List<GoodsInfoVO> listGoodsByPage(GoodsInfoVO goodsInfoVO);

    /**
     * 删除商品信息
     * @param listCode 选中的商品编号集合
     * @param userId 更新人
     * @return
     */
    int deleteGoods(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改商品信息
     * @param goodsInfo 商品信息
     * @return 修改结果
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 查询商品信息
     * @param goodsCode 用户编号
     * @return 修改结果
     */
    GoodsInfo getGoodsByGoodsCode(@Param("goodsCode") String goodsCode);

    /**
     * 获取商品分类信息
     * @param goodsInfoVO1 商品分类信息
     * @return 所有商品分类信息
     */
    List<GoodsInfoVO1> listGoodsByClassifyFather(GoodsInfoVO1 goodsInfoVO1);

    /**
     * 修改商品状态
     * @param listCode 选中的商品编号集合
     * @param goodsState 商品状态
     * @param userId 更新人
     * @return 修改结果
     */
    int updateGoodsState(@Param("listCode") List<String> listCode, @Param("userId") String userId,@Param("goodsState") int goodsState);
}
