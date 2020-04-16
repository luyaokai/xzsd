package com.xzsd.pc.slideshow.entity;

/**
 * @author cairuifeng
 * @Description 轮播图实体类
 * @date 2020-04-10
 */
public class SlideshowInfoVO {
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
     * 排序
     */
    private int slideshowSort;
    /**
     * 状态 0启用 1禁用
     */
    private int slideshowState;
    /**
     * 有效期起
     */
    private String workTime;
    /**
     * 有效期止
     */
    private String deadTime;
    /**
     * 轮播图编号
     */
    private String slideshowCode;
    /**
     * 轮播图路径
     */
    private String imagePath;

    public String getImagePath() { return imagePath;}

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getSlideshowCode() {return slideshowCode; }

    public void setSlideshowCode(String slideshowCode) {this.slideshowCode=slideshowCode; }

    public String getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(String deadTime) {
        this.deadTime = deadTime;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public int getSlideshowState() {
        return slideshowState;
    }

    public void setSlideshowState(int slideshowState) {
        this.slideshowState = slideshowState;
    }

    public int getSlideshowSort() {
        return slideshowSort;
    }

    public void setSlideshowSort(int slideshowSort) {
        this.slideshowSort = slideshowSort;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
