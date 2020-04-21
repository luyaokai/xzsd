package com.xzsd.pc.order.controller;

import com.xzsd.pc.order.entity.OrderDetailsInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.user.controller.DemoController;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-20
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private OrderService orderService;

    /**
     * demo 订单详情列表(分页)
     *
     * @param orderDetailsInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @RequestMapping(value = "listOrderDetails")
    public AppResponse listOrderDetails(OrderDetailsInfo orderDetailsInfo) {
        try {
            return orderService.listOrderDetails(orderDetailsInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * order 订单列表(分页)
     *
     * @param orderInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
            */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderInfo orderInfo) {
        try {
            return orderService.listOrder(orderInfo);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     *
     * @param orderCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-20
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String orderCode, int orderState) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return orderService.updateOrderState(orderCode,userId,orderState);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
