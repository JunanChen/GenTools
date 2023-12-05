package com.yzxaz.gentools.exception;


public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 123123123122L;

    private Integer code;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
