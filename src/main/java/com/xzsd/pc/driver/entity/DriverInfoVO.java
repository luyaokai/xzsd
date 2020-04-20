package com.xzsd.pc.driver.entity;

import java.util.Date;

/**
 * @author cairuifeng
 * @date 2020-04-20
 */
public class DriverInfoVO {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 用户代码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户登录名
     */
    private String userAcct;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 版本号
     */
    private String version;
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
     * 角色
     */
    private String role;
    /**
     * 登陆角色编号
     */
    private String userId;

    public String getUserId() {return userId; }

    public void setUserId(String userId) {this.userId = userId; }

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

    public String getRole() {return role; }

    public void setRole(String role) {this.role = role; }

    public String getAreaCode() {return areaCode; }

    public void setAreaCode(String areaCode) {this.areaCode = areaCode;}

    public String getCityCode() {return cityCode;}

    public void setCityCode(String cityCode) {this.cityCode = cityCode; }

    public String getProvinceCode() {return provinceCode; }

    public void setProvinceCode(String provinceCode) {this.provinceCode = provinceCode;}


    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
