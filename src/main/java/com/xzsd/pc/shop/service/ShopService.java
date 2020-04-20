package com.xzsd.pc.shop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.shop.dao.ShopDao;
import com.xzsd.pc.shop.entity.ShopInfo;
import com.xzsd.pc.shop.entity.ShopInfoVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairfuifeng
 * @date 2020-04-20
 */
@Service
public class ShopService {

    @Resource
    private ShopDao shopDao;

    /**
     * shop 新增门店
     * @param shopInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveShop(ShopInfo shopInfo) {
        // 校验店长是否存在
        int countUserCode = shopDao.countUserCode(shopInfo);
        if(1 != countUserCode) {
            return AppResponse.bizError("用户编号不存在，请重新输入！");
        }
        shopInfo.setShopCode(StringUtil.getCommonCode(2));
        shopInfo.setIsDeleted(0);
        // 新增门店
        int count = shopDao.saveShop(shopInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * shop 查询门店列表（分页）
     * @param shopInfoVO
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    public AppResponse listShop(ShopInfoVO shopInfoVO) {
        PageHelper.startPage(shopInfoVO.getPageNum(), shopInfoVO.getPageSize());
        List<ShopInfoVO> shopInfoVOList = shopDao.listShopByPage(shopInfoVO);
        // 包装Page对象
        PageInfo<ShopInfoVO> pageData = new PageInfo<ShopInfoVO>(shopInfoVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * shop 删除门店
     * @param shopCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShop(String shopCode, String userId) {
        List<String> listCode = Arrays.asList(shopCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除门店
        int count = shopDao.deleteShop(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * shop 修改门店
     * @param shopInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShop(ShopInfo shopInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验编号是否存在
        int countUserCode = shopDao.countUserCode(shopInfo);
        if(1 != countUserCode) {
            return AppResponse.bizError("用户编码不存在，请重新输入！");
        }
        // 修改门店信息
        int count = shopDao.updateShop(shopInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * shop 查询门店详情
     * @param shopCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    public AppResponse getShopByShopCode(String shopCode) {
        ShopInfo shopInfo = shopDao.getShopByShopCode(shopCode);
        return AppResponse.success("查询成功！",shopInfo);
    }
}
