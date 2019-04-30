package com.mindyu.sport_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 打包命令： mvn clean package  -Dmaven.test.skip=true
 */
@SpringBootApplication
public class SportSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportSystemApplication.class, args);
	}

}
