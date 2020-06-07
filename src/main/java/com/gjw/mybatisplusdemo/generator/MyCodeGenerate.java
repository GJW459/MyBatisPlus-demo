package com.gjw.mybatisplusdemo.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class MyCodeGenerate {
    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();
        //配置生成策略
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setAuthor("郭经伟");
        globalConfig.setOpen(false);//是否打开windows文件夹
        globalConfig.setFileOverride(false);//是否覆盖
        globalConfig.setServiceName("%sService");//去Service的I前缀
        globalConfig.setIdType(IdType.ASSIGN_ID);
        globalConfig.setDateType(DateType.ONLY_DATE);
        //globalConfig.setSwagger2(true);
        mpg.setGlobalConfig(globalConfig);
        //2.设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=UTC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        mpg.setDataSource(dataSourceConfig);
        //配置包的位置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("blog");
        packageConfig.setParent("com.gjw.mybatisplusdemo");
        packageConfig.setEntity("entity");
        packageConfig.setController("controller");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("student");//设置映射的表名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityLombokModel(true);//自动生成lombok
        strategyConfig.setLogicDeleteFieldName("deleted");
        //自动填充策略
        TableFill gmt_create = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmt_update = new TableFill("gmt_update", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> objects = new ArrayList<>();
        objects.add(gmt_create);
        objects.add(gmt_update);
        strategyConfig.setTableFillList(objects);
        //乐观锁
        strategyConfig.setVersionFieldName("version");
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);//下划线命名
        mpg.setStrategy(strategyConfig);
        mpg.execute();//执行
    }
}
