package com.jinsc.provider.config;

import com.jinsc.provider.service.LoginService;
import com.jinsc.provider.service.impl.LoginServiceImpl;
import com.jinsc.provider.vo.UserLoginVO;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

/**
 * ws的配置类
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @since Created in 2021/10/21 11:14
 */
@Configuration
public class CxfConfig {
    @Resource
    private LoginService loginService;
    /**
     * 用于注册CXFServlet的
     * 地址/webservice/*
     * * 通配符 更上接口地址
     *
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean<org.apache.cxf.transport.servlet.CXFServlet>
     * @author 金聖聰
     * @email jinshengcong@163.com
     * Modification History:
     * Date         Author        Description        version
     * --------------------------------------------------------*
     * 2021/10/21 11:25    金聖聰     修改原因            1.0
     */
    @Bean
    public ServletRegistrationBean<CXFServlet> dispatcherServlet2() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), loginService);
        endpoint.publish("/loginApi");
        return endpoint;
    }
}
