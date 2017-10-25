package com.ax.extra.gen.generator;

import com.alibaba.fastjson.JSON;
import com.ax.common.util.FileUtilsExt;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.model.GenTable;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by kyy on 2017/10/24.
 */
public class CodeGeneratorTest {

    protected GenScheme getGenScheme() throws IOException {
        GenScheme genScheme = new GenScheme();
        genScheme.setModuleName("test");
        genScheme.setPackageName("com.kyyblabla");
        genScheme.setSubModuleName("");
        genScheme.setName("test");
        genScheme.setReplaceFile(true);
        genScheme.setGenPlan("crud");
        genScheme.setTable(JSON.parseObject(FileUtilsExt.readClassPathFileToString("user.json"), GenTable.class));
        return genScheme;
    }


}