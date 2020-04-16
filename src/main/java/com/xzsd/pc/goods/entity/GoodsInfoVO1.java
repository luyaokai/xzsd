package com.xzsd.pc.goods.entity;

/**
 * 商品下拉框商品分类实体类
 * @author cairuifeng
 * @date 2020-04-14
 */
public class GoodsInfoVO1 {
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

}

