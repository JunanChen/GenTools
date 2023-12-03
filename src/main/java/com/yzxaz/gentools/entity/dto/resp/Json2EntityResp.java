package com.yzxaz.gentools.entity.dto.resp;

/**
 * <p>
 *      json 2 entity 请求对象
 * <p>
 *
 * @author 一只小安仔
 * @name Json2EntityReq
 * @date 2023/12/3 11:53
 * @since 1.0.0
 */
public class Json2EntityResp {

    private Integer code;

    private String msg;

    private String data;

    public Integer getCode() {
        return code;
    }

    public Json2EntityResp code(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Json2EntityResp msg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getData() {
        return data;
    }

    public Json2EntityResp data(String data) {
        this.data = data;
        return this;
    }
}
