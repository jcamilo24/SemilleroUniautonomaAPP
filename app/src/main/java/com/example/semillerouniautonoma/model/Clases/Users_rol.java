package com.example.semillerouniautonoma.model.Clases;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users_rol {

    public static final String TABLE_NAME = "Users_rol";

    public static final String COLUMN_USU_ROL_ROL_ID = "usu_rol_rol_id";
    public static final String COLUMN_USU_ROL_USU_CORREO = "usu_rol_usu_correo";
    public static final String COLUMN_USU_ROL_FECHA_INICIO = "usu_rol_fecha_inicio";
    public static final String COLUMN_USU_ROL_FECHA_FIN = "usu_rol_fecha_fin";


    @SerializedName("usu_rol_rol_id")
    @Expose
    private String usu_rol_rol_id;
    @SerializedName("usu_rol_usu_correo")
    @Expose
    private String usu_rol_usu_correo;
    @SerializedName("usu_rol_fecha_inicio")
    @Expose
    private String usu_rol_fecha_inicio;
    @SerializedName("usu_rol_fecha_fin")
    @Expose
    private String usu_rol_fecha_fin;

    public Users_rol(String usu_rol_rol_id, String usu_rol_usu_correo, String usu_rol_fecha_inicio, String usu_rol_fecha_fin) {
        this.usu_rol_rol_id = usu_rol_rol_id;
        this.usu_rol_usu_correo = usu_rol_usu_correo;
        this.usu_rol_fecha_inicio = usu_rol_fecha_inicio;
        this.usu_rol_fecha_fin = usu_rol_fecha_fin;
    }

    public String getUsu_rol_rol_id() {
        return usu_rol_rol_id;
    }

    public void setUsu_rol_rol_id(String usu_rol_rol_id) {
        this.usu_rol_rol_id = usu_rol_rol_id;
    }

    public String getUsu_rol_usu_correo() {
        return usu_rol_usu_correo;
    }

    public void setUsu_rol_usu_correo(String usu_rol_usu_correo) {
        this.usu_rol_usu_correo = usu_rol_usu_correo;
    }

    public String getUsu_rol_fecha_inicio() {
        return usu_rol_fecha_inicio;
    }

    public void setUsu_rol_fecha_inicio(String usu_rol_fecha_inicio) {
        this.usu_rol_fecha_inicio = usu_rol_fecha_inicio;
    }

    public String getUsu_rol_fecha_fin() {
        return usu_rol_fecha_fin;
    }

    public void setUsu_rol_fecha_fin(String usu_rol_fecha_fin) {
        this.usu_rol_fecha_fin = usu_rol_fecha_fin;
    }

    @Override
    public String toString() {
        return "Users_rol{" +
                "usu_rol_rol_id='" + usu_rol_rol_id + '\'' +
                ", usu_rol_usu_correo='" + usu_rol_usu_correo + '\'' +
                ", usu_rol_fecha_inicio='" + usu_rol_fecha_inicio + '\'' +
                ", usu_rol_fecha_fin='" + usu_rol_fecha_fin + '\'' +
                '}';
    }
}
