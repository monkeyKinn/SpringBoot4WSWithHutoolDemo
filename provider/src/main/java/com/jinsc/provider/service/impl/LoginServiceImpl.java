package com.jinsc.provider.service.impl;

import com.jinsc.provider.service.LoginService;
import com.jinsc.provider.vo.UserLoginVO;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * ws的登录接口实现类
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @since Created in 2021/10/21 11:05
 */
@WebService(serviceName = "LoginService", // 与接口中的name保持一致
        targetNamespace = "http://jinsc.com", // 与接口中的name保持一致
        endpointInterface = "com.jinsc.provider.service.LoginService" // 接口包路径
)
// 用于配置类自动注入
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public UserLoginVO userLogin(@WebParam(name = "name") String name) {
        return new UserLoginVO(500, "登录失败~~", name);
    }


}
