package com.ax.extra.gen.generator;

import com.ax.common.tool.util.FileUtilsExt;
import com.ax.extra.gen.model.GenConfig;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/9/24.
 */
@Slf4j
public class CodeGeneratorHelper {


    public static final String REF = "REF:";

    /**
     * 获取模板类型，模板命名规则为 Entity<Dao|DaoTest|Controller...>.java、
     *
     * @param pathName
     * @return
     */
    public static String getTemplateTypeFromPathName(String pathName) {
        String fileNameWithoutSuffix = FileUtilsExt.getFileNameWithoutSuffixByPathName(pathName);
        if (StringUtils.equals("Entity", fileNameWithoutSuffix)) {
            return "Entity";
        }
        return StringUtils.replacePattern(fileNameWithoutSuffix, "Entity", "");
    }

    /**
     * 根据生成方案获取模板文件路径列表
     *
     * @param genConfig
     * @param genPlanName
     * @return
     */
    public static List<String> getTemplatePathNamesByGenPlan(GenConfig genConfig, String genPlanName) {
        return genConfig.getPlans().stream()
                //查找生成类型
                .filter(genPlanObj -> StringUtils.equals(genPlanObj.getName(), genPlanName))
                //
                .findAny()
                .map(genPlanObj -> {
                    return genPlanObj.getTemplates().stream()
                            .map(templateExp -> {

                                // 根据模板表达式获取模板列表
                                // 这段代码块不建议抽取出单独的函数，尽管代码块有些长
                                // 因为不抽取函数的情况下可以看到有明显的【递归调用】

                                //读取引用的模板gen配置列表
                                if (StringUtils.startsWith(templateExp, REF)) {
                                    //递归查询
                                    return getTemplatePathNamesByGenPlan(genConfig, templateExp.replace(REF, ""));
                                } else {
                                    return Lists.newArrayList(templateExp);
                                }

                            })
                            .filter(Objects::nonNull)
                            .flatMap(s -> s.stream())
                            .distinct()
                            .collect(Collectors.toList());
                })
                //查找失败返回空列表
                .orElse(Collections.emptyList());
    }
}
