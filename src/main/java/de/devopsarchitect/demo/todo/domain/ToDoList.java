package de.devopsarchitect.demo.todo.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Represents the "ToDoList" entity.
 *
 * @author Richard Attermeyer
 */
@Entity
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(length = 50)
    private String name;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ToDoListItem> items;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public List<ToDoListItem> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(List<ToDoListItem> items) {
        this.items = items;
    }

    /**
     * Getter for property 'description'.
     *
     * @return Value for property 'description'.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for property 'description'.
     *
     * @param description Value to set for property 'description'.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Factory method to create a to do list.
     *
     * @param name  name of the to do list
     * @param items items of the to do list
     * @return the constructed to do list.
     */
    public static ToDoList toDoList(String name, List<ToDoListItem> items) {
        ToDoList toDoList = new ToDoList();
        toDoList.setName(name);
        toDoList.setItems(items);
        return toDoList;
    }
}
