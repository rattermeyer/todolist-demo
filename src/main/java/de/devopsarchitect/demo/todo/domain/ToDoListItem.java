package de.devopsarchitect.demo.todo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a single entry in a todo list.
 *
 * @author Richard Attermeyer
 */
@Embeddable
public class ToDoListItem {
    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String description;

    /**
     * Standard Constructor.
     */
    public ToDoListItem() {
    }

    /**
     * Constructs a to do list item.
     *
     * @param description the description of the todolist
     */
    public ToDoListItem(String description) {
        this.description = description;
    }

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

    /**
     * Factory method to create a to do list item.
     *
     * @param description description of the item
     * @return a constructed to do list item
     */
    public static ToDoListItem item(String description) {
        return new ToDoListItem(description);
    }
}
