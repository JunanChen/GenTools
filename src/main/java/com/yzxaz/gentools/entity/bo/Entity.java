package com.yzxaz.gentools.entity.bo;

import com.yzxaz.gentools.utils.DateUtils;
import com.yzxaz.gentools.utils.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("all")
public class Entity {

    private String className;
    private Set<String> imports = new LinkedHashSet<>();

    private boolean accessors;

    private String author;
    private String email;
    private String time;
    private Set<Field> fields = new LinkedHashSet<>();
    private Set<Entity> clazzs = new LinkedHashSet<>();

    {
        this.imports.add("lombok.Data");
    }

    public Entity setClassName(String className) {
        this.className = humpConvert(className);
        return this;
    }

    public String getTime() {
        return StringUtils.hasText(this.time) ? time : DateUtils.getCurrentTime();
    }

    public String getClassName() {
        return StringUtils.hasText(className) ? className : "ClassName";
    }

    public String getAuthor() {
        return StringUtils.hasText(author) ? author : "No Author";
    }

    public String getEmail() {
        return StringUtils.hasText(email) ? email : "×××@××.com";
    }

    public Set<String> getImports() {
        return imports;
    }

    public void setImports(Set<String> imports) {
        this.imports = imports;
    }

    public boolean isAccessors() {
        return accessors;
    }

    public void setAccessors(boolean accessors) {
        this.accessors = accessors;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    public Set<Entity> getClazzs() {
        return clazzs;
    }

    public void setClazzs(Set<Entity> clazzs) {
        this.clazzs = clazzs;
    }

    public static class Field {
        private String type;
        private String name;
        private String origin_name;

        public Field setType(String type) {
            this.type = humpConvert(type);
            return this;
        }

        public Field setName(String name) {
            name = humpConvert(name);
            this.name = name.substring(0, 1).toLowerCase() + name.substring(1);
            return this;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getOrigin_name() {
            return origin_name;
        }

        public void setOrigin_name(String origin_name) {
            this.origin_name = origin_name;
        }
    }


    /**
     * 驼峰转换
     *
     * @param str
     * @return
     */
    private static String humpConvert(String str) {
        if (StringUtils.hasText(str)) {
            StringBuilder str_ = new StringBuilder();
            for (String str1 : str.split("_")) {
                str_.append(str1.substring(0, 1).toUpperCase() + str1.substring(1));
            }
            return str_.toString();
        }
        return "";
    }

}
