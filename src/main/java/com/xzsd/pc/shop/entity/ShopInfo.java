package com.xzsd.pc.shop.entity;

import java.util.Date;

/**
 * 门店实体类
 * @author cairuifeng
 * @date 2020-04-19
 */
public class ShopInfo {
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
     * 门店账号
     */
    private String shopCode;
    /**
     * 门店名称
     */
    private String shopName;
    /**
     * 门店电话
     */
    private String shopTel;
    /**
     * 门店地址
     */
    private String shopAddress;
    /**
     * 店长编码（用户编码）
     */
    private String userCode;
    /**
     * 邀请码
     */
    private String inviteCode;
    /**
     * 省编号
     */
    private String provinceCode;
    /**
     * 市编号
     */
    private String cityCode;
    /**
     * 区编号
     */
    private String areaCode;
    /**
     * 营业执照编码
     */
    private String businessCode;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市名称
     */
    private String cityName;

    public String getCityName() {return cityName; }

    public void setCityName(String cityName ) {this.cityName = cityName; }

    public String getProvinceName() {return provinceName; }

    public void setProvinceName(String provinceName) { this.provinceName = provinceName; }

    public String getBusinessCode() {return businessCode; }

    public void setBusinessCode(String businessCode) {this.businessCode = businessCode;}

    public String getAreaCode() {return areaCode; }

    public void setAreaCode(String areaCode) {this.areaCode = areaCode;}

    public String getCityCode() {return cityCode;}

    public void setCityCode(String cityCode) {this.cityCode = cityCode; }

    public String getProvinceCode() {return provinceCode; }

    public void setProvinceCode(String provinceCode) {this.provinceCode = provinceCode;}

    public String getInviteCode() {return inviteCode; }

    public void setInviteCode(String inviteCode) {this.inviteCode = inviteCode;}

    public String getUserCode() {return userCode; }

    public void setUserCode(String userCode) {this.userCode = userCode;}

    public String getShopAddress() {return shopAddress; }

    public void setShopAddress(String shopAddress) {this.shopAddress = shopAddress;}

    public String getShopTel() {return shopTel;}

    public void setShopTel(String shopTel) {this.shopTel = shopTel;}

    public String getShopName() {return shopName;};

    public void setShopName(String shopName) {this.shopName = shopName;}

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {this.shopCode = shopCode; }

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
