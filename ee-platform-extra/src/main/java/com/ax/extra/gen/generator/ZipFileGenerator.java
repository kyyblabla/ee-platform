package com.ax.extra.gen.generator;

import com.ax.extra.gen.model.GenScheme;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 该类是非线程安全的
 * Created by kyy on 2017/10/23.
 */
@Slf4j
public class ZipFileGenerator extends AbstractGenerator {

    private ZipOutputStream zip;
    private ByteArrayOutputStream outputStream;

    public ZipFileGenerator() {
        super("");
        this.outputStream = new ByteArrayOutputStream();
        this.zip = new ZipOutputStream(outputStream);
    }

    @Override
    public void onGenerated(GenScheme genScheme, String templateName, String coneContent) {
        try {
            String savePathName = getSavePathNameFromScheme(genScheme, templateName);
            zip.putNextEntry(new ZipEntry(savePathName));
            IOUtils.write(coneContent.toString(), zip, "UTF-8");
            IOUtils.closeQuietly(zip);
            zip.closeEntry();
        } catch (Exception e) {
        }
    }

    @Override
    public void onFinished(GenScheme genScheme) {
        IOUtils.closeQuietly(zip);
    }

    public byte[] getZipBytes() {
        return outputStream.toByteArray();
    }

}
