package de.devopsarchitect.demo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Represents the Spring-Boot Application Main class.
 * @author Richard Attermeyer
 */
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@EnableJpaRepositories
@Configuration
public class Application {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
