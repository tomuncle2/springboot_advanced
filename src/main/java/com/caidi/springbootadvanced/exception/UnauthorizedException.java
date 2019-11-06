package com.caidi.springbootadvanced.exception;


import com.caidi.springbootadvanced.enums.ResultCodeEnum;

/**
 * 没有权限异常
 * @Author: zhujunpeng
 * @Date: 2019-01-21 16:21
 * @Version 1.0
 */
public class UnauthorizedException extends RuntimeException {

    private String code;

    private String msg;

    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException(ResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
    }

    public UnauthorizedException(ResultCodeEnum resultCodeEnum, String msg) {
        super(msg);
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getCode();
    }

    public UnauthorizedException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
