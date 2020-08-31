package br.com.djb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DesafioJavaBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaBancoApplication.class, args);
	}

}
