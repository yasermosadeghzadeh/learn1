package com.yaser.rolecompare;

import com.yaser.rolecompare.test.ParserTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yaser.rolecompare.service.RoleComparisonService;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RolecompareApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RolecompareApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {

        return application.sources(RolecompareApplication.class);
    }


}
