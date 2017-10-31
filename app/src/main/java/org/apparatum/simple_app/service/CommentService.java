package org.apparatum.simple_app.service;

import org.apparatum.simple_app.dto.Comment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public interface CommentService {
    @GET("/comments/{commentId}")
    Call<Comment> commentById(@Path("commentId") int commentId);
}
