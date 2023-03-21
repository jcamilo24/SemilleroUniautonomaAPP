package com.example.semillerouniautonoma.model.Clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    public static final String TABLE_NAME = "Users";

    public static final String COLUMN_USU_CORREO = "usu_correo";
    public static final String COLUMN_USU_NOMBRES = "usu_nombres";
    public static final String COLUMN_USU_IMAGEN = "usu_imagen";


    @SerializedName("usu_correo")
    @Expose
    private String usu_correo;
    @SerializedName("usu_nombres")
    @Expose
    private String usu_nombres;
    @SerializedName("usu_imagen")
    @Expose
    private String usu_imagen;

    public Users(String usu_correo, String usu_nombres, String usu_imagen) {
        this.usu_correo = usu_correo;
        this.usu_nombres = usu_nombres;
        this.usu_imagen = usu_imagen;
    }

    public String getUsu_correo() {
        return usu_correo;
    }

    public void setUsu_correo(String usu_correo) {
        this.usu_correo = usu_correo;
    }

    public String getUsu_nombres() {
        return usu_nombres;
    }

    public void setUsu_nombres(String usu_nombres) {
        this.usu_nombres = usu_nombres;
    }

    public String getUsu_imagen() {
        return usu_imagen;
    }

    public void setUsu_imagen(String usu_imagen) {
        this.usu_imagen = usu_imagen;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usu_correo='" + usu_correo + '\'' +
                ", usu_nombres='" + usu_nombres + '\'' +
                ", usu_imagen='" + usu_imagen + '\'' +
                '}';
    }
}

