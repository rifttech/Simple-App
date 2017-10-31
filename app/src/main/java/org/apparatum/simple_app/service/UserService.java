package org.apparatum.simple_app.service;



import org.apparatum.simple_app.dto.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public interface UserService {
    @GET("/users")
    Call<List<User>> users();

    @GET("/users/{userId}")
    Call<User> user(@Path("userId") int userId);

    @GET("/users")
    Call<List<User>> users(@Query("id")int id0,
                            @Query("id")int id1,
                            @Query("id")int id2,
                            @Query("id")int id3,
                            @Query("id")int id4);


}
