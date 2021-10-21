package com.jinsc.consumer.dto;

import lombok.Data;

/**
 * TODO description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @since Created in 2021/10/21 23:36
 */
@Data
public class UserLoginDto {
    private String errMsg;
    private String name;
    private String errorCode;
}
