package com.xzsd.pc.hotgoods.entity;

import java.util.Date;

/**
 * 热门商品实体类
 * @author cairfuieng
 * @date 2020-04-17
 */
public class HotGoodsInfo {
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
     * 热门商品排序
     */
    private int hotGoodsSort;
    /**
     * 热门商品便号
     */
    private String hotGoodsCode;
    /**
     * 绑定商品编号
     */
    private String goodsCode;

    public String getGoodsCode() {return  goodsCode;}

    public void setGoodsCode(String goodsCode) {this.goodsCode =goodsCode;}

    public String getHotGoodsCode() {return hotGoodsCode; }

    public void setHotGoodsCode(String hotGoodsCode) {this.hotGoodsCode = hotGoodsCode; }

    public int getHotGoodsSort() {return hotGoodsSort; }

    public void setHotGoodsSort(int hotGoodsSort) {this.hotGoodsSort =hotGoodsSort; }

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
