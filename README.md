# spb-jdbc-template

一、jdbcTemplate对象是spring封装JDBC的核心对象

方法如下：

1、execute方法

2、update方法和batchUpdate方法

3、query方法和

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
    
    //类中属性
    private int id ;
    private String loginName ;
    private String username ;
    private String password;
    
    实体类中的loginName对应数据库中的login_name,
    
    username对应数据库中的username,
    
    感觉应该是按着大写字母开头，区分的。
    
 四、web访问
 
 url:http://127.0.0.1:8080/user/insertGetKey?loginName=x1&username=%E5%BE%90%E7%A3%8A&password=123456
 输出:{"id":4,"loginName":"x1","username":"徐磊","password":"123456"}
 
 五、
