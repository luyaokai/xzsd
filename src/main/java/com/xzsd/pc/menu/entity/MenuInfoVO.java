package com.xzsd.pc.menu.entity;

/**
 * @author cairuifeng
 * @date 2020-04-18
 */
public class MenuInfoVO {
    /**
     * 版本号
     */
    private String version;
    /**
     * 菜单编码
     */
    private String menuCode;
    /**
     * 菜单名称
     */
    private String menuName;

    public String getMenuName() {return menuName; }

    public void setMenuName(String menuName ) {this.menuName = menuName; }

    public String getMenuCode() {return menuCode; }

    public void setMenuCode(String menuCode ) { this.menuCode = menuCode; }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
