package com.xzsd.pc.goodsclassify.dao;

import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfo;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfoVo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-14
 */
@Mapper
public interface GoodsClassifyDao {

    /**
     * 统计一级分类下的二级分类数量
     * @param classifyCode 商品分类信息
     * @return
     */
    int countSecondClassify(@Param("classifyCode") String classifyCode);

    /**
     * 统计二级分类下商品数量
     * @param classifyCode 商品分类信息
     * @return
     */
    int countGoods(@Param("classifyCode") String classifyCode);

    /**
     * 新增商品分类
     * @param goodsClassifyInfo 商品分类信息
     * @return
     */
    int saveGoodsClassify(GoodsClassifyInfo goodsClassifyInfo);

    /**
     * 获取所有商品分类信息
     * @param goodsClassifyInfoVo 商品分类信息
     * @return 所有商品分类信息
     */
    List<GoodsClassifyInfoVo> listGoodsClassify(GoodsClassifyInfoVo goodsClassifyInfoVo);

    /**
     * 删除商品分类信息
     * @param listCode 选中的商品分类编号集合
     * @param userId 更新人
     * @return
     */
    int deleteGoodsClassify(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改商品分类信息
     * @param goodsClassifyInfo 商品分类信息
     * @return 修改结果
     */
    int updateGoodsClassify(GoodsClassifyInfo goodsClassifyInfo);

    /**
     * 查询商品分类信息
     * @param classifyCode 商品分类编号
     * @return 修改结果
     */
    GoodsClassifyInfo getGoodsClassifyByClassifyCode(@Param("classifyCode") String classifyCode);
}
