package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    /**
     * 部分参数的构造函数
     * @param code
     * @param message
     */
    public CommonResult(int code, String message) {
        this(code,message,null);
    }

}
