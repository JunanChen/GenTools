<#if fields??>
 <#list fields as field>
  <#if field.origin_name??>

  @JSONField(name = "${field.origin_name}")
  </#if>
  private ${field.type} ${field.name};

 </#list>

</#if>
<#if clazzs??>
 <#list  clazzs as clazz>
  @Data
  public static class ${clazz.className} {

  <#if clazz.fields??>
   <#list clazz.fields as field>
    <#if field.origin_name??>

    @JSONField(name = "${field.origin_name}")
    </#if>
    private ${field.type} ${field.name};

   </#list>

  </#if>
  }

 </#list>
</#if>