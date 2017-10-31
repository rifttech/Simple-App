package org.apparatum.simple_app;

import org.apparatum.simple_app.dto.Comment;
import org.apparatum.simple_app.service.ApiFactory;
import org.junit.Test;

import retrofit2.Call;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class CommentServiceTest {
    @Test
    public void testGetCommentById() throws Exception {
        Call<Comment> commentById = ApiFactory.getCommentService().commentById(234);
        System.out.println(commentById.execute().body().toString());
    }
}
