package org.apparatum.simple_app;

import org.apparatum.simple_app.dto.Post;
import org.apparatum.simple_app.service.ApiFactory;
import org.junit.Test;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class PostServiceTest {
    @Test
    public void testGetAllPostsFromPostService() throws Exception {
        Call<List<Post>> posts = ApiFactory.getPostService().posts();
        List<Post> body = posts.execute().body();
        for (Post post: body) {
            System.out.println(post.toString());
        }
    }

    @Test
    public void testGetPostByIdFromPostService() throws Exception {
        Call<Post> post= ApiFactory.getPostService().postById(2);
        Post body = post.execute().body();
        System.out.println(body.toString());
    }
}
