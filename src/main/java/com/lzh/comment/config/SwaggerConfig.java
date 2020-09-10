package com.lzh.comment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
   public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A组");
    }

    @Bean
    public Docket Docket(Environment environment) {
        Profiles profiles=Profiles.of("dev","test");
        Boolean flag=environment.acceptsProfiles(profiles);
        Docket docket=new Docket(DocumentationType.SWAGGER_2);
        docket
                .apiInfo(apiInfo())
        .enable(flag)
        .select()
        .build().groupName("Liao");
        return docket;
    }
    Contact contact = new Contact("lzh", "https://www.baidu.com", "2424753284@qq.com");
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Comment Api信息",
                "Api 信息文档",
                "1.0",
                "组：元",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }


}
