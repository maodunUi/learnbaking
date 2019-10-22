package cn.ymt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "cn.ymt.dao")
@SpringBootApplication
public class LearnbakingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnbakingApplication.class, args);
	}
}
