package ru.mirea.task10.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.task10.components.Junior;
import ru.mirea.task10.components.Middle;
import ru.mirea.task10.components.Senior;
import ru.mirea.task10.interfaces.Programmer;

@Configuration
public class ProgrammerConfiguration {
	@Bean("Junior")
	public Programmer junior() {
		return new Junior();
	}

	@Bean("Middle")
	public Programmer middle() {
		return new Middle();
	}

	@Bean("Senior")
	public Programmer senior() {
		return new Senior();
	}
}
