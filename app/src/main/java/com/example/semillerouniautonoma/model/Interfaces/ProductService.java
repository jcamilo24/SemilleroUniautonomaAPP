package com.example.semillerouniautonoma.model.Interfaces;

import com.example.semillerouniautonoma.model.Clases.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ProductService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/semilleros/productos/{id}")
    Call<List<Products>> Products(@Path("id") String id);
}
