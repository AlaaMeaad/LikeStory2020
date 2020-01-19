package com.alaameaad.likestory.data.api;

import com.alaameaad.likestory.data.model.facebook.Facebook;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiServers {
    @GET("FacebookLink")
    Call<List<Facebook>>  facebook ();






//    @POST("PropertyApi/getProperty")
//    Call<Post> getAllPosts(@Query("page") int page);




}
