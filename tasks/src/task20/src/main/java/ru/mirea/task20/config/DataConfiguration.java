package ru.mirea.task20.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ru.mirea.task20.repositories")
public class DataConfiguration {
}
