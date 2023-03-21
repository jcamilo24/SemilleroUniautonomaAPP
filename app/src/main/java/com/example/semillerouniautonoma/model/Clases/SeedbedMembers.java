package com.example.semillerouniautonoma.model.Clases;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class SeedbedMembers {

    public static final String TABLE_NAME = "SeedbedMembers";

    public static final String COLUMN_USU_CORREO = "usu_correo";
    public static final String COLUMN_USU_NOMBRES = "usu_nombres";
    public static final String COLUMN_USU_IMAGEN = "usu_imagen";
    public static final String COLUMN_SEM_ID = "sem_id";
    public static final String COLUMN_SEM_NOMBRE = "sem_nombre";

    private String usu_correo;
    private String usu_nombres;
    private String usu_imagen;
    private String sem_id;
    private String sem_nombre;

    public SeedbedMembers(String usu_correo, String usu_nombres, String usu_imagen, String sem_id, String sem_nombre) {
        this.usu_correo = usu_correo;
        this.usu_nombres = usu_nombres;
        this.usu_imagen = usu_imagen;
        this.sem_id = sem_id;
        this.sem_nombre = sem_nombre;
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

    public String getSem_id() {
        return sem_id;
    }

    public void setSem_id(String sem_id) {
        this.sem_id = sem_id;
    }

    public String getSem_nombre() {
        return sem_nombre;
    }

    public void setSem_nombre(String sem_nombre) {
        this.sem_nombre = sem_nombre;
    }

    @Override
    public String toString() {
        return "SeedbedMembers{" +
                "usu_correo='" + usu_correo + '\'' +
                ", usu_nombres='" + usu_nombres + '\'' +
                ", usu_imagen='" + usu_imagen + '\'' +
                ", sem_id='" + sem_id + '\'' +
                ", sem_nombre='" + sem_nombre + '\'' +
                '}';
    }
}
