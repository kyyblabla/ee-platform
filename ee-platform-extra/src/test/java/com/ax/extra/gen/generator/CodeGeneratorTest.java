package com.ax.extra.gen.generator;

import com.alibaba.fastjson.JSON;
import com.ax.common.util.FileUtilsExt;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.model.GenTable;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kyy on 2017/9/23.
 */
public class CodeGeneratorTest {


    private static AbstractGenerator codeGenerator;

    @BeforeClass
    public static void beforeClass() {
        codeGenerator = new LocalFileGenerator("/Users/kyy/test");
    }


    @Test
    public void generateTemplateToFile() throws Exception {
        GenScheme genScheme = getGenScheme();
        codeGenerator.generateCodeFromScheme(genScheme, "gen-plan/jpa-dao/Entity.java");
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


    private GenScheme getGenScheme() throws IOException {
        GenScheme genScheme = new GenScheme();
        genScheme.setModuleName("test");
        genScheme.setPackageName("com.kyyblabla");
        genScheme.setSubModuleName("");
        genScheme.setName("test");
        genScheme.setReplaceFile(true);
        genScheme.setTable(JSON.parseObject(FileUtilsExt.readClassPathFileToString("user.json"), GenTable.class));
        return genScheme;
    }


}