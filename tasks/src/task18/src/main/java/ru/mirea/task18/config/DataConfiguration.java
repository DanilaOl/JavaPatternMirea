package ru.mirea.task18.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ru.mirea.task18.repositories")
public class DataConfiguration {
}
