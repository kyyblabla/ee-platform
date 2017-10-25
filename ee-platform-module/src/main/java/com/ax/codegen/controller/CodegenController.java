package com.ax.codegen.controller;

import com.ax.common.tool.util.BeanMapper;
import com.ax.common.web.BaseController;
import com.ax.extra.gen.generator.DatabaseReverser;
import com.ax.extra.gen.generator.LocalFileGenerator;
import com.ax.extra.gen.generator.ZipFileGenerator;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.model.GenTable;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/9/28.
 */
@RequestMapping("/codegen")
@RestController
public class CodegenController extends BaseController {

    @Autowired
    private DatabaseReverser databaseReverser;


    public static final String DEFAULT_DB_NAME = "test";

    @Data
    public static class CodeGneBo {

        private String dbName;
        private String tableName;

        private String name;     // 名称
        private String packageName;     // 生成基本包路径
        private String moduleName;      // 生成模块名
        private String subModuleName;   // 生成子模块名
        private Boolean replaceFile = true;    // 是否替换现有文件
        private String genPlan; //生成方案

        private String baseDir = ".";


    }

    @GetMapping("/tables")
    public List<String> getTableList(@RequestParam(value = "dbName") String dbName) {
        return databaseReverser.getTables(dbName).stream()
                .map(GenTable::getTableName)
                .collect(Collectors.toList());
    }

    @PostMapping("/gen/zip")
    public void genZip(@RequestBody CodeGneBo codeGneBo, HttpServletResponse response) throws SQLException, IOException {
        GenTable table = databaseReverser.getTable(codeGneBo.dbName, codeGneBo.getTableName());
        GenScheme scheme = BeanMapper.map(codeGneBo, GenScheme.class);
        scheme.setTable(table);
        ZipFileGenerator zipFileGenerator = new ZipFileGenerator();
        zipFileGenerator.generate(scheme);
        this.responseFile(response, zipFileGenerator.getZipBytes(), "code.zip");
    }

    @PostMapping("/gen/local")
    public void genLocal(@RequestBody CodeGneBo codeGneBo) throws SQLException {
        GenTable table = databaseReverser.getTable(codeGneBo.dbName, codeGneBo.getTableName());
        GenScheme scheme = BeanMapper.map(codeGneBo, GenScheme.class);
        scheme.setTable(table);
        new LocalFileGenerator(codeGneBo.baseDir).generate(scheme);
    }

}
