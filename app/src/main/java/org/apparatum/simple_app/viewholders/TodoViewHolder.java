package org.apparatum.simple_app.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.apparatum.simple_app.R;
import org.apparatum.simple_app.dto.Todo;
import org.apparatum.simple_app.service.ApiFactory;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class TodoViewHolder extends RecyclerView.ViewHolder  {
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    private final static int MAX = 100;
    private final static int MIN = 1;
    private CardView cardView;
    private TextView title;
    private CheckBox completed;
    public TodoViewHolder(View itemView) {
        super(itemView);
        title = (TextView)itemView.findViewById(R.id.todo_title);
        completed = (CheckBox) itemView.findViewById(R.id.todo_completed);
    }

    public void grabData(){
        int randomTodoId = RANDOM.nextInt(MAX -MIN + 1) + MIN;

        Call<Todo> todoById = ApiFactory.getTodoService().todoById(randomTodoId);
        todoById.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.body() != null){
                    title.setText(response.body().getTitle());
                    completed.setChecked(response.body().isCompleted());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {

            }
        });
    }


}
