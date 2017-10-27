package com.ax.common.tool.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kyy on 2017/9/23.
 */
@Slf4j
public class FileUtilsExt extends FileUtils {

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

    public static boolean createFile(String fileName) throws IOException {
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
        if (file.createNewFile()) {
            log.debug(fileName + " 文件创建成功!");
            return true;
        } else {
            log.debug(fileName + " 文件创建失败!");
            return false;
        }


    }

    public static void writeToFile(String fileName, String content) throws IOException {
        writeStringToFile(new File(fileName), content, "utf-8");
        log.debug("文件 " + fileName + " 写入成功!");
    }

    public static String readClassPathFileToString(String pathName) throws IOException {
        InputStream resourceAsStream = FileUtilsExt.class.getClassLoader().getResourceAsStream(pathName);
        String str = IOUtils.toString(resourceAsStream);
        return str;
    }


    public static String getFileNameWithoutSuffix(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        if ((fileName.lastIndexOf(".") == -1) || (fileName.indexOf(File.separator) != -1)) {
            return null;
        }
        return fileName.substring(0, fileName.lastIndexOf("."));
    }


    public static String getFileNameWithoutSuffixFromPathName(String pathName) {

        if (StringUtils.isBlank(pathName)) {
            return null;
        }
        if (pathName.indexOf(File.separator) == -1) {
            return null;
        }
        return getFileNameWithoutSuffix(pathName.substring(pathName.lastIndexOf(File.separator) + 1));
    }

    public static String getFileNameFormPathName(String pathName) {

        if (StringUtils.isBlank(pathName)) {
            return null;
        }
        if (pathName.indexOf(File.separator) == -1) {
            return pathName;
        }

        return pathName.substring(pathName.lastIndexOf(File.separator) + File.separator.length());

    }


}
