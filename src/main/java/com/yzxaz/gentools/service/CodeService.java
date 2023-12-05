package com.yzxaz.gentools.service;


import com.yzxaz.gentools.entity.query.EntityQuery;

import java.rmi.ServerException;

public interface CodeService {

    String convertJson2Entity(String jsonStr, boolean serialize2Origin) throws ServerException;

    String convertJson2Entity(String jsonStr, boolean serialize2Origin, String className, String author, String email
            , boolean accessors, String templateFile) throws ServerException;

    String convertJson2Entity(EntityQuery entityQuery) throws ServerException;

    String convertJson2EntityField(EntityQuery entityQuery) throws ServerException;

}

