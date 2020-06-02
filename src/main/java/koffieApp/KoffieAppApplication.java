package koffieApp;

import koffieApp.dao.UserDao;
import koffieApp.domain.OrderDetail;
import koffieApp.domain.User;
import koffieApp.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class KoffieAppApplication {

	@Autowired
	OrderDetailService test;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(KoffieAppApplication.class, args
		);
	}


}

