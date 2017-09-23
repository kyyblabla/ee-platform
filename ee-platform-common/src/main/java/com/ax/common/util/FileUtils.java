package com.ax.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kyy on 2017/9/23.
 */
@Slf4j
public class FileUtils extends org.apache.commons.io.FileUtils {

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                log.debug("删除文件 " + fileName + " 成功!");
                return true;
            } else {
                log.debug("删除文件 " + fileName + " 失败!");
                return false;
            }
        } else {
            log.debug(fileName + " 文件不存在!");
            return true;
        }
    }

    public static boolean createFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            log.debug("文件 " + fileName + " 已存在!");
            return false;
        }
        if (fileName.endsWith(File.separator)) {
            log.debug(fileName + " 为目录，不能创建目录!");
            return false;
        }
        if (!file.getParentFile().exists()) {
            // 如果文件所在的目录不存在，则创建目录
            if (!file.getParentFile().mkdirs()) {
                log.debug("创建文件所在的目录失败!");
                return false;
            }
        }

        // 创建文件
        try {
            if (file.createNewFile()) {
                log.debug(fileName + " 文件创建成功!");
                return true;
            } else {
                log.debug(fileName + " 文件创建失败!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(fileName + " 文件创建失败!");
            return false;
        }

    }

    public static void writeToFile(String fileName, String content) {
        try {
            writeStringToFile(new File(fileName), content, "utf-8");
            log.debug("文件 " + fileName + " 写入成功!");
        } catch (IOException e) {
            log.debug("文件 " + fileName + " 写入失败! " + e.getMessage());
        }
    }

    public static String readClassPathFileToString(String pathName) throws IOException {
        InputStream resourceAsStream = FileUtils.class.getClassLoader().getResourceAsStream(pathName);
        String str = IOUtils.toString(resourceAsStream);
        return str;
    }


}
