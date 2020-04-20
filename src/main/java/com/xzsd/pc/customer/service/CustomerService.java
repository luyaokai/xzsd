package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-15
 */
@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    /**
     * demo 查询客户列表（分页）
     * @param customerInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-15
     */
    public AppResponse listCustomer(CustomerInfo customerInfo) {
        customerInfo.setUserId(AuthUtils.getCurrentUserId());
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        List<CustomerInfo> customerInfosList = customerDao.listCustomersByPage(customerInfo);
        // 包装Page对象
        PageInfo<CustomerInfo> pageData = new PageInfo<CustomerInfo>(customerInfosList);
        return AppResponse.success("查询成功！",pageData);
    }
}
