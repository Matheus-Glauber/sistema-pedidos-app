package br.com.catrix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//Para acessar o Swagger, digite no brownser -> localhost:8085/swagger-ui.html
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		          .select()
		          .apis(RequestHandlerSelectors.any())
		          .paths(PathSelectors.any())
		          .build();
	}
}
