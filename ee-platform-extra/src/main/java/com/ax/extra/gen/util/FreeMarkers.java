package com.ax.extra.gen.util;

import com.ax.common.util.Exceptions;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;


/**
 * FreeMarkers工具类
 * Created by kyy on 2017/9/14.
 */
public class FreeMarkers {


    public static String renderString(String templateString, Map<String, Object> model) {
        return renderString(templateString, model);
    }

    public static String renderString(String templateString, Object model) {
        try {
            Template t = new Template("none", new StringReader(templateString), new Configuration());
            return renderTemplate(t, model);
        } catch (IOException e) {
            throw Exceptions.unchecked(e);
        }
    }

    public static String renderTemplate(Template template, Object model) {
        try {
            StringWriter result = new StringWriter();
            template.process(model, result);
            return result.toString();
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

}
