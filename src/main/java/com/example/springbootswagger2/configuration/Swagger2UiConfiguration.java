package com.example.springbootswagger2.configuration;
 
import com.fasterxml.classmate.TypeResolver;
import com.greg.test.rest.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.*;
import static springfox.documentation.schema.AlternateTypeRules.*;
 
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = {
	    com.greg.test.rest.HelloController.class
	})
public class Swagger2UiConfiguration {                                    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build()
            .pathMapping("/")
            
            //.directModelSubstitute(LocalDate.class, String.class)
            //.genericModelSubstitutes(ResponseEntity.class)
            /*.alternateTypeRules(
                newRule(typeResolver.resolve(DeferredResult.class,
                    typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                    typeResolver.resolve(WildcardType.class)))*/
            /*.useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET,
                newArrayList(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 message")
                    .responseModel(new ModelRef("Error"))
                    .build()))*/
            /*.securitySchemes(newArrayList(apiKey()))
            .securityContexts(newArrayList(securityContext()))*/
            //.enableUrlTemplating(true)
            /*.globalOperationParameters(
                newArrayList(new ParameterBuilder()
                    .name("someGlobalParameter")
                    .description("Description of someGlobalParameter")
                    .modelRef(new ModelRef("string"))
                    .parameterType("query")
                    .required(true)
                    .build()))*/
            .tags(new Tag("Greg Test", "All apis relating to greg")) 
            //.additionalModels(typeResolver.resolve(AdditionalModel.class)) 
            ;
      }
    public static void main(String[] args) {
        SpringApplication.run(Swagger2UiConfiguration.class, args);
    }
}