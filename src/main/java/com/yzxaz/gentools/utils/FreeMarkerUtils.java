package com.yzxaz.gentools.utils;


import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import groovy.util.logging.Slf4j;

import java.util.Locale;

@Slf4j
@SuppressWarnings("all")
public class FreeMarkerUtils {

    private static Configuration cfg = new Configuration(Configuration.getVersion());

    static {
        cfg.setEncoding(Locale.CHINA, "utf-8");
        cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtils.class, "/templates"));
    }

    /**
     * 获取模板
     *
     * @param templateName
     * @return
     */
    public static Template getTemplate(String templateName) {
        try {
            Template template = cfg.getTemplate(templateName);
            return template;
        } catch (Exception e) {
            return null;
        }
    }
}
