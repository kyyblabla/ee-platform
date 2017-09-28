package com.ax.codegen.controller;

import com.ax.common.util.BeanMapper;
import com.ax.extra.gen.code.CodeGenerator;
import com.ax.extra.gen.code.DatabaseReverser;
import com.ax.extra.gen.model.GenScheme;
import com.ax.extra.gen.model.GenTable;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/9/28.
 */
@RequestMapping("/codegen")
@RestController
public class CodegenController {

    @Autowired
    private DatabaseReverser databaseReverser;

    @Autowired
    private CodeGenerator codeGenerator;

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


    }

    @GetMapping("/tables")
    public List<String> getTableList(@RequestParam(value = "dbName", defaultValue = DEFAULT_DB_NAME) String dbName) {

        return databaseReverser.getTables(dbName).stream()
                .map(GenTable::getTableName)
                .collect(Collectors.toList());

    }

    @PostMapping("/gen")
    public void gen(@RequestBody CodeGneBo codeGneBo) throws SQLException {
        GenTable table = databaseReverser.getTable(codeGneBo.dbName, codeGneBo.getTableName());
        GenScheme scheme = BeanMapper.map(codeGneBo, GenScheme.class);
        scheme.setTable(table);
        codeGenerator.generate(scheme);
    }

}
