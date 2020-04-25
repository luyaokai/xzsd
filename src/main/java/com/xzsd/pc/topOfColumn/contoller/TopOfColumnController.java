package com.xzsd.pc.topOfColumn.contoller;

import com.xzsd.pc.topOfColumn.service.TopOfColumnService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
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
@RequestMapping("/topOfColumn")
public class TopOfColumnController {

    private static final Logger logger = LoggerFactory.getLogger(TopOfColumnController.class);

    @Resource
    private TopOfColumnService topOfColumnService;

    /**
     * topOfColumn 登陆用户信息
     *
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-18
     */
    @RequestMapping(value = "getTopOfColumn")
    public AppResponse getTopOfColumn() {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return topOfColumnService.getTopOfColumn(userId);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
