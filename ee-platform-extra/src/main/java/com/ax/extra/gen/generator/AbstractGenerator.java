package com.ax.extra.gen.generator;

import com.ax.common.tool.util.FileUtilsExt;
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
 * Created by kyy on 2017/10/23.
 */
@Slf4j
public abstract class AbstractGenerator {


    protected String baseDir;
    protected GenConfig genConfig;
    public static final String CODE_TEMPLATE_BASE_DIR = "gen-plan";

    public AbstractGenerator(String baseDir) {
        this.baseDir = baseDir;
        this.genConfig = XmlUtil.fileToObject("gen-config-default.xml", GenConfig.class);
        GenConfig userConfig = XmlUtil.fileToObject("gen-config.xml", GenConfig.class);
        if (userConfig != null && userConfig.getPlans() != null) {
            this.genConfig.getPlans().addAll(userConfig.getPlans());
        }
    }

    public void generate(GenScheme scheme) {
        onStart(scheme);
        List<String> templatePathNames = getTemplatePathNamesByGenPlan(scheme.getGenPlan());
        if (templatePathNames.isEmpty()) {
            log.warn("{}未找到生成类别{}包含的模板文件", scheme.getName(), scheme.getGenPlan());
            return;
        }
        templatePathNames.forEach(templatePathName -> {
            try {
                String codeContent = generateCodeFromScheme(scheme, templatePathName);
                onGenerated(scheme, templatePathName, codeContent);
            } catch (Exception e) {
                log.error("代码{}生成失败", templatePathName);
                log.error(e.getMessage(), e);
            }
        });
        onFinished(scheme);
    }

    protected void onStart(GenScheme genScheme) {
    }

    protected abstract void onGenerated(GenScheme genScheme, String templateName, String coneContent);

    protected void onFinished(GenScheme genScheme) {
    }

    /**
     * 通过模板生成代码
     *
     * @param scheme           scheme定义
     * @param templatePathName 模板文件路径
     * @throws IOException
     */
    public String generateCodeFromScheme(GenScheme scheme, String templatePathName) throws IOException {
        //渲染代码模板
        String codeTemplate = FileUtilsExt.readClassPathFileToString(CODE_TEMPLATE_BASE_DIR + File.separator + templatePathName);
        return FreeMarkers.renderString(codeTemplate, scheme);
    }

    /**
     * 通过scheme获取绝对存储路径
     * 路径规则：src/源码根路径/基础包名.模块名[.子模块名].代码模板类型.文件名称.java
     *
     * @param scheme
     * @return
     */
    protected String getSavePathNameFromScheme(GenScheme scheme, String codeTemplateName) {
        String codeTemplateType = CodeGeneratorHelper.getTemplateTypeFromPathName(codeTemplateName);
        String filePath = StringUtils.join(
                "src",
                File.separator, getSourceRootPath(codeTemplateType),
                File.separator, "java",
                File.separator, scheme.getPackageName(),
                File.separator, scheme.getModuleName(),
                File.separator, StringUtils.trimToEmpty(scheme.getSubModuleName()),
                File.separator, getSourceFunctionPath(codeTemplateType));

        filePath = StringUtils.replacePattern(filePath, "//|\\\\", File.separator);
        filePath = StringUtils.replacePattern(filePath, "\\.", File.separator);
        String fileName = StringUtils.join(scheme.getTable().getClassName(), StringUtils.capitalize(StringUtils.trimToEmpty(codeTemplateType).replace("Entity", "")), ".java");
        return filePath + File.separator + fileName;
    }


    private List<String> getTemplatePathNamesByGenPlan(String genPlan) {
        List<String> templatePathNames = CodeGeneratorHelper.getTemplatePathNamesByGenPlan(genConfig, genPlan);
        return templatePathNames;
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
