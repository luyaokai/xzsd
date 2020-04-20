package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverInfoVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairufieng
 * @date 2020-04-20
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    /**
     * driver 新增司机
     * @param driverInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveDriver(DriverInfo driverInfo) {
        // 校验账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        driverInfo.setUserCode(StringUtil.getCommonCode(2));
        driverInfo.setIsDeleted(0);
        driverInfo.setUserPwd(PasswordUtils.generatePassword(driverInfo.getUserPwd()));
        // 新增司机
        int count = driverDao.saveDriver(driverInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * driver 查询司机列表（分页）
     * @param driverInfoVO
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    public AppResponse listDriver(DriverInfoVO driverInfoVO) {
        driverInfoVO.setUserId(AuthUtils.getCurrentUserId());
        PageHelper.startPage(driverInfoVO.getPageNum(), driverInfoVO.getPageSize());
        List<DriverInfoVO> driverInfoVOList = driverDao.listDriverByPage(driverInfoVO);
        // 包装Page对象
        PageInfo<DriverInfoVO> pageData = new PageInfo<DriverInfoVO>(driverInfoVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * driver 删除司机
     * @param userCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String userCode, String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = driverDao.deleteDriver(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * driver 修改司机
     * @param driverInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        driverInfo.setUserPwd(PasswordUtils.generatePassword(driverInfo.getUserPwd()));
        // 修改用户信息
        int count = driverDao.updateDriver(driverInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * driver 查询司机详情
     * @param userCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-20
     */
    public AppResponse getUserByUserCode(String userCode) {
        DriverInfo driverInfo = driverDao.getUserByUserCode(userCode);
        return AppResponse.success("查询成功！",driverInfo);
    }
}
