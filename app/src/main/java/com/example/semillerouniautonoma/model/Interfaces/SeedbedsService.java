package com.example.semillerouniautonoma.model.Interfaces;


import com.example.semillerouniautonoma.model.Clases.SeedbedMembers;
import com.example.semillerouniautonoma.model.Clases.SeedbedsByuser;
import com.example.semillerouniautonoma.model.Clases.Solicitudes;
import com.example.semillerouniautonoma.model.Clases.Users_seedbed;
import com.example.semillerouniautonoma.model.Clases.seedbedFacultad;

import java.time.LocalDate;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SeedbedsService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")
    @POST("/api/v1/usuarios_semilleros/userseedbed/new")
    @FormUrlEncoded
    Call<Users_seedbed> NewUser_seedbed(@Field("usu_sem_sem_id") String usu_sem_sem_id,
                                        @Field("usu_sem_usu_correo") String usu_sem_usu_correo,
                                        @Field("usu_sem_rol_id") String usu_sem_rol_id,
                                        @Field("usu_sem_estado_miembro") String usu_sem_estado_miembro,
                                        @Field("usu_sem_fecha_inicio") LocalDate usu_sem_fecha_inicio);

    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")
    @PUT("/api/v1/usuarios_semilleros/update/{id}")
    @FormUrlEncoded
    Call<Users_seedbed> updateUserSeedbed(@Path("id") String id,
                                          @Field("usu_sem_estado_miembro") String usu_estado_miembro);

    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/semilleros/usuario/{correo}")
    Call<List<SeedbedsByuser>> SeedbedUser(@Path("correo") String correo);

    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/semilleros/{id}")
    Call<List<seedbedFacultad>> SeedbedLider(@Path("id") String id);

    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/semilleros/miembrosss/{id}")
    Call<List<SeedbedMembers>> seedbedmembers(@Path("id") String id);

    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/usuarios_semilleros/estado/pendiente/{id}")
    Call<List<Solicitudes>> SolicitudesAll(@Path("id") String id);
}

