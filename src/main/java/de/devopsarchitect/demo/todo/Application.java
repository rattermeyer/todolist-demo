package de.devopsarchitect.demo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * User: Richard Attermeyer
 * Date: 31.08.14
 * Time: 20:58
 *
 * @author Richard Attermeyer
 */
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@EnableJpaRepositories
@Configuration
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
