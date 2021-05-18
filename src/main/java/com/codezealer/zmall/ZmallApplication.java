package com.codezealer.zmall;

import com.codezealer.zmall.common.config.MybatisPlusConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class ZmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmallApplication.class, args);
    }
}
