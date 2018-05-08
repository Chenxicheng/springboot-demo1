package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemo1Application {

	private static Logger logger = LoggerFactory.getLogger(SpringbootDemo1Application.class);

	public static void main(String[] args) {
		logger.info("############## 开始启动项目 ##############");
		SpringApplication.run(SpringbootDemo1Application.class, args);
		logger.info("############## 项目启动完成 ##############");
	}
}
