package org.apparatum.simple_app.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.apparatum.simple_app.R;
import org.apparatum.simple_app.dto.Photo;
import org.apparatum.simple_app.service.ApiFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class PhotoViewHolder extends RecyclerView.ViewHolder  {

    private ImageView imageView;
    public PhotoViewHolder(View itemView) {
        super(itemView);

        this.imageView = (ImageView)itemView.findViewById(R.id.photo_image);
    }

    public void loadPhoto(int photoId){
        Call<Photo> photoById = ApiFactory.getPhotoService().photoById(photoId);
        photoById.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.body() != null){
                    Picasso.with(itemView.getContext())
                            .load(response.body().getUrl())
                            .into(imageView);
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {

            }
        });
    }


}
