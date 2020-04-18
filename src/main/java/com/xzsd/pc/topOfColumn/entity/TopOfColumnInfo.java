package com.xzsd.pc.topOfColumn.entity;

/**
 * 顶部栏用户信息实体类
 * @author cairuifeng
 */
public class TopOfColumnInfo {
    /**
     *用户姓名
     */
    private String userName;
    /**
     * 用户头像图片路径
     */
    private String imagePath;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户角色编号 ：0管理员、1店长、 2客户 、3司机
     */
    private String role;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRole() { return role; }

    public void setRole(String role) {this.role=role; }
}
