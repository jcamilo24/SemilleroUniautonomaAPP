package com.example.semillerouniautonoma.model.Clases;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class seedbedFacultad {

    public static final String TABLE_NAME = "seedbedFacultad";

    public static final String COLUMN_SEM_ID = "sem_id";
    public static final String COLUMN_SEM_NOMBRE = "sem_nombre";
    public static final String COLUMN_SEM_FECHA_INICIO = "sem_fecha_inicio";
    public static final String COLUMN_SEM_DESCRIPCION = "sem_descripcion";

    private String sem_id;
    private String sem_nombre;
    private Date sem_fecha_inicio;
    private String sem_descripcion;
    private ArrayList<SemLider> sem_lider;


    public seedbedFacultad(String sem_id, String sem_nombre, Date sem_fecha_inicio, String sem_descripcion, ArrayList<SemLider> sem_lider) {
        this.sem_id = sem_id;
        this.sem_nombre = sem_nombre;
        this.sem_fecha_inicio = sem_fecha_inicio;
        this.sem_descripcion = sem_descripcion;
        this.sem_lider = sem_lider;
    }

    public ArrayList<SemLider> getSem_lider() {
        return sem_lider;
    }
    public void setSem_lider(ArrayList<SemLider> sem_lider) {
        this.sem_lider = sem_lider;
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

    public Date getSem_fecha_inicio() {
        return sem_fecha_inicio;
    }
    public void setSem_fecha_inicio(Date sem_fecha_inicio) {
        this.sem_fecha_inicio = sem_fecha_inicio;
    }

    public String getSem_descripcion() {
        return sem_descripcion;
    }
    public void setSem_descripcion(String sem_descripcion) {
        this.sem_descripcion = sem_descripcion;
    }

    @Override
    public String toString() {
        return "seedbedsFacultad{" +
                "sem_id='" + sem_id + '\'' +
                ", sem_nombre='" + sem_nombre + '\'' +
                ", sem_fecha_inicio='" + sem_fecha_inicio + '\'' +
                ", sem_descripcion='" + sem_descripcion + '\'' +
                ", sem_Lider='" + sem_lider + '\'' +
                '}';
    }
}
