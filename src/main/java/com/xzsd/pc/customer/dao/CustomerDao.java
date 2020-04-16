package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-15
 */
@Mapper
public interface CustomerDao {
    /**
     * 获取所有客户信息
     * @param customerInfo 客户信息
     * @return 所有客户信息
     */
    List<CustomerInfo> listCustomersByPage(CustomerInfo customerInfo);
}
