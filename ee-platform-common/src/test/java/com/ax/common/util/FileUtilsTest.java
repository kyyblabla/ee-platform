package com.ax.common.util;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by kyy on 2017/9/23.
 */
public class FileUtilsTest {


    @Test
    public void readClassPathFileToString() throws Exception {
        Assert.assertEquals("hello", FileUtils.readClassPathFileToString("test.txt"));
    }

}