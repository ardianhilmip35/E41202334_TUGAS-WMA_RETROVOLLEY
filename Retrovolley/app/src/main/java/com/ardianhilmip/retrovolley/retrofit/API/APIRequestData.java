package com.ardianhilmip.retrovolley.retrofit.API;

import com.ardianhilmip.retrovolley.retrofit.model.LoginRequest;
import com.ardianhilmip.retrovolley.retrofit.model.LoginResponse;
import com.ardianhilmip.retrovolley.retrofit.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("nama") String nama,
            @Field("id_jabatan") String jabatan,
            @Field("no_telp") String no_telp,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> ardDeleteData(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("get.php") // mengambil nilai id (saya buat untuk mengirim ke update data
    Call<ResponseModel> ardGetData(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> ardUpdateData(
            @Field("id") int id,
            @Field("nama") String nama,
            @Field("id_jabatan") String jabatan,
            @Field("no_telp") String no_telp,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("password") String password
    );
}
