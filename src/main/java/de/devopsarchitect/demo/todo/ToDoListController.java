package de.devopsarchitect.demo.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents a REST Resource controller.
 * @author Richard Attermeyer
 */
@RestController
public class ToDoListController {
    /**
     * Home string.
     *
     * @return the string
     */
    @RequestMapping("/")
    String home() {
        return "Hello World";
    }
}

