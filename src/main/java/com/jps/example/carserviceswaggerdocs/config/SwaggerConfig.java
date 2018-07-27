package com.jps.example.carserviceswaggerdocs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SPRING_WEB)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/cars.*"))
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        String title = "Car Service API";
        String description = "Provides CRUD operations for cars";
        String version = "1.0";
        String termsOfServiceUrl = "http://terms.fake.com";
        Contact contact = new Contact("Jamila", "http://github.com/JamilaPeripolli", "jamila.souza@matera.com");
        String license = "License";
        String licenseUrl = "http://license.fake.com";
        List<VendorExtension> vendorExtensions = Arrays.asList(new StringVendorExtension("VendorName", "VendorValue"));

        return new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions);
    }

    private ApiInfo simpleApiInfo() {
        String title = "Car Service API";
        String description = "Provides CRUD operations for cars";
        String version = "1.0";
        List<VendorExtension> vendorExtensions = new ArrayList<>();

        return new ApiInfo(title, description, version, null, null, null, null, vendorExtensions);
    }
}
