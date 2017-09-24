package com.ax.extra.gen.code;

import com.alibaba.fastjson.JSON;
import com.ax.common.util.FileUtils;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.model.GenTable;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kyy on 2017/9/23.
 */
public class CodeGeneratorTest {


    private static CodeGenerator codeGenerator;

    @BeforeClass
    public static void beforeClass() {
        codeGenerator = new CodeGenerator("/Users/kyy/test");
    }


    @Test
    public void generateTemplateToFile() throws Exception {
        GenScheme genScheme = getGenScheme();
        codeGenerator.generateTemplateToFile(genScheme, "code-template/jpa-dao/Entity.java");
    }

    @Test
    public void generate() throws Exception {

        GenScheme genScheme = getGenScheme();
        genScheme.setModuleName("emp");

        genScheme.setSubModuleName("test");

        genScheme.setGenPlan("jpa-dao");
        codeGenerator.generate(genScheme);

        genScheme.setGenPlan("crud-jpa");
        codeGenerator.generate(genScheme);

    }

    @Test
    public void getTemplatePathNames() throws Exception {
        assertEquals(codeGenerator.getTemplatePathNamesByGenPlan("jpa-dao").size(), 2);
        assertEquals(codeGenerator.getTemplatePathNamesByGenPlan("crud").size(), 2);
        assertEquals(codeGenerator.getTemplatePathNamesByGenPlan("crud-jpa").size(), 4);
    }


    private GenScheme getGenScheme() throws IOException {
        GenScheme genScheme = new GenScheme();
        genScheme.setModuleName("test");
        genScheme.setPackageName("com.kyyblabla");
        genScheme.setSubModuleName("");
        genScheme.setName("test");
        genScheme.setReplaceFile(true);
        genScheme.setTable(JSON.parseObject(FileUtils.readClassPathFileToString("user.json"), GenTable.class));
        return genScheme;
    }


}