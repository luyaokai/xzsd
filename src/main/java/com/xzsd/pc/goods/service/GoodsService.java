package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsInfoVO;
import com.xzsd.pc.goods.entity.GoodsInfoVO1;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 实现类
 * @author cairuifeng
 * @date 2020-03-27
 */
@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;
    /**
     * goods 新增商品
     * @param goodsInfo
     * @Author cairuifeng
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoods(GoodsInfo goodsInfo) {
        goodsInfo.setGoodsCode(StringUtil.getCommonCode(2));
        goodsInfo.setIsDeleted(0);
        // 新增商品
        int count = goodsDao.saveGoods(goodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询商品列表（分页）
     * @param goodsInfoVO
     * @return
     * @Author cairuifeng
     * @Date 2020-04-05
     */
    public AppResponse listGoods(GoodsInfoVO goodsInfoVO) {
        PageHelper.startPage(goodsInfoVO.getPageNum(), goodsInfoVO.getPageSize());
        List<GoodsInfoVO> goodsInfoVOList = goodsDao.listGoodsByPage(goodsInfoVO);
        // 包装Page对象
        PageInfo<GoodsInfoVO> pageData = new PageInfo<GoodsInfoVO>(goodsInfoVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 删除用户
     * @param goodsCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode, String userId) {
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = goodsDao.deleteGoods(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改商品
     * @param goodsInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-08
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改商品信息
        int count = goodsDao.updateGoods(goodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询商品详情
     * @param goodsCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-08
     */
    public AppResponse getGoodsByGoodsCode(String goodsCode) {
        GoodsInfo goodsInfo = goodsDao.getGoodsByGoodsCode(goodsCode);
        return AppResponse.success("查询成功！",goodsInfo);
    }

    /**
     * goods 查询商品分类下拉框
     * @param goodsInfoVO1
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    public AppResponse listGoodsClassify(GoodsInfoVO1 goodsInfoVO1) {
        List<GoodsInfoVO1> goodsInfoVO1List = goodsDao.listGoodsByClassifyFather(goodsInfoVO1);
        return AppResponse.success("查询成功！",goodsInfoVO1List);
    }

    /**
     * demo 修改商品状态
     * @param goodsCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsState(String goodsCode, String userId, int goodsState) {
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        AppResponse appResponse;
        // 修改轮播图状态
        int count = goodsDao.updateGoodsState(listCode,userId,goodsState);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }else {
            if(0 == goodsState){
                return AppResponse.success("上架成功");
            }
            return AppResponse.success("下架成功");
        }
    }
}
