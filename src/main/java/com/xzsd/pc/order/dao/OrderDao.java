package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetailsInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-20
 */
@Mapper
public interface OrderDao {
    /**
     * 获取某订单所有订单详情信息
     * @param orderDetailsInfo 用户详情信息
     * @return 所有用户信息
     */
    List<OrderDetailsInfo> listOrderDetailsByPage(OrderDetailsInfo orderDetailsInfo);

    /**
     * 根据对应角色获取订单信息
     * @param orderInfo 用户详情信息
     * @return 所有用户信息
     */
    List<OrderInfo> listOrderByPage(OrderInfo orderInfo);

    /**
     * 修改订单状态
     * @param listCode 选中的订单编号集合
     * @param userId 更新人
     * @param orderState 订单状态
     * @return 修改结果
     */
    int updateOrderState(@Param("listCode") List<String> listCode, @Param("userId") String userId, @Param("orderState") int orderState);
}
