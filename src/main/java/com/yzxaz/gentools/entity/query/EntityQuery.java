package com.yzxaz.gentools.entity.query;

public class EntityQuery {

    private String className;
    private String author;
    private String email;
    private String dataJson;

    private Boolean serialize2Origin;
    private Boolean swagger;
    private Boolean accessors;

    public EntityQuery() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public Boolean getSerialize2Origin() {
        return serialize2Origin;
    }

    public void setSerialize2Origin(Boolean serialize2Origin) {
        this.serialize2Origin = serialize2Origin;
    }

    public Boolean getSwagger() {
        return swagger;
    }

    public void setSwagger(Boolean swagger) {
        this.swagger = swagger;
    }

    public Boolean getAccessors() {
        return accessors;
    }

    public void setAccessors(Boolean accessors) {
        this.accessors = accessors;
    }
}
