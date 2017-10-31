package org.apparatum.simple_app.service;

import org.apparatum.simple_app.dto.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public interface TodoService {
    @GET("/todos")
    Call<List<Todo>> todos();

    @GET("/todos/{todoId}")
    Call<Todo> todoById(@Path("todoId") int todoId);

}
