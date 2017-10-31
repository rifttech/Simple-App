package org.apparatum.simple_app.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.apparatum.simple_app.R;
import org.apparatum.simple_app.RecyclerAdapter;
import org.apparatum.simple_app.UserListAdapter;
import org.apparatum.simple_app.dto.User;
import org.apparatum.simple_app.service.ApiFactory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder  {
    private List<User> users = new ArrayList<>();
    private ListView userListView;
    private UserListAdapter adapter;
    public UserViewHolder(View itemView) {
        super(itemView);

        userListView = (ListView) itemView.findViewById(R.id.user_list_view);

        adapter = new UserListAdapter(users, itemView.getContext());

        userListView.setAdapter(adapter);


        ApiFactory.getUserService().users(1,2,3,4,5).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.body() != null){

                    users.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    Log.i("Response", "Users get " + response.body().size());
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }


}
