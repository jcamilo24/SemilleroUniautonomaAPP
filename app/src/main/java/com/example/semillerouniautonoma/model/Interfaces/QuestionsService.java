package com.example.semillerouniautonoma.model.Interfaces;

import com.example.semillerouniautonoma.model.Clases.LastNews;
import com.example.semillerouniautonoma.model.Clases.Questions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface QuestionsService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/preguntas/all")
    Call<List<Questions>> questionsAll();
}
