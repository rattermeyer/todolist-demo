package de.devopsarchitect.demo.todo.repositories;

import de.devopsarchitect.demo.todo.domain.ToDoList;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * ToDoListRepository to interact with ToDoList entities.
 * @author Richard Attermeyer
 */
@RepositoryRestResource(path = "todolist")
public interface ToDoListRepository extends PagingAndSortingRepository<ToDoList, Long> {
    /**
     * Find by name.
     *
     * @param name the name
     * @return the list
     */
    List<ToDoList> findByName(@Param("name") String name);

    /**
     * Find by description.
     * @param description description of the todo-list
     * @return to do lists
     */
    List<ToDoList> findByDescription(@Param("description") String description);
}
