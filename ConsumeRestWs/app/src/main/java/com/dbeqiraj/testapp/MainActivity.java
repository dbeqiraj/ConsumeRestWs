package com.dbeqiraj.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dbeqiraj.testapp.http_rest_utils.ApiClient;
import com.dbeqiraj.testapp.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView    result;
    EditText    postId;
    Button      submit;
    Post        myPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result  =   (TextView)  findViewById(R.id.result);
        postId  =   (EditText)  findViewById(R.id.postId);
        submit  =   (Button)    findViewById(R.id.submit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( postId.getVisibility() == View.VISIBLE ) {
            if ( v.getId() == R.id.submit && postId.getText().length() > 0) {
                checkPackage(postId.getText().toString());
            }
        } else {
            result.setText("");
            result.setVisibility(View.GONE);
            postId.getText().clear();
            postId.setVisibility(View.VISIBLE);
            submit.setText(getString(R.string.submit));
        }

    }

    private void checkPackage(String id) {

        Call<Post> call = ApiClient.get().getPost(id);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("APIPlug", "Error Occured: " + t.getMessage());
                postId.getText().clear();
            }

            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d("APIPlug", "Successfully response fetched!" );
                myPost = response.body();
                submit.setText("OK");
                postId.setVisibility(View.GONE);
                result.setVisibility(View.VISIBLE);
                result.setText("UserId: " + myPost.getUserId() + "\n"+
                                "ID: "    + myPost.getId() + "\n"+
                                "Title: " + myPost.getTitle() + "\n"+
                                "Body: "  + myPost.getBody() + "\n");
            }
        });
    }
}
