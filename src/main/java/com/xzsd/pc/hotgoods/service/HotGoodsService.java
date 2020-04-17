package com.xzsd.pc.hotgoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfoVO;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfoVO1;
import com.xzsd.pc.slideshow.entity.SlideshowInfoVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-17
 */
@Service
public class HotGoodsService {

    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * demo 新增热门商品
     * @param hotGoodsInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveHotGoods(HotGoodsInfo hotGoodsInfo) {
        // 校验排序是否存在
        int countHotGoodsSort = hotGoodsDao.countHotGoodsSort(hotGoodsInfo);
        if(0 != countHotGoodsSort) {
            return AppResponse.bizError("热门商品排序冲突，请重新输入！");
        }
        //校验商品是否存在
        int countGoodsCode = hotGoodsDao.countGoodsCode(hotGoodsInfo);
        if(0 != countGoodsCode) {
            return AppResponse.bizError("选择商品重复！");
        }
        hotGoodsInfo.setHotGoodsCode(StringUtil.getCommonCode(2));
        hotGoodsInfo.setIsDeleted(0);
        // 新增热门商品
        int count = hotGoodsDao.saveHotGoods(hotGoodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * hotgoods 查询热门商品列表（分页）
     * @param hotGoodsInfoVO
     * @return
     * @Author cairuifeng
     * @Date 2020-04-17
     */
    public AppResponse listHotGoods(HotGoodsInfoVO hotGoodsInfoVO) {
        PageHelper.startPage(hotGoodsInfoVO.getPageNum(), hotGoodsInfoVO.getPageSize());
        List<HotGoodsInfoVO> hotGoodsInfoVOList = hotGoodsDao.listHotGoodsByPage(hotGoodsInfoVO);
        // 包装Page对象
        PageInfo<HotGoodsInfoVO> pageData = new PageInfo<HotGoodsInfoVO>(hotGoodsInfoVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * hotgoods 删除热门商品
     * @param hotGoodsCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotGoodsCode, String userId) {
        List<String> listCode = Arrays.asList(hotGoodsCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = hotGoodsDao.deleteHotGoods(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * hotgoods 修改热门商品
     * @param hotGoodsInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验排序是否存在
        int countHotGoodsSort = hotGoodsDao.countHotGoodsSort(hotGoodsInfo);
        if(0 != countHotGoodsSort) {
            return AppResponse.bizError("热门商品排序冲突，请重新输入！");
        }
        //校验商品是否存在
        int countGoodsCode = hotGoodsDao.countGoodsCode(hotGoodsInfo);
        if(0 != countGoodsCode) {
            return AppResponse.bizError("选择商品重复！");
        }
        // 修改用户信息
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * hotgoods 查询热门商品详情
     * @param hotGoodsCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-17
     */
    public AppResponse getHotGoodsByHotGoodsCode(String hotGoodsCode) {
        HotGoodsInfo hotGoodsInfo = hotGoodsDao.getHotGoodsByHotGoodsCode(hotGoodsCode);
        return AppResponse.success("查询成功！",hotGoodsInfo);
    }

    /**
     * hotgoods 查询热门商品展示数量
     * @param hotGoodsInfoVO1
     * @return
     * @Author cairuifeng
     * @Date 2020-04-17
     */
    public AppResponse getHotGoodsShowNum(HotGoodsInfoVO1 hotGoodsInfoVO1) {
        List<HotGoodsInfoVO1> hotGoodsInfoVO1List = hotGoodsDao.getHotGoodsShowNum(hotGoodsInfoVO1);
        return AppResponse.success("查询成功！",hotGoodsInfoVO1List);
    }

    /**
     * hotgoods 修改热门商品展示数量
     * @param hotGoodsInfoVO1
     * @return
     * @Author cairuifeng
     * @Date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsShowNum(HotGoodsInfoVO1 hotGoodsInfoVO1) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改用户信息
        int count = hotGoodsDao.updateHotGoodsShowNum(hotGoodsInfoVO1);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
}
