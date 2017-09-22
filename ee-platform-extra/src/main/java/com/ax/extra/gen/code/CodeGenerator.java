package com.ax.extra.gen.code;

import com.ax.extra.gen.util.XmlUtil;
import com.google.common.collect.Lists;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/9/14.
 */
public class CodeGenerator {

    public static final String TEMPLATE_DIR = "code-template/";

    public static final String[] TEMPLATE_FILES = {"dao", "service", "controller"};


    public static void generateToFile() {

    }

    public static String generate() {
        return null;
    }


    public List<CodeTemplate> getTemplateList() {

        List<CodeTemplate> collect = Arrays.stream(TEMPLATE_FILES).map(templateFileName -> {
            CodeTemplate template = XmlUtil.fileToObject(TEMPLATE_DIR + File.separator + templateFileName, CodeTemplate.class);
            return template;
        }).filter(Objects::nonNull).collect(Collectors.toList());

        return null;
    }

}
