package com.jinsc.provider.vo;

import lombok.Data;

/**
 * TODO description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @since Created in 2021/10/21 23:28
 */
@Data
public class UserLoginVO {
    private Integer errorCode;
    private String errMsg;
    private String name;
    public UserLoginVO(){
    }
    public UserLoginVO(Integer errorCode,String errMsg,String name){
        this.errorCode = errorCode;
        this.errMsg = errMsg;
        this.name = name;
    }
}
