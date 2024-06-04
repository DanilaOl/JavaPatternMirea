package ru.mirea.task22.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ru.mirea.task22.repositories")
public class DataConfiguration {
}
