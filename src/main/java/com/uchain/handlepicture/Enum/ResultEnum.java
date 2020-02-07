package com.uchain.handlepicture.Enum;

import lombok.Getter;

/**
 * @Author: LZH
 * @Date: 2019/9/29 下午12:20
 * @Description:
 */
@Getter
public enum ResultEnum {
    /**
     *
     */
    SUCCESS(0, "成功"),
    ERROR(1, "失败");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
