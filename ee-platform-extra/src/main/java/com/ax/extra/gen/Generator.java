package com.ax.extra.gen;

import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.util.DatabaseUtil;
import com.ax.extra.gen.util.GenUtil;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * Created by kyy on 2017/10/27.
 */
public class Generator {

    private DatabaseUtil databaseUtil;
    private String dbName;
    private String basePackage;

    public Generator(DatabaseUtil databaseUtil, String dbName, String basePakage) {
        this.databaseUtil = databaseUtil;
        this.dbName = dbName;
        this.basePackage = basePakage;
    }

    public byte[] genCode(List<String> tableNames, String moduleName, String subModuleName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        tableNames.forEach(tableName -> {
            GenScheme scheme = buildGenScheme(tableName, moduleName, subModuleName);
            GenUtil.generatorCode(scheme, zip);
        });
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    private GenScheme buildGenScheme(String tableName, String moduleName, String subModuleName) {
        GenScheme scheme = new GenScheme();
        scheme.setTable(databaseUtil.getTable(dbName, tableName));
        scheme.setModuleName(moduleName);
        scheme.setSubModuleName(subModuleName);
        scheme.setPackageName(basePackage);
        return scheme;
    }

}
