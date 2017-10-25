package com.ax.extra.gen.generator;

import com.ax.extra.gen.model.GenScheme;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by kyy on 2017/9/23.
 */
public class LocalFileGeneratorTest extends CodeGeneratorTest {


    private static AbstractGenerator codeGenerator;

    @BeforeClass
    public static void beforeClass() {
        codeGenerator = new LocalFileGenerator("/Users/kyy/test");
    }


    @Test
    public void generate() throws Exception {

        GenScheme genScheme = getGenScheme();
        genScheme.setGenPlan("crud-jpa");
        codeGenerator.generate(genScheme);

    }


}