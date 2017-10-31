package org.apparatum.simple_app;

import org.apparatum.simple_app.dto.Todo;
import org.apparatum.simple_app.service.ApiFactory;
import org.junit.Test;

import retrofit2.Call;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class TodoServiceTest {
    @Test
    public void testGetTodoById() throws Exception {
        Call<Todo> todoById = ApiFactory.getTodoService().todoById(12);
        System.out.println(todoById.execute().body().toString());
    }
}
