package org.apparatum.simple_app.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apparatum.simple_app.R;
import org.apparatum.simple_app.dto.Post;
import org.apparatum.simple_app.service.ApiFactory;
import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {
    private EditText postEditId;

    private Button postSubmit;
    private TextView postTitle;
    private TextView postBody;

    public PostViewHolder(View itemView) {
        super(itemView);

        this.postEditId = (EditText)itemView.findViewById(R.id.post_edit_id);
        this.postTitle = (TextView)itemView.findViewById(R.id.post_title);
        this.postBody = (TextView)itemView.findViewById(R.id.post_body);
        this.postSubmit = (Button)itemView.findViewById(R.id.post_submit);


        this.postSubmit.setOnClickListener(view -> {
            Call<Post> postById = ApiFactory.getPostService().postById(Integer.parseInt(postEditId.getText().toString()));
            postById.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    if (response.body() != null){
                        postTitle.setText(response.body().getTitle());
                        postBody.setText(response.body().getBody());
                    }
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {

                }
            });

        });
    }

    public EditText getPostEditId() {
        return postEditId;
    }

    public void setPostEditId(EditText postEditId) {
        this.postEditId = postEditId;
    }

    public Button getPostSubmit() {
        return postSubmit;
    }

    public void setPostSubmit(Button postSubmit) {
        this.postSubmit = postSubmit;
    }

    public TextView getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(TextView postTitle) {
        this.postTitle = postTitle;
    }

    public TextView getPostBody() {
        return postBody;
    }

    public void setPostBody(TextView postBody) {
        this.postBody = postBody;
    }


}
