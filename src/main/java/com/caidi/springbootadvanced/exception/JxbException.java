package com.caidi.springbootadvanced.exception;


import com.caidi.springbootadvanced.enums.ResultCodeEnum;

/**
 * 通用异常
 * @Author: caidi
 * @Date: file/11/24 12:36
 * @Version 1.0
 */
public class JxbException extends RuntimeException{
    private String code;

    private String msg;

    public JxbException(String msg) {
        super(msg);
    }

    public JxbException(ResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
    }

    public JxbException(ResultCodeEnum resultCodeEnum, String msg) {
        super(msg);
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getCode();
    }

    public JxbException(String code, String msg) {
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
