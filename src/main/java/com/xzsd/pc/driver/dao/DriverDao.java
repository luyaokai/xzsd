package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverInfoVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-20
 */
@Mapper
public interface DriverDao {
    /**
     * 统计用户账号数量
     * @param driverInfo 用户信息
     * @return
     */
    int countUserAcct(DriverInfo driverInfo);

    /**
     * 新增用户
     * @param driverInfo 用户信息
     * @return
     */
    int saveDriver(DriverInfo driverInfo);

    /**
     * 获取所有司机信息
     * @param driverInfoVO 司机信息
     *
     * @return 该地区所有司机信息
     */
    List<DriverInfoVO> listDriverByPage(DriverInfoVO driverInfoVO);

    /**
     * 删除用户信息
     * @param listCode 选中的司机编号集合
     * @param userId 更新人
     * @return
     */
    int deleteDriver(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改司机信息
     * @param driverInfo 司机信息
     * @return 修改结果
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 查询司机信息
     * @param userCode 用户编号
     * @return 用户信息
     */
    DriverInfo getUserByUserCode(@Param("userCode") String userCode);
}
