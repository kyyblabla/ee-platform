package com.ax.extra.gen.util;

import com.ax.common.tool.util.FileUtilsExt;
import com.ax.extra.gen.model.GenScheme;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by kyy on 2017/10/27.
 */
public class GenUtil {


    private static List<String> getTemplates() {
        List<String> templates = Lists.newArrayList();
        templates.add("template/Entity.java");
        templates.add("template/Dao.java");
        templates.add("template/Service.java");
        templates.add("template/Controller.java");
        return templates;
    }

    public static void generatorCode(GenScheme genScheme, ZipOutputStream zip) {
        //根据模板生成代码
        getTemplates().forEach(templatePathName -> {
            //渲染代码模板
            try {
                String codeTemplate = FileUtilsExt.readClassPathFileToString(templatePathName);
                String codeContent = FreeMarkers.renderString(codeTemplate, genScheme);
                addEntityToZip(getSavePathNameFromScheme(genScheme, FileUtilsExt.getFileNameFormPathName(templatePathName)), codeContent, zip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void addEntityToZip(String fileName, String content, ZipOutputStream zip) throws IOException {
        //添加到zip
        zip.putNextEntry(new ZipEntry(fileName));
        IOUtils.write(content.toString(), zip, "UTF-8");
        zip.closeEntry();
    }


    /**
     * 通过scheme获取绝对存储路径
     * 路径规则：src/源码根路径/基础包名.模块名[.子模块名].代码模板类型.文件名称.java
     *
     * @param scheme
     * @return
     */
    private static String getSavePathNameFromScheme(GenScheme scheme, String codeTemplateFileName) {

        String filePath = StringUtils.join(
                "src",
                File.separator, "main",
                File.separator, "java",
                File.separator, scheme.getPackageName(),
                File.separator, scheme.getModuleName(),
                File.separator, StringUtils.trimToEmpty(scheme.getSubModuleName())
        );
        filePath = StringUtils.replacePattern(filePath, "//|\\\\", File.separator);
        filePath = StringUtils.replacePattern(filePath, "\\.", File.separator);

        String fileName = StringUtils.join(scheme.getTable().getClassName(), codeTemplateFileName.replace("Entity.java", ".java"));
        return StringUtils.join(filePath, File.separator, fileName);
    }


}
