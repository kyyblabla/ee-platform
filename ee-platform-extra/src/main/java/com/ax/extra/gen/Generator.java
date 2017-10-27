package com.ax.extra.gen;

import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.util.DatabaseUtil;
import com.ax.extra.gen.util.GenUtil;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by kyy on 2017/10/27.
 */
public class Generator {

    private DatabaseUtil databaseUtil;

    public Generator(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
    }

    public byte[] genCode(String dbName, String tableName, String basePackage, String moduleName, String subModuleName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        GenScheme scheme = buildGenScheme(dbName, tableName, basePackage, moduleName, subModuleName);
        GenUtil.generatorCode(scheme, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    private GenScheme buildGenScheme(String dbName, String tableName, String basePackage, String moduleName, String subModuleName) {
        GenScheme scheme = new GenScheme();
        scheme.setTable(databaseUtil.getTable(dbName, tableName));
        scheme.setModuleName(moduleName);
        scheme.setSubModuleName(subModuleName);
        scheme.setPackageName(basePackage);
        return scheme;
    }

}
