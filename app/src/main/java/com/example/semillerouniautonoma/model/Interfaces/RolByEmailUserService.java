package com.example.semillerouniautonoma.model.Interfaces;

import com.example.semillerouniautonoma.model.Clases.RolByUser;
import com.example.semillerouniautonoma.model.Clases.Users_seedbed;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RolByEmailUserService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/usuarios/{email}")
    Call<RolByUser> rolbyuser(@Path("email") String email);
}
