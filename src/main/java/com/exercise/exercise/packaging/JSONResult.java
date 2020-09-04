package com.exercise.exercise.packaging;

public class JSONResult {
    private int code = 0;
    private String msg = "success";
    private Object body;

    public JSONResult() {}

    public JSONResult(Object body) {
        this.body = body;
    }

    public JSONResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JSONResult(String msg, Object body) {
        this.msg = msg;
        this.body = body;
    }

    public static JSONResult success() {
        return new JSONResult();
    }
    public static JSONResult success(String msg) {
        return new JSONResult(0,msg);
    }
    public static JSONResult success(String msg,Object body) {
        return new JSONResult(msg,body);
    }

    public static JSONResult fail(String msg) {
        return new JSONResult(1, msg);
    }

    public static JSONResult fail(Integer code,String msg) {
        return new JSONResult(code, msg);
    }

    public static JSONResult success(Object body) {
        return new JSONResult(body);
    }

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

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
