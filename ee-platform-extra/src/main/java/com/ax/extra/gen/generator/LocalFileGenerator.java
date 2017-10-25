package com.ax.extra.gen.generator;

import com.ax.common.tool.util.FileUtilsExt;
import com.ax.extra.gen.model.GenScheme;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * Created by kyy on 2017/10/23.
 */
@Slf4j
public class LocalFileGenerator extends AbstractGenerator {


    public LocalFileGenerator(String baseDir) {
        super(baseDir);
    }

    @Override
    public void onGenerated(GenScheme genScheme, String templateName, String coneContent) {
        try {
            writeCodeToFile(genScheme, templateName, coneContent);
        } catch (IOException e) {
        }
    }

    private void writeCodeToFile(GenScheme scheme, String templateName, String codeContent) throws IOException {

        String savePathName = baseDir + File.separator + getSavePathNameFromScheme(scheme, templateName);
        if (scheme.getReplaceFile()) {
            FileUtilsExt.deleteFile(savePathName);
        }
        // 创建并写入文件
        if (FileUtilsExt.createFile(savePathName)) {
            FileUtilsExt.writeToFile(savePathName, codeContent);
            log.debug("代码生成成功{}", savePathName);
        } else {
            log.debug("代码生成失败{}", savePathName);
        }
    }

}
