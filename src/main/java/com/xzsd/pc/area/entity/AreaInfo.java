package com.xzsd.pc.area.entity;

/**
 * 地区下拉框实体类
 * @author cairuifeng
 */
public class AreaInfo {
    /**
     * 分类代码
     */
    private String areaCode;
    /**
     *父类编码  一级分类传0，二级传一级分类code
     */
    private String areaFather;
    /**
     * 分类名称
     */
    private String areaName;

    public String getAreaName() {return areaName; }

    public void setAreaName(String areaName) {this.areaName = areaName; }

    public String getAreaFather() {
        return areaFather;
    }

    public void setAreaFather(String areaFather) {
        this.areaFather = areaFather;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
