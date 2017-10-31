package org.apparatum.simple_app.service;

import org.apparatum.simple_app.dto.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public interface PostService {
    @GET("/posts")
    Call<List<Post>> posts();

    @GET("/posts/{postId}")
    Call<Post> postById(@Path("postId") int postId);
}
