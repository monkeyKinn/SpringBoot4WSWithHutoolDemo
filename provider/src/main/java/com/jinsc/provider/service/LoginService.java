package com.jinsc.provider.service;

import com.jinsc.provider.vo.UserLoginVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * ws的登录接口
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @since Created in 2021/10/21 11:01
 */
@WebService(name = "LoginService", //暴露服务名称
        targetNamespace = "http://jinsc.com" //空间名称
)
public interface LoginService {
    UserLoginVO userLogin(@WebParam(name = "name") String name);
}
