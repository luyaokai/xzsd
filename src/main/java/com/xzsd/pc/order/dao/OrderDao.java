package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetailsInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;

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
}
