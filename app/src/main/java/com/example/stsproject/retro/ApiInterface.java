package com.example.stsproject.retro;


import com.example.stsproject.model.Transport;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("transport.php")
    Call<List<Transport>> getTransport();

    @FormUrlEncoded
    @POST("insertion.php")
    Call<ResponseBody>insertdata(
            @Field("nom")String nom,
            @Field("num")int num
    );
}
