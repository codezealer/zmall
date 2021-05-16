package com.codezealer.zmall;

import com.codezealer.zmall.common.config.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class ZmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmallApplication.class, args);
    }
}
