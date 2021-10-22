package com.jinsc.provider.config;

import com.jinsc.provider.service.LoginService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
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
        // 这里就是发布服务的跟路径,后面 * 是通配符,表示跟什么都行
        return new ServletRegistrationBean<>(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        // 建立一个端点 ,第一个参数是 springBus 对象,第二个参数是刚才的接口实现类(因为在实现类中用了@service,所以这里可以自动注入)
        // PS: 要是有多个service,这个方法对象多写几个就行
        EndpointImpl endpoint = new EndpointImpl(springBus(), loginService);
        endpoint.publish("/loginApi");
        return endpoint;
    }
}
