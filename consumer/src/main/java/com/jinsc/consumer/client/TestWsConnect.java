package com.jinsc.consumer.client;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.http.webservice.SoapClient;
import com.jinsc.consumer.dto.UserLoginDto;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 测试ws连接
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @since Created in 2021/10/21 23:35
 */
public class TestWsConnect {
    public static void main(String[] args) {
        // 新建客户端
        // SoapClient client = SoapClient.create("http://localhost:8080/webservice/loginApi?wsdl")
        SoapClient client = SoapClient.create("http://1.15.1.193:8080/webservice/loginApi?wsdl")
                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
                .setMethod("jin:userLogin", "http://jinsc.com")
                .setParam("name","jinshengcong3080ti",false);
        // 设置参数，此处自动添加方法的前缀：web

        // 发送请求，参数true表示返回一个格式化后的XML内容
        // 返回内容为XML字符串，可以配合XmlUtil解析这个响应
        String send = client.send(true);
        Console.log(send);
        Document document = XmlUtil.parseXml(send);
        List<String> nameList = Arrays.asList("errMsg","errorCode","name");
        HashMap<String, String> resultMap = new HashMap<>();
        nameList.forEach(e->{
            String result =(String) XmlUtil.getByXPath("//return/" + e, document, XPathConstants.STRING);
            resultMap.put(e,result);
        });
        Console.log(resultMap);
        UserLoginDto convert = Convert.convert(UserLoginDto.class, resultMap);
        Console.log(convert);

    }
}
