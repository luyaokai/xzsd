package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetailsInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-20
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * demo 查询列表详情列表（分页）
     * @param orderDetailsInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    public AppResponse listOrderDetails(OrderDetailsInfo orderDetailsInfo) {
        PageHelper.startPage(orderDetailsInfo.getPageNum(), orderDetailsInfo.getPageSize());
        List<OrderDetailsInfo> orderDetailsInfoList = orderDao.listOrderDetailsByPage(orderDetailsInfo);
        // 包装Page对象
        PageInfo<OrderDetailsInfo> pageData = new PageInfo<OrderDetailsInfo>(orderDetailsInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * order 根据角色查询列表详情
     * @param orderInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    public AppResponse listOrder(OrderInfo orderInfo) {
        orderInfo.setUserId(AuthUtils.getCurrentUserId());
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfo> orderInfoList = orderDao.listOrderByPage(orderInfo);
        // 包装Page对象
        PageInfo<OrderInfo> pageData = new PageInfo<OrderInfo>(orderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 修改订单状态
     * @param orderCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(String orderCode, String userId, int orderState) {
        List<String> listCode = Arrays.asList(orderCode.split(","));
        AppResponse appResponse = AppResponse.success("修改成功！");
        // 修改订单状态
        int count = orderDao.updateOrderState(listCode,userId,orderState);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return AppResponse.success("订单状态修改成功");

    }
}
