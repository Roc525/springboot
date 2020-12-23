package com.mengxuegu.springboot.utils;

import java.lang.reflect.Method;

public class AjaxResult {
    private int code;
    private String message;
    private Object data;
    private int total;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public AjaxResult() {
    }

    public AjaxResult(MessageConstants messageConstants) {
        this.code = messageConstants.getCode();
        this.message = messageConstants.getMessage();
    }

    public AjaxResult(MessageConstants messageConstants, Object data) {
        this.code = messageConstants.getCode();
        this.message = messageConstants.getMessage();
        this.data = data;
    }

    public AjaxResult(MessageConstants messageConstants, Object data, int total) {
        this.code = messageConstants.getCode();
        this.message = messageConstants.getMessage();
        this.data = data;
        this.total = total;
    }

    public AjaxResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public <T> AjaxResult(T eEnum) {
        try {
            Class aClass = eEnum.getClass();
            Method method = aClass.getMethod("getMessage", (Class[])null);
            String msg = (String)method.invoke(eEnum, (Object[])null);
            method = aClass.getMethod("getCode", (Class[])null);
            int code = (Integer)method.invoke(eEnum, (Object[])null);
            this.message = msg;
            this.code = code;
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public <T> AjaxResult(T eEnum, Object result) {
        try {
            Class aClass = eEnum.getClass();
            Method method = aClass.getMethod("getMessage", (Class[])null);
            String msg = (String)method.invoke(eEnum, (Object[])null);
            method = aClass.getMethod("getCode", (Class[])null);
            int code = (Integer)method.invoke(eEnum, (Object[])null);
            this.message = msg;
            this.code = code;
            this.data = result;
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public <T> AjaxResult(T eEnum, Object result, int total) {
        try {
            Class aClass = eEnum.getClass();
            Method method = aClass.getMethod("getMessage", (Class[])null);
            String msg = (String)method.invoke(eEnum, (Object[])null);
            method = aClass.getMethod("getCode", (Class[])null);
            int code = (Integer)method.invoke(eEnum, (Object[])null);
            this.message = msg;
            this.code = code;
            this.data = result;
            this.total = total;
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}
