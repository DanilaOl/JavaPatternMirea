package ru.mirea.task19.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ru.mirea.task19.repositories")
public class DataConfiguration {
}
