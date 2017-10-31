package org.apparatum.simple_app.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apparatum.simple_app.R;
import org.apparatum.simple_app.dto.Comment;
import org.apparatum.simple_app.service.ApiFactory;
import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class CommentViewHolder extends RecyclerView.ViewHolder  {
    private TextView name;
    private TextView email;
    private TextView body;
    private EditText editId;
    private Button submit;


    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getEmail() {
        return email;
    }

    public void setEmail(TextView email) {
        this.email = email;
    }

    public TextView getBody() {
        return body;
    }

    public void setBody(TextView body) {
        this.body = body;
    }

    public CommentViewHolder(View itemView) {
        super(itemView);
        this.name = (TextView)itemView.findViewById(R.id.comment_name);
        this.email = (TextView)itemView.findViewById(R.id.comment_email);
        this.body = (TextView)itemView.findViewById(R.id.comment_body);


        this.editId = (EditText) itemView.findViewById(R.id.comment_edit_id);
        this.submit = (Button)itemView.findViewById(R.id.comment_submit);

        this.submit.setOnClickListener(view -> {
            if (editId.getText().toString().equals("")) return;
            int id  = Integer.parseInt(editId.getText().toString());
            Call<Comment> commentById = ApiFactory.getCommentService().commentById(id);
            commentById.enqueue(new Callback<Comment>() {
                @Override
                public void onResponse(Call<Comment> call, Response<Comment> response) {
                    if (response.body() != null){
                        name.setText(response.body().getName());
                        email.setText(response.body().getEmail());
                        body.setText(response.body().getBody());

                    }
                }

                @Override
                public void onFailure(Call<Comment> call, Throwable t) {

                }
            });
        });


    }


}
