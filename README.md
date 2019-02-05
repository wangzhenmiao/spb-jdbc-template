# spb-jdbc-template

一、jdbc的数据库访问模板

1、

二、pom中的配置

1、web开发依赖配置

   		 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
    
 2、数据库驱动依赖配置
 
   		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
    
 3、spb项目使用jdbcTemplate访问数据库的核心依赖配置
 
 三、数据库初始化配置
 
    CREATE TABLE IF NOT EXISTS `tb_user`(
   	`id` INT UNSIGNED AUTO_INCREMENT,
  	 `login_name` VARCHAR(100) NOT NULL,
   	`password` VARCHAR(100) NOT NULL,
   	`username` VARCHAR(40) NOT NULL,
    PRIMARY KEY ( `id` )
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
