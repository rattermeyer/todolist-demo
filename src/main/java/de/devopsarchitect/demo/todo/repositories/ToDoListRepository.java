package de.devopsarchitect.demo.todo.repositories;

import de.devopsarchitect.demo.todo.domain.ToDoList;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * User: Richard Attermeyer
 * Date: 31.08.14
 * Time: 21:01
 *
 * @author Richard Attermeyer
 */
@RepositoryRestResource(path = "todolist")
public interface ToDoListRepository extends PagingAndSortingRepository<ToDoList, Long>{
    List<ToDoList> findByName(@Param("name") String name);
}
