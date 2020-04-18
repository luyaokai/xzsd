package com.xzsd.pc.topOfColumn.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfoVO1;
import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-18
 */
public interface TopOfColumnDao {

    /**
     * 获取登陆用户用户信息
     * @param userId 登陆用户
     * @return
     */
    TopOfColumnInfo getTopOfColumn(@Param("userId") String userId);
}
