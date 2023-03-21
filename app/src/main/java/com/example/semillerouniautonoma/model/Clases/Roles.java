package com.example.semillerouniautonoma.model.Clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Roles {

    @SerializedName("usu_sem_id")
    @Expose
    private String usu_sem_id;

    @SerializedName("rol_id")
    @Expose
    private String rol_id;

    @SerializedName("rol_nombre")
    @Expose
    private String rol_nombre;

    @SerializedName("usu_sem_token")
    @Expose
    private String usu_sem_token;

    @SerializedName("usu_sem_fecha_inicio")
    @Expose
    private String usu_sem_fecha_inicio;

    @SerializedName("usu_sem_fecha_fin")
    @Expose
    private String usu_sem_fecha_fin;

    public String getUsu_sem_id() {
        return usu_sem_id;
    }

    public void setUsu_sem_id(String usu_sem_id) {
        this.usu_sem_id = usu_sem_id;
    }

    public String getRol_id() {
        return rol_id;
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public String getUsu_sem_token() {
        return usu_sem_token;
    }

    public void setUsu_sem_token(String usu_sem_token) {
        this.usu_sem_token = usu_sem_token;
    }

    public String getUsu_sem_fecha_inicio() {
        return usu_sem_fecha_inicio;
    }

    public void setUsu_sem_fecha_inicio(String usu_sem_fecha_inicio) {
        this.usu_sem_fecha_inicio = usu_sem_fecha_inicio;
    }

    public String getUsu_sem_fecha_fin() {
        return usu_sem_fecha_fin;
    }

    public void setUsu_sem_fecha_fin(String usu_sem_fecha_fin) {
        this.usu_sem_fecha_fin = usu_sem_fecha_fin;
    }
}
