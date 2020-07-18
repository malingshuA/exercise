package com.exercise.exercise;

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

//代码自动生成器
public class KuangCode {
    public static void main(String[] args){
        //需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        //配置策略

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); // 读取文件目录
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("malingshu"); // 全局备注作者姓名
        gc.setOpen(false); // 打开资源管理器
        gc.setFileOverride(true); // 是否覆盖原来生成的文件
        gc.setServiceName("%sService"); // 去掉service的I前缀
        //gc.setIdType(Idd)
        gc.setIdType(IdType.ASSIGN_ID); // 主键
        //日期的类型
       // gc.setDateType
        gc.setDateType(DateType.ONLY_DATE);
        //配置swagger文档
        //gc.setSwagger2(true);
        //把全局配置文件丢到生成器里面
        mpg.setGlobalConfig(gc);

        //设置数据源
        DataSourceConfig dc = new DataSourceConfig();
        // 数据库信息查询 //默认mysql
        //dc.setDbQuery(new MySqlQuery());
        dc.setDbType(DbType.MYSQL);// 数据库类型
        //类型转换 默认mysql
        //dc.setTypeConvert(new MySqlTypeConvert());
        dc.setUrl("jdbc:mysql://47.96.151.45:3306/weiqian?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        dc.setDriverName("com.mysql.cj.jdbc.Driver");
        dc.setUsername("root");
        dc.setPassword("123456");
        mpg.setDataSource(dc);

        // 包的配置
        PackageConfig pc = new PackageConfig();
        // 设置模块名称
        pc.setModuleName("exercise");
        pc.setParent("com.example.majiang");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //映射表名
        strategy.setInclude("useree");
        //配置命名规则, 如下:下划线转为驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //配置命名规则, 如下:下划线转为驼峰命名,列的名字
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        //自动生成lombok
        strategy.setEntityLombokModel(true);
        //strategy.setRestControllerStyle(true);
        //设置逻辑删除
        strategy.setLogicDeleteFieldName("deleted");

        //自动填充配置
        //自动填充配置,例子: gmt_create 数据库字段,创建时间
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        //修改操作, 例子,如上;
        TableFill gmtModififed = new TableFill("gmt_modififed", FieldFill.INSERT_UPDATE);
        final ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModififed);
        strategy.setTableFillList(tableFills);

        //乐观锁
        strategy.setVersionFieldName("version");

        //设置驼峰命名
        strategy.setRestControllerStyle(true);
        //把url修改为: localhost:8080/hello_id_2
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);


        mpg.execute(); // 执行


    }
}
