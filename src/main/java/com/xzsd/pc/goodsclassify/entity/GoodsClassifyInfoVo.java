package com.xzsd.pc.goodsclassify.entity;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-13
 */
public class GoodsClassifyInfoVo {
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
    /**
     * 二级列表信息
     */
    private List<GoodsClassifyInfoVO1> secondList;

    public List<GoodsClassifyInfoVO1> getSecondList() {return secondList; }

    public void setSecondList(List<GoodsClassifyInfoVO1> secondList){ this.secondList = secondList; }

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
