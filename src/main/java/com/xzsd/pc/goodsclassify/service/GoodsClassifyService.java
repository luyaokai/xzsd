package com.xzsd.pc.goodsclassify.service;

import com.xzsd.pc.goodsclassify.dao.GoodsClassifyDao;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfo;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfoVo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-14
 */
@Service
public class GoodsClassifyService {

    @Resource
    private GoodsClassifyDao goodsClassifyDao;

    /**
     * 新增商品分类
     * @param goodsClassifyInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoodsClassify(GoodsClassifyInfo goodsClassifyInfo) {
        goodsClassifyInfo.setClassifyCode(StringUtil.getCommonCode(2));
        goodsClassifyInfo.setIsDeleted(0);
        // 新增商品分类
        int count = goodsClassifyDao.saveGoodsClassify(goodsClassifyInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 删除商品分类
     * @param classifyCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsClassify(String classifyCode, String userId) {
        List<String> listCode = Arrays.asList(classifyCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 校验一级排序下是否存在二级排序
        int countSecondClassify = goodsClassifyDao.countSecondClassify(classifyCode);
        if(0 < countSecondClassify) {
            return AppResponse.bizError("删除失败，分类下有二级分类");
        }
        //校验分类下是否有商品
        int countGoods = goodsClassifyDao.countGoods(classifyCode);
        if(0 < countGoods) {
            return AppResponse.bizError("删除失败，该分类下有商品");
        }
        // 删除商品分类
        int count = goodsClassifyDao.deleteGoodsClassify(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改商品分类
     * @param goodsClassifyInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsClassify(GoodsClassifyInfo goodsClassifyInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改商品分类信息
        int count = goodsClassifyDao.updateGoodsClassify(goodsClassifyInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询商品分类详情
     * @param classifyCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    public AppResponse getGoodsClassifyByClassifyCode(String classifyCode) {
        GoodsClassifyInfo goodsClassifyInfo = goodsClassifyDao.getGoodsClassifyByClassifyCode(classifyCode);
        return AppResponse.success("查询成功！",goodsClassifyInfo);
    }

    /**
     * 查询商品分类列表
     * @param goodsClassifyInfoVo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    public AppResponse listGoodsClassify(GoodsClassifyInfoVo goodsClassifyInfoVo) {
        List<GoodsClassifyInfoVo>  goodsClassifyInfoVoList = goodsClassifyDao.listGoodsClassify(goodsClassifyInfoVo);
        return AppResponse.success("查询成功！",goodsClassifyInfoVoList);
    }
}
