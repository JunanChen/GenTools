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

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public Boolean getAccessors() {
        return accessors;
    }

    public void setAccessors(Boolean accessors) {
        this.accessors = accessors;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Boolean getSerialize2Origin() {
        return serialize2Origin;
    }

    public void setSerialize2Origin(Boolean serialize2Origin) {
        this.serialize2Origin = serialize2Origin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSwagger() {
        return swagger;
    }

    public void setSwagger(Boolean swagger) {
        this.swagger = swagger;
    }
}
