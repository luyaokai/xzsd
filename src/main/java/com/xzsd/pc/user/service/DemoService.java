package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.user.dao.DemoDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserInfoVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author cairuifeng
 * @Date 2020-03-25
 */
@Service
public class DemoService {

    @Resource
    private DemoDao demoDao;

    /**
     * demo 新增用户
     * @param userInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveUser(UserInfo userInfo) {
        // 校验账号是否存在
        int countUserAcct = demoDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        userInfo.setUserPwd(PasswordUtils.generatePassword(userInfo.getUserPwd()));
        // 新增用户
        int count = demoDao.saveUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询用户列表（分页）
     * @param userInfoVO
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    public AppResponse listUsers(UserInfoVO userInfoVO) {
        PageHelper.startPage(userInfoVO.getPageNum(), userInfoVO.getPageSize());
        List<UserInfoVO> userInfoVOList = demoDao.listUsersByPage(userInfoVO);
        // 包装Page对象
        PageInfo<UserInfoVO> pageData = new PageInfo<UserInfoVO>(userInfoVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 删除用户
     * @param userCode
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode, String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = demoDao.deleteUser(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改用户
     * @param userInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = demoDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        userInfo.setUserPwd(PasswordUtils.generatePassword(userInfo.getUserPwd()));
        // 修改用户信息
        int count = demoDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询用户详情
     * @param userCode
     * @return
     * @Author cairuifeng
     * @Date 2020-03-21
     */
    public AppResponse getUserByUserCode(String userCode) {
        UserInfo userInfo = demoDao.getUserByUserCode(userCode);
        return AppResponse.success("查询成功！",userInfo);
    }
}