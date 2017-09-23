package com.ax.extra.gen.code;

import com.alibaba.fastjson.JSON;
import com.ax.common.util.FileUtils;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.model.GenTable;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by kyy on 2017/9/23.
 */
public class CodeGeneratorTest {


    private static CodeGenerator codeGenerator;

    @BeforeClass
    public static void beforeClass() {
        codeGenerator = new CodeGenerator();
    }

    private GenTable getTestData() {
        return null;
    }


    @Test
    public void generateTemplateToFile() throws Exception {

        GenScheme genScheme = new GenScheme();
        genScheme.setModuleName("test");
        genScheme.setPackageName("com.kyyblabla");
        genScheme.setSubModuleName("");
        genScheme.setName("test");
        genScheme.setReplaceFile(true);
        genScheme.setTable(JSON.parseObject(FileUtils.readClassPathFileToString("user.json"), GenTable.class));

        String s = codeGenerator.generateTemplateToFile(genScheme, FileUtils.readClassPathFileToString("code-template/Entity.java"), "");
        Assert.assertTrue(s != null);
    }

    @Test
    public void getCodeTemplates() throws Exception {

    }

    @Test
    public void generate() throws Exception {

    }

}