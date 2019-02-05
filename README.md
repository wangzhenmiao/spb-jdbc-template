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
    
    
 四、repository数据访问层
 
     @Repository
     public class UserRepository {

    // 注入JdbcTemplate模板对象
    @Resource
    private JdbcTemplate jdbcTemplate;

    /***
     *  插入数据
     * @return 插入影响的行数
     */
    public int insertUser(){
        String sql = "insert into tb_user(login_name ,username ,passWord) "
                + "values (?,?,?),(?,?,?),(?,?,?)";
        Object[] args = new Object[]{"swk","孙悟空","123456","zbj","猪八戒","123456"
                ,"ts","唐僧","123456"};
        // 参数一：插入数据的sql语句 参数二: 对应sql语句中占位符?的参数
        return jdbcTemplate.update(sql, args);
    }
    ...
    }
    
1、 @Repository 注解声明这个类是一个数据访问层对象

2、@Resource将JdbcTemplate对象注入进来，后续就可以通过JdbcTemplate对象提供的方法，对数据库进行相关的CRUD操作了。JdbcTemplate对象由springboot项目自动配置和自动创建。

 五、web访问
 
 1、url:http://127.0.0.1:8080/user/insertGetKey?loginName=x1&username=徐磊&password=123456
 
 对应controller中的方法：
 
 	    @RequestMapping("/insertGetKey")
   		 public User insertGetKey(User user) {
       		 return userService.insertGetKey(user);
   		 }
 
 输出:{"id":4,"loginName":"x1","username":"徐磊","password":"123456"}
 
 2、url:http://127.0.0.1:8080/user/findAll
 
 输出:[{"id":1,"loginName":"swk","username":"孙悟空","password":"123456"},{"id":2,"loginName":"zbj","username":"猪八戒","password":"123456"},{"id":3,"loginName":"ts","username":"唐僧","password":"123456"},{"id":4,"loginName":"x1","username":"徐磊","password":"123456"}]
 
 
 
