package de.devopsarchitect.demo.todo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * User: Richard Attermeyer
 * Date: 31.08.14
 * Time: 20:50
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToDoListItem> getItems() {
        return items;
    }

    public void setItems(List<ToDoListItem> items) {
        this.items = items;
    }
}
