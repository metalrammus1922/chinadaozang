package com.rammus.daozang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = "com.rammus.daozang")
@MapperScan("com.rammus.daozang.mapper")
public class DaozangApplication {
	private static final Logger logger = LoggerFactory.getLogger(DaozangApplication.class);

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DaozangApplication.class);
		Environment environment = springApplication.run(args).getEnvironment();
		logger.info("启动成功！");
		logger.info("访问地址: \thttp://127.0.0.1:{}", environment.getProperty("server.port"));

	}

}
