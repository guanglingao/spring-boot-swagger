一、说明
===
对于SpringBoot项目提供Swagger2支持，界面友好。
---
二、用法
===
  1、创建SpringBoot项目，在pom.xml添加依赖  
  ````
  <dependency>  
  	<groupId>com.github.glinsoft</groupId>  
  	<artifactId>spring-boot-swagger</artifactId>  
  	<version>1.2.4</version>  
  </dependency>   
  ````
  2、在SpringBoot启动类添加 <font color=#990000  >@EnableSwagger</font> 注解，例如：  
  ``````
  package com.zhisland.fourd;  
  
  import EnableSwagger;  
  import org.springframework.boot.SpringApplication;  
  import org.springframework.boot.autoconfigure.SpringBootApplication;  
  
  @SpringBootApplication  
  @EnableSwagger  
  public class FourdApplication {  
  
  	public static void main(String[] args) {  
  		SpringApplication.run(FourdApplication.class, args);  
  	}  
  }  
  ``````
  3、配置application.yml
  ````````
  server:  
    port: 8080  
  
  swagger:  
    enable: true  # 默认为true  
    title: 微站    # 项目名称
    description: 微站微服务API文档   #项目文档详细描述
    version: 1.0.0  # 版本号
    contact:  
      name: 高广林  # 联系人
      url: http://192.168.2.101:82/gaoguanglin/  
      mail: gaoguanglin@zhisland.com  
  ````````
  4、使用Swagger2注解，请参见Swagger2语法。例如：  
  ````````
  package com.zhisland.fourd.Controller;  
  
  import io.swagger.annotations.Api;  
  import io.swagger.annotations.ApiOperation;  
  import io.swagger.annotations.ApiResponse;  
  import io.swagger.annotations.ApiResponses;  
  import org.springframework.stereotype.Controller;  
  import org.springframework.web.bind.annotation.RequestMapping;  
  import org.springframework.web.bind.annotation.RequestMethod;  
  import org.springframework.web.bind.annotation.ResponseBody;  
  import org.springframework.web.servlet.ModelAndView;  
  
  @Controller  
  @Api("用户管理")  
  public class UserController {  
  
      @RequestMapping(value = "/name",method = RequestMethod.GET)  
      @ResponseBody  
      @ApiOperation(value = "获取用户姓名")  
      public String getUserName(){  
          return "{\"name\":\"高广林\"}";  
      }  
  
      @RequestMapping(value = "/cellphone",method = RequestMethod.GET)  
      @ApiOperation(value = "获取用户手机号")  
      @ApiResponses({@ApiResponse(code=403,message = "无权限访问")})  
      public ModelAndView getUserCellphone(){  
          return new ModelAndView();  
      }  
  
  
  }  

  ````````
  5、访问API文档  
    在浏览器中输入：http://[your-spring-boot-host]:[server-port]/docs  
    默认占用了如下URL (@RequestMapping)地址： 
     
   
    /docs  
    /docs.html  
    /doc  
    /doc.html
    /api-doc
    /api-doc.html
   
   
  三、看一下[示例程序](http://192.168.2.101:82/gaoguanglin/pyramid)
===



  
     
     


   
   
     
     
       
       
  
  		
