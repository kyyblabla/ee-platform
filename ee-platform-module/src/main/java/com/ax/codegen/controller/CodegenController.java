package com.ax.codegen.controller;

import com.ax.common.web.BaseController;
import com.ax.extra.gen.model.GenTable;
import com.ax.extra.gen.util.DatabaseUtil;
import com.ax.extra.gen.Generator;
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
    private Generator generator;
    @Autowired
    private DatabaseUtil databaseUtil;

    @Data
    public static class CodeGneBo {
        private String dbName;
        private String tableName;
        private String name;     // 名称
        private String packageName;     // 生成基本包路径
        private String moduleName;      // 生成模块名
        private String subModuleName;   // 生成子模块名
    }

    @GetMapping("/tables")
    public List<String> getTableList(@RequestParam(value = "dbName") String dbName) {
        return databaseUtil.getTables(dbName).stream()
                .map(GenTable::getTableName)
                .collect(Collectors.toList());
    }

    @PostMapping("/gen")
    public void genZip(@RequestBody CodeGneBo codeGneBo, HttpServletResponse response) throws SQLException, IOException {
        this.responseFile(response, gen(codeGneBo), "code.zip");
    }

    private byte[] gen(CodeGneBo codeGneBo) {
        return generator.genCode(
                codeGneBo.dbName,
                codeGneBo.getTableName(),
                codeGneBo.getPackageName(),
                codeGneBo.getModuleName(),
                codeGneBo.getSubModuleName());
    }

}
