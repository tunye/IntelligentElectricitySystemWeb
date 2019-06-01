package com.ct.system.bean.js;

import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by chentong1 on 2019/6/1.
 */
public class Result {
    private static final SerializerFeature[] features = {SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty};
    /**
     * 100 正常
     * 101 异常
     * 102 操作失败
     */
    private int state;
    private int code;
    private String message;
    private Object data;

    public Result(int state, Object data) {
        this.state = state;
        this.data = data;
        this.message = "success";
        code = 200;
    }

    public Result(int state, Object data, String message) {
        this.state = state;
        this.data = data;
        this.message = message;
        if (state == 100 || state == 102) {
            code = 200;
        } else {
            code = 500;
        }
    }

    public static Result successResult(Object data) {
        return new Result(100, data);
    }

    public static Result failResult(Object defaultResult) {
        return new Result(102, defaultResult, "no found");
    }

    public static Result errorResult(String data) {
        return new Result(101, data, data);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
