package com.example.bbsadmin;

import com.example.bbscore.BbsCoreApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BbsAdminApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)
				.sources(BbsCoreApplication.class, BbsAdminApplication.class)
				.run(args);
	}

}
