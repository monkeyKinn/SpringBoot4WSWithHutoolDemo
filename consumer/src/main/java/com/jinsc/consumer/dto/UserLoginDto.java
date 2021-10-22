package com.jinsc.consumer.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @since Created in 2021/10/21 23:36
 */
@Data
public class UserLoginDto implements Serializable {
    private static final long serialVersionUID = 1292974846576856351L;
    private String errMsg;
    private String name;
    private String errorCode;
}
