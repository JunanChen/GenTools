
<#list imports as impt>
import ${impt};
</#list>


/**
 * 类<code>${className}</code>说明：
 *
 * @author ${author}
 * @email ${email}
 * @since ${time}
 */
@Data
<#if accessors?? && accessors == true>
@Accessors(chain = true)
</#if>
public class ${className} {
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
}