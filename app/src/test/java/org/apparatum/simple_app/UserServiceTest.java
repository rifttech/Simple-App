package org.apparatum.simple_app;


import org.apparatum.simple_app.dto.User;
import org.apparatum.simple_app.service.ApiFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;
/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class UserServiceTest {
    @Test
    public void testGetAllUserFromUserService() throws IOException {
        Call<List<User>> users = ApiFactory.getUserService().users();
        String values = users.execute().message();

        System.out.println(values);
    }

    @Test
    public void testUserByIdFromUserService() throws IOException {
        Call<User> user = ApiFactory.getUserService().user(1);
        User u =  user.execute().body();
        System.out.println(u.toString());
    }



    @Test
    public void testUsersByIdFromUserService() throws IOException {
        Call<List<User>> user = ApiFactory.getUserService().users(1,2,3,4,5);
        List<User> u =  user.execute().body();
        System.out.println(u.size());
        System.out.println(u.toString());
    }
}
