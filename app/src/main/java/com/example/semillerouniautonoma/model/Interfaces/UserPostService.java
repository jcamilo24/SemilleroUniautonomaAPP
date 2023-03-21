package com.example.semillerouniautonoma.model.Interfaces;

import com.example.semillerouniautonoma.model.Clases.Events;
import com.example.semillerouniautonoma.model.Clases.Users;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserPostService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @POST("/api/v1/usuarios/new")
    @FormUrlEncoded
    Call<Users> NewUser(@Field("usu_correo") String usu_correo,
                        @Field("usu_nombres") String usu_nombres,
                        @Field("usu_imagen") String usu_imagen);
}
