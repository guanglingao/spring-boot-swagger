package com.zhisland.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurer implements WebMvcConfigurer {

    @Value("${swagger.enable:true}")
    boolean enable;
    @Value("${swagger.title:API}")
    String title;
    @Value("${swagger.description}")
    String description;
    @Value("${swagger.contact.name}")
    String contactName;
    @Value("${swagger.contact.url}")
    String contactUrl;
    @Value("${swagger.contact.mail}")
    String contactMail;
    @Value("${swagger.version}")
    String version;

    public SwaggerConfigurer() {
    }

    @Bean
    public Docket allApi() {
        if (!this.enable) {
            return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.none()).paths(PathSelectors.none()).build();
        } else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .genericModelSubstitutes(DeferredResult.class)
                    .useDefaultResponseMessages(false)
                    .forCodeGeneration(false)
                    .pathMapping("/")
                    .select()
                    .build()
                    .apiInfo(productApiInfo());
        }
    }
    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                this.title,
                this.description,
                this.version,
                this.contactUrl,
                this.contactMail,
                null,
                null);
        return apiInfo;
    }

    @Bean
    public CorsFilter apiCrosFilter() {
        if (!this.enable) {
            return new CorsFilter(new UrlBasedCorsConfigurationSource());
        } else {
            UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowCredentials(true);
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedMethod("*");
            corsConfiguration.addAllowedOrigin("*");
            urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
            return new CorsFilter(urlBasedCorsConfigurationSource);
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/webjars/");
        registry.addResourceHandler("/docs.html").addResourceLocations("classpath:/docs.html");
    }
}
