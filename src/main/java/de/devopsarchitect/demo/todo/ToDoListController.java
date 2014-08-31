package de.devopsarchitect.demo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Richard Attermeyer
 * Date: 31.08.14
 * Time: 20:15
 *
 * @author Richard Attermeyer
 */
@RestController
public class ToDoListController {
    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

}
