package cn.etc.xqg.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableSwagger2
public class ConfigBean {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要生成接口文档的包（controller所在的包）
                .apis(RequestHandlerSelectors.basePackage("cn.etc.xqg.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("平台服务api")
                .description("平台服务接口文档说明")
                .termsOfServiceUrl("http://localhost:8081")
                .contact(new Contact("zhanglei", "", "1196359917@qq.com"))
                .version("1.0")
                .build();
    }

}
