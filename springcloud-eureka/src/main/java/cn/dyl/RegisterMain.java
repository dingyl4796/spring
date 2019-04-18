package cn.dyl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterMain {
	public static void main(String[] args) {
		new SpringApplicationBuilder(RegisterMain.class).web(true).run(args);
	}
}
