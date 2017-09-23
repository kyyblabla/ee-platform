package com.ax.extra.gen.code;

import com.ax.common.util.FileUtils;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.model.GenTable;
import com.ax.extra.gen.util.FreeMarkers;
import com.ax.extra.gen.util.XmlUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/9/14.
 */
@Slf4j
public class CodeGenerator {

    public static final String TEMPLATE_DIR = "code-template";

    public static final String[] TEMPLATE_FILES = {"dao", "service", "controller"};

    private String baseDir = "/Users/kyy/test";

    /**
     * 通过模板生成代码
     *
     * @param scheme           scheme定义
     * @param codeTemplate     代码模板
     * @param codeTemplateType 代码模板类型 :
     *                         entity:"",null
     *                         dao:Dao,DaoTest
     *                         service:Service,ServiceTest
     *                         controller:Controller,ControllerTest
     */
    public String generateTemplateToFile(GenScheme scheme, String codeTemplate, String codeTemplateType) {

        String savePathName = getSavePathNameFromScheme(scheme, codeTemplateType);

        if (scheme.getReplaceFile()) {
            FileUtils.deleteFile(savePathName);
        }
        // 创建并写入文件
        if (FileUtils.createFile(savePathName)) {
            String content = FreeMarkers.renderString(codeTemplate, scheme);
            FileUtils.writeToFile(savePathName, content);
            log.debug("文件创建成功{}", savePathName);
            return savePathName;
        } else {
            log.debug("文件创建失败{}", savePathName);
        }
        return null;
    }

    public List<String> getCodeTemplates() {
        return null;
    }

    public void generate(GenScheme scheme) {
        List<String> codeTemplates = getCodeTemplates();
        codeTemplates.forEach(codeTemplate -> generateTemplateToFile(scheme, codeTemplate, ""));
    }


    /**
     * 通过scheme获取绝对存储路径
     *
     * @param scheme
     * @return
     */
    private String getSavePathNameFromScheme(GenScheme scheme, String codeTemplateType) {
        String filePath = StringUtils.join(baseDir,
                File.separator, scheme.getPackageName(),
                File.separator, scheme.getModuleName(),
                File.separator, StringUtils.trimToEmpty(scheme.getSubModuleName()));
        filePath = StringUtils.replacePattern(filePath, "/$|\\$", "");
        filePath = StringUtils.replacePattern(filePath, "//|\\\\", File.separator);
        filePath = StringUtils.replacePattern(filePath, "\\.", File.separator);
        String fileName = StringUtils.join(scheme.getClassName(), StringUtils.capitalize(StringUtils.trimToEmpty(codeTemplateType)), ".java");
        return filePath + File.separator + fileName;
    }

}
