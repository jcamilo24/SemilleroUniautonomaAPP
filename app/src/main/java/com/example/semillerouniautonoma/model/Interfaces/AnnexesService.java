package com.example.semillerouniautonoma.model.Interfaces;

import android.os.Bundle;

import com.example.semillerouniautonoma.model.Clases.Annexes;
import com.example.semillerouniautonoma.model.Clases.LastNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AnnexesService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/anexos/anneceSeedbed/{id}")
    Call<List<Annexes>> Annexe(@Path("id") String id);
}
