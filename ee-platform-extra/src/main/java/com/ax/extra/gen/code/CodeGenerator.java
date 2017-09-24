package com.ax.extra.gen.code;

import com.ax.common.util.FileUtils;
import com.ax.extra.gen.model.GenConfig;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.util.FreeMarkers;
import com.ax.extra.gen.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by kyy on 2017/9/14.
 */
@Slf4j
public class CodeGenerator {

    private String baseDir;

    private GenConfig genConfig;

    public static final String CODE_TEMPLATE_BASE_DIR = "code-template";

    public CodeGenerator(GenConfig genConfig, String baseDir) {
        this.genConfig = genConfig;
        this.baseDir = baseDir;
    }

    public CodeGenerator(String baseDir) {
        this(XmlUtil.fileToObject(CODE_TEMPLATE_BASE_DIR + File.separator + "config.xml", GenConfig.class), baseDir);
    }

    /**
     * 通过模板生成代码
     *
     * @param scheme           scheme定义
     * @param templatePathName 模板文件路径
     * @throws IOException
     */
    public void generateTemplateToFile(GenScheme scheme, String templatePathName) throws IOException {

        String templateType = CodeGeneratorHelper.getTemplateTypeFromPathName(templatePathName);
        String savePathName = getSavePathNameFromScheme(scheme, templateType);

        if (scheme.getReplaceFile()) {
            FileUtils.deleteFile(savePathName);
        }
        // 创建并写入文件
        if (FileUtils.createFile(savePathName)) {
            String codeTemplate = FileUtils.readClassPathFileToString(CODE_TEMPLATE_BASE_DIR + File.separator + templatePathName);
            String content = FreeMarkers.renderString(codeTemplate, scheme);
            FileUtils.writeToFile(savePathName, content);
            log.debug("文件创建成功{}", savePathName);
        } else {
            log.debug("文件创建失败{}", savePathName);
        }

    }


    public List<String> getTemplatePathNamesByGenPlan(String genPlan) {
        List<String> templatePathNames = CodeGeneratorHelper.getTemplatePathNamesByGenPlan(genConfig, genPlan);
        return templatePathNames;
    }

    /**
     * @param scheme
     */
    public void generate(GenScheme scheme) {

        List<String> templatePathNames = getTemplatePathNamesByGenPlan(scheme.getGenPlan());
        if (templatePathNames.isEmpty()) {
            log.warn("{}未找到生成类别{}包含的模板文件", scheme.getName(), scheme.getGenPlan());
            return;
        }

        templatePathNames.forEach(templatePathName -> {
            try {
                generateTemplateToFile(scheme, templatePathName);
            } catch (Exception e) {
                log.error("代码文件{}生成失败", templatePathName);
                log.error(e.getMessage(), e);
            }
        });
    }

    /**
     * 通过scheme获取绝对存储路径
     * 路径规则：src/源码根路径/基础包名.模块名[.子模块名].代码模板类型.文件名称.java
     *
     * @param scheme
     * @return
     */
    private String getSavePathNameFromScheme(GenScheme scheme, String codeTemplateType) {

        String filePath = StringUtils.join(
                baseDir,
                File.separator, "src",
                File.separator, getSourceRootPath(codeTemplateType),
                File.separator, scheme.getPackageName(),
                File.separator, scheme.getModuleName(),
                File.separator, StringUtils.trimToEmpty(scheme.getSubModuleName()),
                File.separator, getSourceFunctionPath(codeTemplateType));

        filePath = StringUtils.replacePattern(filePath, "//|\\\\", File.separator);
        filePath = StringUtils.replacePattern(filePath, "\\.", File.separator);
        String fileName = StringUtils.join(scheme.getClassName(), StringUtils.capitalize(StringUtils.trimToEmpty(codeTemplateType)), ".java");
        return filePath + File.separator + fileName;
    }

    /**
     * 获取代码功能包路径
     * 如：entity、dao、service
     *
     * @param codeTemplateType
     * @return
     */
    private String getSourceFunctionPath(String codeTemplateType) {
        if (StringUtils.startsWith("Controller", codeTemplateType)) {
            return "controller";
        } else if (StringUtils.startsWith("Service", codeTemplateType)) {
            return "service";
        } else if (StringUtils.startsWith("Dao", codeTemplateType)) {
            return "dao";
        } else {
            return "entity";
        }
    }

    /**
     * 根据源码根路径，区分主代码与测试代码
     * ：如：main test
     *
     * @param codeTemplateType
     * @return
     */
    private String getSourceRootPath(String codeTemplateType) {
        return StringUtils.endsWith(codeTemplateType, "Test") ? "test" : "main";
    }

}
