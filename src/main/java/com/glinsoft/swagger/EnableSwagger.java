package com.glinsoft.swagger;

import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@EnableSwagger2
@Import({SwaggerConfigurer.class,SwaggerController.class})
public @interface EnableSwagger {

}