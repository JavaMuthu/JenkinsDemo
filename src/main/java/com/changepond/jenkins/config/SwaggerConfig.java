
package com.changepond.jenkins.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.changepond.jenkins.util.RestAPICommonConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author muthukumar.m
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.changepond.jenkins.controller"))
				.paths(regex(RestAPICommonConstants.REST_API_BASE_URL + ".*")).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("JenkinsDemoApplication")
				.description("This is Jenkins Demo Application using Spring boot with JSP along with REST API")
				.contact(new Contact("Muthukumar M", "www.changepond.com", "muthukumarnirmal@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0-SNAPSHOT").build();
	}

}
