package de.devopsarchitect.demo.todo;

import com.jayway.jsonassert.JsonAssert;
import de.devopsarchitect.demo.todo.domain.ToDoList;
import de.devopsarchitect.demo.todo.domain.ToDoListItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.jayway.jsonassert.JsonAssert.collectionWithSize;
import static de.devopsarchitect.demo.todo.domain.ToDoList.toDoList;
import static de.devopsarchitect.demo.todo.domain.ToDoListItem.item;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * User: Richard Attermeyer
 * Date: 01.09.14
 * Time: 06:58
 *
 * @author Richard Attermeyer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class ToDoListControllerIT {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void canAccessBaseUrl() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(getBaseUrl(), String.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void canCreateToDoList() {
        ResponseEntity<ToDoList> response = createToDoList("ToDoList-1", asList(item("description-1"), item("description-2")));
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    }

    @Test
    public void canReadList() {
        ResponseEntity<ToDoList> response = createToDoList("ToDoList-1", asList(item("description-1"), item("description-2")));
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(response.getHeaders().getLocation(), String.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        String body = responseEntity.getBody();
        JsonAssert.with(body).assertThat("$.name", equalTo("ToDoList-1"));
        JsonAssert.with(body).assertThat("$.items", is(collectionWithSize(equalTo(2))));
        JsonAssert.with(body).assertThat("$.items[0].description", equalTo("description-1"));
    }

    private ResponseEntity<ToDoList> createToDoList(String name, List<ToDoListItem> items) {
        ToDoList toDoList = toDoList(name, items);
        HttpEntity<ToDoList> requestEntity = new HttpEntity<ToDoList>(toDoList, createStandardHeaders());
        return restTemplate.postForEntity(getBaseUrl(), requestEntity, ToDoList.class);
    }

    private HttpHeaders createStandardHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    private String getBaseUrl() {
        return "http://localhost:" + port + "/todolist";
    }

}
