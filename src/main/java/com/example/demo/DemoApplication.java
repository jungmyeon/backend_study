package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

//@OpenAPIDefinition(
//		servers = @Server(url = "http://localhost:8081")
//)
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception  {
		SpringApplication.run(DemoApplication.class, args);

	}
}
