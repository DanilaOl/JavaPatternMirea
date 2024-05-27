package ru.mirea.task10;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mirea.task10.configuration.ProgrammerConfiguration;
import ru.mirea.task10.interfaces.Programmer;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class Task10Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProgrammerConfiguration.class);

		ArrayList<String> beanNames = new ArrayList<>(Arrays.asList("Junior", "Middle", "Senior"));

		for (var i : beanNames) {
			Programmer programmer = (Programmer) applicationContext.getBean(i);

			programmer.doCoding();
		}
	}
}
