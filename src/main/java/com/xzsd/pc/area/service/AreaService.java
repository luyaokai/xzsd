package com.xzsd.pc.area.service;

import com.xzsd.pc.area.dao.AreaDao;
import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.goods.entity.GoodsInfoVO1;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-18
 */
@Service
public class AreaService {

    @Resource
    private AreaDao areaDao;

    /**
     * area 查询商品分类下拉框
     * @param areaInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-18
     */
    public AppResponse listArea(AreaInfo areaInfo) {
        List<AreaInfo> areaInfoList = areaDao.listArea(areaInfo);
        return AppResponse.success("查询成功！",areaInfoList);
    }
}
