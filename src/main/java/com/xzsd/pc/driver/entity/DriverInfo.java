package com.xzsd.pc.driver.entity;

import java.util.Date;

/**
 * 司机实体类
 * @author cairuifeng
 * @date 2020-04-20
 */
public class DriverInfo {
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
     * 用户密码
     */
    private String userPwd;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 用户头像
     */
    private String imagePath;
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
     * 省名称
     */
    private String provinceName;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区名称
     */
    private String areaName;

    public String getAreaName() {return areaName;}

    public void setAreaName(String areaName) {this.areaName = areaName; }

    public String getCityName() {return cityName; }

    public void setCityName(String cityName ) {this.cityName = cityName; }

    public String getProvinceName() {return provinceName; }

    public void setProvinceName(String provinceName) { this.provinceName = provinceName; }

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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
