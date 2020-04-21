package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetailsInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
