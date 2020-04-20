package com.xzsd.pc.goods.entity;

import java.util.Date;

public class GoodsInfoVO {
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
     * 商品名称
     */
    private String goodsName;
    /**
     * 定价
     */
    private String pricing;
    /**
     *售价
     */
    private String sellPrice;
    /**
     *
     * 商品编号
     */
    private String goodsCode;
    /**
     *销售量
     */
    private String sellSum;
    /**
     * 一级分类名称
     */
    private String firstName;
    /**
     * 二级分类名称
     */
    private String secondName;
    /**
     * 广告词
     */
    private String goodsMessage;
    /**
     * 商品状态 0在售，1已下架，2未发布
     */
    private String goodsState;
    /**
     * 上架时间
     */
    private String sellTime;
    /**
     * 浏览量
     */
    private String seeSum;
    /**
     * 商家名称
     */
    private String merchantName;
    /**
     * 库存
     */
    private String goodsSum;
    /**
     * 书号
     */
    private String goodsIsbn;
    /**
     * 出版社
     */
    private String goodsPress;
    /**
     * 作者
     */
    private String goodsAuthor;
    /**
     * 商品图片路径
     */
    private String imagePath;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getImagePath() { return imagePath;}

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
    }

    public String getGoodsIsbn() {
        return goodsIsbn;
    }

    public void setGoodsIsbn(String goodsIsbn) {
        this.goodsIsbn = goodsIsbn;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(String goodsSum) {
        this.goodsSum = goodsSum;
    }

    public String getSeeSum() {
        return seeSum;
    }

    public void setSeeSum(String seeSum) {
        this.seeSum = seeSum;
    }

    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }

    public String getGoodsMessage() {
        return goodsMessage;
    }

    public void setGoodsMessage(String goodsMessage) {
        this.goodsMessage = goodsMessage;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSellSum() {
        return sellSum;
    }

    public void setSellSum(String sellSum) {
        this.sellSum = sellSum;
    }
    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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
}
