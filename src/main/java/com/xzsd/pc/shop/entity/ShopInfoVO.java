package com.xzsd.pc.shop.entity;

/**
 * @author cairfuifeng
 * @date 2020-04-19
 */
public class ShopInfoVO {
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
     * 角色编号
     */
    private String role;
    /**
     * 门店账号(店长账号）
     */
    private String userAcct;
    /**
     * 门店账号(店长账号）
     */
    private String userCode;
    /**
     * 店长名字（用户名字)
     */
    private String userName;
    /**
     * 登陆角色编号
     */
    private String userId;

    public String getUserId() {return userId; }

    public void setUserId(String userId) {this.userId = userId; }

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName; }

    public String getUserAcct() {return userAcct;}

    public void setUserAcct(String userAcct) {this.userAcct = userAcct; }

    public String getRole() {return role; }

    public void setRole(String role) {this.role = role; }

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
