package ru.mirea.task12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task12Application implements CommandLineRunner {
	@Autowired
	private FileHasher fileHasher;

	public static void main(String[] args) {
		SpringApplication.run(Task12Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
