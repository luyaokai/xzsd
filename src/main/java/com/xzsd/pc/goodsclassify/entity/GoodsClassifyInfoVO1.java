package com.xzsd.pc.goodsclassify.entity;

/**
 * @author cairfuifeng
 * @date 2020-04-15
 */
public class GoodsClassifyInfoVO1 {
    /**
     * 版本号
     */
    private String version;
    /**
     * 分类代码
     */
    private String classifyCode;
    /**
     * 分类名称
     */
    private String classifyName;

    public String getClassifyName() {return classifyName; }

    public void setClassifyName(String classifyName) {this.classifyName=classifyName; }

    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
