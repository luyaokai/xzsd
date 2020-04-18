package com.xzsd.pc.topOfColumn.service;

import com.xzsd.pc.topOfColumn.dao.TopOfColumnDao;
import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-18
 */
@Service
public class TopOfColumnService {

    @Resource
    private TopOfColumnDao topOfColumnDao;

    /**
     *topOfColumn 查询顶部栏用户
     *
     * @param userId
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-15
     */
    public AppResponse getTopOfColumn(String userId){
        TopOfColumnInfo topOfColumnInfo = topOfColumnDao.getTopOfColumn(userId);
        return AppResponse.success("查询成功",topOfColumnInfo);
    }

}
