package org.apparatum.simple_app;

import org.apparatum.simple_app.dto.Photo;
import org.apparatum.simple_app.service.ApiFactory;
import org.junit.Test;

import retrofit2.Call;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class PhotoServiceTest {
    @Test
    public void testGetPhotoById() throws Exception {
        Call<Photo> photoById = ApiFactory.getPhotoService().photoById(3);
        System.out.println(photoById.execute().body().toString());

    }
}
