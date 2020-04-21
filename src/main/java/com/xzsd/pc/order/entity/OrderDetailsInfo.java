package com.xzsd.pc.order.entity;

/**
 * 订单详情实体类
 * @author cairuifeng
 * @date 2020-04-21
 */
public class OrderDetailsInfo {
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
     * 用户编码
     */
    private String userCode;
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 购买数量
     */
    private String bugSum;
    /**
     * 订单详情总金额
     */
    private String orderDetailsCost;
    /**
     * 售价
     */
    private String sellPrice;
    /**
     * 定价
     */
    private String pricing;

    public String getPricing() {return pricing;}

    public void setPricing(String pricing) {this.pricing = pricing; }

    public String getSellPrice() {return sellPrice; }

    public void setSellPrice(String sellPrice) {this.sellPrice = sellPrice;}

    public String getOrderDetailsCost() {return orderDetailsCost;}

    public void setOrderDetailsCost(String orderDetailsCost) {this.orderDetailsCost = orderDetailsCost;}

    public String getBugSum() {return bugSum; }

    public void setBugSum(String bugSum) {this.bugSum = bugSum; }

    public String getGoodsName() {return goodsName; }

    public void setGoodsName(String goodsName) {this.goodsName = goodsName; }

    public String getGoodsCode() {return goodsCode; }

    public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode;}

    public String getOrderCode() {return orderCode; }

    public void setOrderCode(String orderCode) {this.orderCode = orderCode; }

    public String getUserCode() {return userCode; }

    public void setUserCode(String userCode) {this.userCode = userCode; }

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
