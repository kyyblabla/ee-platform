package com.ax.extra.gen.util;

import com.ax.common.tool.util.FileUtilsExt;
import com.ax.extra.gen.model.GenConfig;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kyy on 2017/9/24.
 */
public class XmlUtilTest {

    @Test
    public void fileToObject() throws Exception {

    }

    @Test
    public void stringToObject() throws Exception {

        String s = FileUtilsExt.readClassPathFileToString("gen-config.xml");
        GenConfig genConfig = XmlUtil.stringToObject(s, GenConfig.class);
        Assert.assertTrue(genConfig != null);

    }

}