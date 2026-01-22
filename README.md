# Nacos数据库适配插件

## 一、插件概述

### 1.1、简介

从Nacos2.2版本开始，Nacos提供了数据源扩展插件，以便让需要进行其他数据库适配的用户自己编写插件来保存数据。当前项目插件目前已简单适配Postgresql。

当前项目基于Nacos2.2版本的扩展插件口进行开发。

### 2.2、插件工程结构说明

nacos-datasource-plugin-ext-base工程为数据库插件操作的适配抽象。

nacos-all-datasource-plugin-ext工程可打包所有适配的数据库插件

nacos-postgresql-datasource-plugin-ext工程可打包适配Postgresql的数据库插件

## 二、下载和使用

### 2.1、插件引入

官方nacos组件解压放入插件包

```bash
# 下载解压官方nacos组件包，进入nacos根目录
cd nacos

# 创建插件文件夹（bin同级）
mkdir plugins

# 把此postgresql插件包，放入plugins文件夹里
```

### 2.2、修改数据库配置文件

nacos目录conf/application.properties文件中新增下面这些配置：

```java
spring.datasource.platform=postgresql
db.num=1
db.url.0=jdbc:postgresql://127.0.0.1:5432/nacos?tcpKeepAlive=true&reWriteBatchedInserts=true&ApplicationName=nacos_java
db.user.0=postgres
db.password.0=123456
db.pool.config.driverClassName=org.postgresql.Driver
```

### 2.3、导入Postgresql的数据库脚本文件

postgresql数据库，导入nacos-postgresql的脚本文件。脚本文件在nacos-postgresql-datasource-plugin-ext/src/main/resources/schema文件夹下面.

上面操作完成后，启动Nacos即可。

## 三、其他数据库插件开发

可参考nacos-postgresql-datasource-plugin-ext工程，新创建Maven项目，实现AbstractDatabaseDialect类，重写相关的分页操作逻辑与方法，并创建相应的mapper实现。