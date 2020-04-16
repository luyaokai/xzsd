package com.xzsd.pc.goodsclassify.entity;

import java.util.Date;

/**
 * 商品分类实体类
 * @author cairuifeng
 * @date 2020-04-13
 */
public class GoodsClassifyInfo {
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
     * 分类代码
     */
    private String classifyCode;
    /**
     *父类编码  一级分类传0，二级传一级分类code
     */
    private String classifyFather;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 分类备注
     */
    private String classifyComment;

    public String getClassifyComment() {return classifyComment; }

    public void setClassifyComment(String classifyComment) {this.classifyComment=classifyComment;}

    public String getClassifyName() {return classifyName; }

    public void setClassifyName(String classifyName) {this.classifyName=classifyName; }

    public String getClassifyFather() {
        return classifyFather;
    }

    public void setClassifyFather(String classifyFather) {
        this.classifyFather = classifyFather;
    }

    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode;
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
