package com.xzsd.pc.slideshow.entity;

import java.util.Date;

/**
 * 轮播图实体类
 * @author cairuifeng
 * @date 2020-04-10
 */
public class SlideshowInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date createTime1;
    /**
     * 创建者
     */
    private String createUser1;
    /**
     * 更新时间
     */
    private Date updateTime1;
    /**
     * 更新者
     */
    private String updateUser1;
    /**
     * 版本号
     */
    private String version;
    /**
     * 排序
     */
    private int slideshowSort;
    /**
     * 状态 0启用 1禁用
     */
    private String slideshowState;
    /**
     * 有效期起
     */
    private String workTime;
    /**
     * 有效期止
     */
    private String deadTime;
    /**
     * 轮播图编号
     */
    private String slideshowCode;
    /**
     * 选择的商品编号
     */
    private String goodsCode;
    /**
     * 商品图片路径
     */
    private String imagePath;

    public String getImagePath() { return imagePath;}

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getGoodsCode() {return goodsCode; }

    public void setGoodsCode(String goodsCode) {this.goodsCode=goodsCode; }

    public String getSlideshowCode() {return slideshowCode; }

    public void setSlideshowCode(String slideshowCode) {this.slideshowCode=slideshowCode; }

    public String getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(String deadTime) {
        this.deadTime = deadTime;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getSlideshowState() {
        return slideshowState;
    }

    public void setSlideshowState(String slideshowState) {
        this.slideshowState = slideshowState;
    }

    public int getSlideshowSort() {
        return slideshowSort;
    }

    public void setSlideshowSort(int slideshowSort) {
        this.slideshowSort = slideshowSort;
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
    }

    public String getCreateUser1() {
        return createUser1;
    }

    public void setCreateUser1(String createUser1) {
        this.createUser1 = createUser1;
    }

    public Date getUpdateTime1() {
        return updateTime1;
    }

    public void setUpdateTime1(Date updateTime1) {
        this.updateTime1 = updateTime1;
    }

    public String getUpdateUser1() {
        return updateUser1;
    }

    public void setUpdateUser1(String updateUser1) {
        this.updateUser1 = updateUser1;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
