package com.assessment.hublocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HublockerApplication implements CommandLineRunner {

	private final StartupData startUp;

	@Autowired
	public HublockerApplication(StartupData startUp) {
		this.startUp = startUp;
	}

	public static void main(String[] args) {
		SpringApplication.run(HublockerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		startUp.LoadData();
	}

}
