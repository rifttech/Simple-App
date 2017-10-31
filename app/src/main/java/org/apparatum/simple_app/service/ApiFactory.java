package org.apparatum.simple_app.service;


import org.apparatum.simple_app.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class ApiFactory {


    public static UserService getUserService(){
        return getRetrofit().create(UserService.class);
    }

    public static PostService getPostService(){
        return getRetrofit().create(PostService.class);
    }

    public static CommentService getCommentService(){
        return getRetrofit().create(CommentService.class);
    }

    public static PhotoService getPhotoService(){
        return getRetrofit().create(PhotoService.class);
    }

    public static TodoService getTodoService() {
        return getRetrofit().create(TodoService.class);
    }


    private static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
