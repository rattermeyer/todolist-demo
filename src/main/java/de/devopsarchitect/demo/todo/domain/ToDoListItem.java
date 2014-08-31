package de.devopsarchitect.demo.todo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * User: Richard Attermeyer
 * Date: 31.08.14
 * Time: 20:56
 *
 * @author Richard Attermeyer
 */
@Embeddable
public class ToDoListItem {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
