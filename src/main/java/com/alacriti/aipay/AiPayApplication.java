package com.alacriti.aipay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication
public class AiPayApplication {

	public static void main(String[] args) {
		Logger logger=LogManager.getLogger(AiPayApplication.class); 
		logger.info("Main");
		SpringApplication.run(AiPayApplication.class, args);
	}

}
