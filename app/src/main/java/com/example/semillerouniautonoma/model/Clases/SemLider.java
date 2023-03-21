package com.example.semillerouniautonoma.model.Clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SemLider {

    @SerializedName("usu_correo")
    private String usu_correo;

    @SerializedName("usu_nombres")
    private String usu_nombre;


    public String getUsuaCorreo() {
        return usu_correo;
    }
    public void setUsuaCorreo(String usu_correo) {
        this.usu_correo = usu_correo;
    }

    public String getUsuaNombre() {
        return usu_nombre;
    }
    public void setUsuaNombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }
}
