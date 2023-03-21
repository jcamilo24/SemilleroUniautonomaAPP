package com.example.semillerouniautonoma.model.Clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class RolByUser {
    public static final String TABLE_NAME = "RolByUser";

    public static final String COLUMN_USU_CORREO = "usu_correo";
    public static final String COLUMN_USU_NOMBRES = "usu_nombres";
    public static final String COLUMN_USU_IMAGEN = "usu_imagen";
    public static final String COLUMN_USU_ROL_TOKEN = "usu_rol_token";
    public static final String COLUMN_USU_ROL_FECHA_INICIO = "usu_rol_fecha_inicio";
    public static final String COLUMN_ROL_FECHA_FIN = "usu_rol_fecha_fin";

    @SerializedName("usu_correo")
    @Expose
    private String usu_correo;
    @SerializedName("usu_nombres")
    @Expose
    private String usu_nombres;
    @SerializedName("usu_imagen")
    @Expose
    private String usu_imagen;
    @SerializedName("usu_roles")
    @Expose
    private ArrayList<Roles> usu_roles;

    public RolByUser(String usu_correo, String usu_nombres, String usu_imagen, ArrayList<Roles> usu_roles) {
        this.usu_correo = usu_correo;
        this.usu_nombres = usu_nombres;
        this.usu_imagen = usu_imagen;
        this.usu_roles = usu_roles;
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

    public ArrayList<Roles> getUsu_roles() {
        return usu_roles;
    }

    public void setUsu_roles(ArrayList<Roles> usu_roles) {
        this.usu_roles = usu_roles;
    }

    @Override
    public String toString() {
        return "RolByUser{" +
                "usu_correo='" + usu_correo + '\'' +
                ", usu_nombres='" + usu_nombres + '\'' +
                ", usu_imagen='" + usu_imagen + '\'' +
                ", usu_roles=" + usu_roles +
                '}';
    }
}
