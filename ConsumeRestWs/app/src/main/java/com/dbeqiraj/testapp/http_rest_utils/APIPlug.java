package com.dbeqiraj.testapp.http_rest_utils;

import com.dbeqiraj.testapp.model.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by d.beqiraj on 10/26/2016.
 */
public interface APIPlug {

    @GET("posts/{postId}")
    Call<Post> getPost(@Path("postId") String postId);

}
