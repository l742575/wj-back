package com.ida.wj.common;

/**
 * @author lh
 * @date 2020/5/8
 * @description
 */
public class Result {
    private int code;
    private String message;
    private Object data;
    public Result(){

    }
    public Result(int code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(int code,String message){
        this.code = code;
        this.message = message;
    }
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
