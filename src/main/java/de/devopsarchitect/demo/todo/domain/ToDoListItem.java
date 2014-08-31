package de.devopsarchitect.demo.todo.domain;

import javax.persistence.Embeddable;

/**
 * Represents a single entry in a todo list.
 * @author Richard Attermeyer
 */
@Embeddable
public class ToDoListItem {
    private String description;

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
