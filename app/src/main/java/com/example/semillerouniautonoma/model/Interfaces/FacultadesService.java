package com.example.semillerouniautonoma.model.Interfaces;

import com.example.semillerouniautonoma.model.Clases.seedbedFacultad;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FacultadesService {
    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/semilleros/facultad/Facultad de Ingeniería")
    Call<List<seedbedFacultad>> allseedbedsIngenieria();

    @Headers("Authorization: $2b$15$bAwF7OQcbXCEXvlS6zqgsuHCc.BOyxmOoP.QqCk0LcsCGX8bLonji")

    @GET("/api/v1/semilleros/facultad/Facultad de Derecho, Ciencias Sociales y Administrativas")
    Call<List<seedbedFacultad>> allseedbedsAdministracion();
}
