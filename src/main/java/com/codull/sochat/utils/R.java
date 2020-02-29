package com.codull.sochat.utils;

import lombok.Data;

/**
 * @program: sochat
 * @description:
 * @author: anthony1314
 * @create: 2020-02-25 14:32
 **/
@Data
public class R {

    private int code = 200;

    private String msg = "success";

    private Object data;

    public R() {
        super();
    }

    public R(Object data) {
        super();
        this.data = data;
    }

    public R(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
