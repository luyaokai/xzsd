package com.xzsd.pc.area.controller;

import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.area.service.AreaService;
import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.goods.entity.GoodsInfoVO1;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-18
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private AreaService areaService;

    /**
     *  省市区下拉框
     *
     * @param areaInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-18
     */
    @RequestMapping(value = "listArea")
    public AppResponse listArea(AreaInfo areaInfo) {
        try {
            return areaService.listArea(areaInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
