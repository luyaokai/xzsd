package com.xzsd.pc.hotgoods.entity;

import java.util.Date;

public class HotGoodsInfoVO1 {
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
     * 热门商品展示数量
     */
    private int hotGoodsShowNum;

    public int getHotGoodsShowNum() {return  hotGoodsShowNum; }

    public void setHotGoodsShowNum(int hotGoodsShowNum) {this.hotGoodsShowNum = hotGoodsShowNum; }

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
