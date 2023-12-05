package com.yzxaz.gentools.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzxaz.gentools.entity.bo.Entity;
import com.yzxaz.gentools.entity.query.EntityQuery;
import com.yzxaz.gentools.service.CodeService;
import com.yzxaz.gentools.utils.FreeMarkerUtils;
import com.yzxaz.gentools.utils.StringUtils;
import freemarker.template.Template;

import java.io.StringWriter;
import java.rmi.ServerException;
import java.util.Map;

@SuppressWarnings("all")
public class CodeServiceImpl implements CodeService {

    /**
     * jackson
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertJson2Entity(String jsonStr, boolean serialize2Origin) throws ServerException {
        return convertJson2Entity(jsonStr, serialize2Origin, null, null, null, false, "entity.ftl");
    }

    @Override
    public String convertJson2Entity(EntityQuery entityQuery) throws ServerException {
        return convertJson2Entity(entityQuery.getDataJson(),
                entityQuery.getSerialize2Origin(),
                entityQuery.getClassName(),
                entityQuery.getAuthor(),
                entityQuery.getEmail(),
                entityQuery.getAccessors(),
                "entity.ftl");
    }

    @Override
    public String convertJson2EntityField(EntityQuery entityQuery) throws ServerException {
        return convertJson2Entity(entityQuery.getDataJson(),
                entityQuery.getSerialize2Origin(),
                entityQuery.getClassName(),
                entityQuery.getAuthor(),
                entityQuery.getEmail(),
                entityQuery.getAccessors(),
                "entity-filed.ftl");
    }

    @Override
    public String convertJson2Entity(String jsonStr, boolean serialize2Origin,
                                     String className, String author,
                                     String email, boolean accessors, String templateFile) throws ServerException {

        String resutl = "";

        if (!StringUtils.hasText(jsonStr)) return resutl;

        try {

            Entity rootEntity = new Entity();

            rootEntity.setAccessors(accessors);
            rootEntity.setClassName(className);
            rootEntity.setAuthor(author);
            rootEntity.setEmail(email);

            if (accessors) {
                rootEntity.getImports().add("lombok.experimental.Accessors");
            }

            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            processChild(rootEntity, rootEntity, jsonObject, serialize2Origin);

            Template template = FreeMarkerUtils.getTemplate(templateFile);

            StringWriter writer = new StringWriter();

            template.process(rootEntity, writer);

            resutl = writer.getBuffer().toString();

            writer.close();

            return resutl;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("not json, covert failed, => " + e.getMessage());
        }
    }

    private void processChild(Entity rootEntity, Entity parentEntity, JSONObject jsonObject, boolean serialize2Origin) {

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            Integer type = judgeObjectType(value);

            Entity.Field field = new Entity.Field();

            if (serialize2Origin) {
                field.setOrigin_name(key);
                rootEntity.getImports().add("com.alibaba.fastjson.annotation.JSONField");
            }

            if (type == 0) {
                field.setType(key).setName(field.getType());

                addClazz(rootEntity, entry, serialize2Origin);
            } else if (type == 1) {

                String listFieldType = getListFieldType((JSONArray) value, key);

                field.setType(
                        StringUtils.hasText(listFieldType) ? listFieldType : key
                ).setName(key);

                addClazz(rootEntity, entry, serialize2Origin);
            } else if (type == 2) {
                field.setName(key).setType(value.getClass().getSimpleName());

                if (Integer.class.getSimpleName().equals(field.getType())) {
                    field.setType(Long.class.getSimpleName());
                }

                parentEntity.getImports().add(value.getClass().getName());
            }

            parentEntity.getFields().add(field);

        }
    }

    private String getListFieldType(JSONArray jsonArray, String key) {

        String fieldType = "";
        Object obj = new Object();

        if (jsonArray.size() == 0) {
            obj = null;
        } else {
            obj = jsonArray.get(0);
        }

        if (obj == null){
            fieldType = "List";
        } else if (judgeObjectType(obj) == 0) {
            // TODO: 2022/8/4  
            fieldType = "List<" + firstLetterUppercase(key) + ">";
        } else if (judgeObjectType(obj) == 2) {
            fieldType = "List<" + obj.getClass().getSimpleName() + ">";
        } else if (judgeObjectType(obj) == 1) {
//            fieldType = "List<" + getListFieldType((JSONArray) obj) + ">";
        }

        return fieldType;
    }

    /**
     * ⽅法<code>firstLetterUppercase</code>说明: 
     *
     * @param key 
     * @return java.lang.String
     * @author yanglei
     * @since 2022/10/10
     */
    public String firstLetterUppercase(String key) {
        String firstLetter = key.substring(0, 1);
        return key.replaceFirst(firstLetter, firstLetter.toUpperCase());
    }

    /**
     * 添加 static class
     *
     * @param entity
     * @param entry
     * @param serialize2Origin
     */
    private void addClazz(Entity rootEntity, Map.Entry<String, Object> entry, boolean serialize2Origin) {
        String key = entry.getKey();
        Object value = entry.getValue();

        JSONObject jsonObject = null;

        if (judgeObjectType(value) == 0) {
            jsonObject = (JSONObject) value;
        } else if (judgeObjectType(value) == 1) {
            JSONArray jsonArray = (JSONArray) value;

            for (int i = 0; i < jsonArray.size(); i++) {
                Object o = jsonArray.get(i);

                if (o instanceof JSONObject) {

                    if (jsonObject == null) {
                        jsonObject = new JSONObject();
                    }

                    JSONObject jsonObject1 = (JSONObject) o;
                    for (Map.Entry<String, Object> en : jsonObject1.entrySet()) {
                        if (!jsonObject.containsKey(en.getKey())) {
                            jsonObject.put(en.getKey(), en.getValue());
                        }
                    }
                }
            }
        }

        if (jsonObject != null) {
            Entity childEntity = new Entity();
            childEntity.setClassName(key);
            processChild(rootEntity, childEntity, jsonObject, serialize2Origin);
            rootEntity.getClazzs().add(childEntity);
        }
    }

    /**
     * @param obj
     * @return
     */
    private Integer judgeObjectType(Object obj) {

        if (obj instanceof JSONObject) {
            return 0;
        } else if (obj instanceof JSONArray) {
            return 1;
        } else {
            return 2;
        }
    }
}
