package com.yzxaz.gentools.entity.dto.req;


/**
 * <p>
 *      json 2 entity 请求对象
 * <p>
 *
 * @author  一只小安仔
 * @name    Json2EntityReq
 * @date    2023/12/3 11:53
 * @since   1.0.0
 */
public class Json2EntityReq {
    private String dataJson;
    private Boolean accessors = Boolean.FALSE;
    private String author = "一只小安仔";
    private String className = "ClassName";
    private Boolean serialize2Origin = Boolean.FALSE;
    private String email = "×××@×××.com";
    private Boolean swagger = Boolean.FALSE;

    public String getDataJson() {
        return dataJson;
    }

    public Json2EntityReq dataJson(String dataJson) {
        this.dataJson = dataJson;
        return this;
    }

    public Boolean getAccessors() {
        return accessors;
    }

    public Json2EntityReq accessors(Boolean accessors) {
        this.accessors = accessors;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Json2EntityReq author(String author) {
        this.author = author;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Json2EntityReq className(String className) {
        this.className = className;
        return this;
    }

    public Boolean getSerialize2Origin() {
        return serialize2Origin;
    }

    public Json2EntityReq serialize2Origin(Boolean serialize2Origin) {
        this.serialize2Origin = serialize2Origin;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Json2EntityReq email(String email) {
        this.email = email;
        return this;
    }

    public Boolean getSwagger() {
        return swagger;
    }

    public Json2EntityReq swagger(Boolean swagger) {
        this.swagger = swagger;
        return this;
    }
}
