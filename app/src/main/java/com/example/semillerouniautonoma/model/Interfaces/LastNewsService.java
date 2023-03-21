package com.example.semillerouniautonoma.model.Interfaces;

import com.example.semillerouniautonoma.model.Clases.LastNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface LastNewsService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/noticias/lastNews/3")
    Call<List<LastNews>> Lastnews();
}
