package com.xzsd.pc.area.dao;

import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.goods.entity.GoodsInfoVO1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cairuifeng
 */
@Mapper
public interface AreaDao {

    /**
     * 获取省市区信息
     * @param areaInfo 省市区信息
     * @return 省市区信息
     */
    List<AreaInfo> listArea(AreaInfo areaInfo);

}
