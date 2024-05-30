package ru.mirea.task21.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ru.mirea.task21.repositories")
public class DataConfiguration {
}
