package com.example.semillerouniautonoma.model.Interfaces;

import com.example.semillerouniautonoma.model.Clases.Users;
import com.example.semillerouniautonoma.model.Clases.Users_rol;

import java.time.LocalDate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Rol_UserPostService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @POST("/api/v1/usuarios_rol/new")
    @FormUrlEncoded
    Call<Users_rol> NewRelationRol_User(@Field("usu_rol_rol_id") String usu_rol_rol_id,
                                        @Field("usu_rol_usu_correo") String usu_rol_usu_correo,
                                        @Field("usu_rol_fecha_inicio") LocalDate usu_rol_fecha_inicio,
                                        @Field("usu_rol_fecha_fin") String usu_rol_fecha_fin);
}
