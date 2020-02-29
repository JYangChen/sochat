package com.codull.sochat.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: sochat
 * @description:
 * @author: anthony1314
 * @create: 2020-02-25 14:27
 **/

public class GlobalException  extends RuntimeException {


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public GlobalException(String message) {
        this.msg = message;
    }
}