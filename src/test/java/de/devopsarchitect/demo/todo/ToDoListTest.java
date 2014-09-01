package de.devopsarchitect.demo.todo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * This is just a dummy test to only show it is executed.
 * @author Richard Attermeyer
 */
public class ToDoListTest {

    @Test
    public void doTest() {
        assertThat("abc", equalTo("abc"));
    }
}
