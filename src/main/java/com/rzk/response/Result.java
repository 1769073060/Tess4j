package com.rzk.response;


import java.io.Serializable;

/**
 * @PackageName : com.rzk.commons.response
 * @FileName : Result 返回状态码
 * @Description :
 * @Author : rzk
 * @CreateTime : 4/5/2021 下午6:07
 * @Version : 1.0.0
 */
public class Result implements Serializable {
    /**
     * 返回代码
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
