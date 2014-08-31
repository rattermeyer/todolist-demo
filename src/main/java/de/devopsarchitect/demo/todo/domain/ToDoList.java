package de.devopsarchitect.demo.todo.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private String name;

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
}
