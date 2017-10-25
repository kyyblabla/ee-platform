package com.ax.extra.gen.generator;

import com.ax.extra.gen.model.GenScheme;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

/**
 * Created by kyy on 2017/10/24.
 */
public class ZipFileGeneratorTest extends CodeGeneratorTest {

    private static ZipFileGenerator codeGenerator;

    @BeforeClass
    public static void beforeClass() {
        codeGenerator = new ZipFileGenerator();
    }


    @Test
    public void generate() throws Exception {

        GenScheme genScheme = getGenScheme();
        genScheme.setModuleName("emp");
        genScheme.setSubModuleName("test");
        genScheme.setGenPlan("crud-jpa");
        codeGenerator.generate(genScheme);

        byte[] zipBytes = codeGenerator.getZipBytes();
        FileUtils.writeByteArrayToFile(new File("/tmp/test/code2.zip"), zipBytes);

    }


}