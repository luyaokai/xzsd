package com.xzsd.pc.order.entity;

/**
 * 订单实体类
 * @author cairuifeng
 * @date 2020-04-21
 */
public class OrderInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 版本号
     */
    private String version;
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 订单总价
     */
    private String orderCost;
    /**
     * 订单状态:0已下单，1已取消，2已到货，3已取货，4已完成未评价，5已完成已评价
     */
    private String orderState;
    /**
     * 门店编码
     */
    private String shopCode;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 下单人手机号
     */
    private String phone;
    /**
     * 确认付款时间
     */
    private String payTime;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 登陆人编码
     */
    private String userId;
    /**
     * 角色
     */
    private String role;
    /**
     * 付款时间起
     */
    private String payTimeStart;
    /**
     * 付款时间止
     */
    private String payTimeEnd;

    public String getPayTimeEnd() {return payTimeEnd; }

    public void setPayTimeEnd(String payTimeEnd) {this.payTimeEnd = payTimeEnd;}

    public String getPayTimeStart() {return payTimeStart;}

    public void setPayTimeStart(String payTimeStart) {this.payTimeStart = payTimeStart;}

    public String getRole() {return role; }

    public void setRole(String role) {this.role = role; }

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public String getUserCode() {return userCode;}

    public void setUserCode(String userCode) {this.userCode = userCode;}

    public String getPayTime() {return payTime;}

    public void setPayTime(String payTime) {this.payTime = payTime; }

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getUserName() {return userName; }

    public void setUserName(String userName) {this.userName = userName; }

    public String getShopCode() {return shopCode;}

    public void setShopCode(String shopCode) {this.shopCode = shopCode; }

    public String getOrderState() {return orderState; }

    public void setOrderState(String orderState) {this.orderState = orderState; }

    public String getOrderCost() {return orderCost; }

    public void setOrderCost(String orderCost) {this.orderCost=orderCost; }

    public String getOrderCode() {return orderCode; }

    public void setOrderCode(String orderCode) {this.orderCode = orderCode; }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
