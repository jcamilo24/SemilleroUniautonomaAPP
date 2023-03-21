package com.example.semillerouniautonoma.model.Clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users_seedbed {

    public static final String TABLE_NAME = "Users_seedbed";

    public static final String COLUMN_USU_SEM_SEM_ID = "usu_sem_sem_id";
    public static final String COLUMN_USU_SEM_USU_CORREO = "usu_sem_usu_correo";
    public static final String COLUMN_USU_SEM_ESTADO_MIEMBRO = "usu_sem_estado_miembro";
    public static final String COLUMN_USU_SEM_FECHA_INICIO = "usu_sem_fecha_inicio";
    public static final String COLUMN_USU_SEM_FECHA_FIN = "usu_sem_fecha_fin";


    @SerializedName("usu_sem_sem_id")
    @Expose
    private String usu_sem_sem_id;
    @SerializedName("usu_sem_usu_correo")
    @Expose
    private String usu_sem_usu_correo;
    @SerializedName("usu_sem_rol_id")
    @Expose
    private String usu_sem_rol_id;
    @SerializedName("usu_sem_estado_miembro")
    @Expose
    private String usu_sem_estado_miembro;
    @SerializedName("usu_sem_fecha_inicio")
    @Expose
    private String usu_sem_fecha_inicio;

    public Users_seedbed(String usu_sem_sem_id, String usu_sem_usu_correo, String usu_sem_rol_id, String usu_sem_estado_miembro, String usu_sem_fecha_inicio) {
        this.usu_sem_sem_id = usu_sem_sem_id;
        this.usu_sem_usu_correo = usu_sem_usu_correo;
        this.usu_sem_rol_id = usu_sem_rol_id;
        this.usu_sem_estado_miembro = usu_sem_estado_miembro;
        this.usu_sem_fecha_inicio = usu_sem_fecha_inicio;
    }

    public String getUsu_sem_sem_id() {
        return usu_sem_sem_id;
    }

    public void setUsu_sem_sem_id(String usu_sem_sem_id) {
        this.usu_sem_sem_id = usu_sem_sem_id;
    }

    public String getUsu_sem_usu_correo() {
        return usu_sem_usu_correo;
    }

    public void setUsu_sem_usu_correo(String usu_sem_usu_correo) {
        this.usu_sem_usu_correo = usu_sem_usu_correo;
    }

    public String getUsu_sem_rol_id() {
        return usu_sem_rol_id;
    }

    public void setUsu_sem_rol_id(String usu_sem_rol_id) {
        this.usu_sem_rol_id = usu_sem_rol_id;
    }

    public String getUsu_sem_estado_miembro() {
        return usu_sem_estado_miembro;
    }

    public void setUsu_sem_estado_miembro(String usu_sem_estado_miembro) {
        this.usu_sem_estado_miembro = usu_sem_estado_miembro;
    }

    public String getUsu_sem_fecha_inicio() {
        return usu_sem_fecha_inicio;
    }

    public void setUsu_sem_fecha_inicio(String usu_sem_fecha_inicio) {
        this.usu_sem_fecha_inicio = usu_sem_fecha_inicio;
    }

    @Override
    public String toString() {
        return "Users_seedbed{" +
                "usu_sem_sem_id='" + usu_sem_sem_id + '\'' +
                ", usu_sem_usu_correo='" + usu_sem_usu_correo + '\'' +
                ", usu_sem_rol_id='" + usu_sem_rol_id + '\'' +
                ", usu_sem_estado_miembro='" + usu_sem_estado_miembro + '\'' +
                ", usu_sem_fecha_inicio='" + usu_sem_fecha_inicio + '\'' +
                '}';
    }
}
