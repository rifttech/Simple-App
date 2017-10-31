package org.apparatum.simple_app;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apparatum.simple_app.dto.User;
import org.apparatum.simple_app.service.ApiFactory;
import org.apparatum.simple_app.viewholders.CommentViewHolder;
import org.apparatum.simple_app.viewholders.PhotoViewHolder;
import org.apparatum.simple_app.viewholders.PostViewHolder;
import org.apparatum.simple_app.viewholders.TodoViewHolder;
import org.apparatum.simple_app.viewholders.UserViewHolder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0: return new PostViewHolder(getView(R.layout.recycler_item_post,parent));
            case 1: return new CommentViewHolder(getView(R.layout.recycler_comments_item,parent));
            case 2: return new UserViewHolder(getView(R.layout.recycler_user_item,parent));
            case 3: return new PhotoViewHolder(getView(R.layout.recycler_photo_item,parent));
            case 4: return new TodoViewHolder(getView(R.layout.recycler_todo_item, parent));
        }

        return null;
    }

    private static View getView(int id, ViewGroup parent){
        return LayoutInflater.from(parent.getContext())
                .inflate(id, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case 0:{}break;
            case 1:{}break;
            case 2:{

            }break;
            case 3:{
                ((PhotoViewHolder)holder).loadPhoto(3);
            }break;
            case 4:{
                ((TodoViewHolder)holder).grabData();
            }break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
