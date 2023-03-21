package com.example.semillerouniautonoma.model.Clases;

import java.util.Date;

public class Projects {

    public static final String TABLE_NAME = "Projects";

    public static final String COLUMN_SEM_ID = "sem_id";
    public static final String COLUMN_SEM_NOMBRE = "sem_nombre";
    public static final String COLUMN_PROY_ID = "proy_id";
    public static final String COLUMN_PROY_NOMBRE = "proy_nombre";
    public static final String COLUMN_PROY_IMAGEN = "proy_imagen";
    public static final String COLUMN_PROY_DESCRIPCION = "proy_descripcion";
    public static final String COLUMN_PROY_FECHA_INICIO = "proy_fecha_inicio";
    public static final String COLUMN_PROY_FECHA_FIN = "proy_fecha_fin";
    public static final String COLUMN_SEM_PROY_ID = "sem_proy_id";
    public static final String COLUMN_SEM_PROY_ESTADO = "sem_proy_estado";
    public static final String COLUMN_SEM_PROY_FECHA_INICIO = "sem_proy_fecha_inicio";
    public static final String COLUMN_SEM_PROY_FECHA_FIN = "sem_proy_fecha_fin";


    private String sem_id;
    private String sem_nombre;
    private String proy_id;
    private String proy_nombre;
    private String proy_imagen;
    private String proy_descripcion;
    private Date proy_fecha_inicio;
    private Date proy_fecha_fin;
    private String sem_proy_id;
    private Date sem_proy_fecha_inicio;
    private Date sem_proy_fecha_fin;
    private String sem_proy_estado;

    public Projects(String sem_id, String sem_nombre, String proy_id, String proy_nombre, String proy_imagen, String proy_descripcion, Date proy_fecha_inicio, Date proy_fecha_fin, String sem_proy_id, String sem_proy_estado, Date sem_proy_fecha_inicio, Date sem_proy_fecha_fin) {
        this.sem_id = sem_id;
        this.sem_nombre = sem_nombre;
        this.proy_id = proy_id;
        this.proy_nombre = proy_nombre;
        this.proy_imagen = proy_imagen;
        this.proy_descripcion = proy_descripcion;
        this.proy_fecha_inicio = proy_fecha_inicio;
        this.proy_fecha_fin = proy_fecha_fin;
        this.sem_proy_id = sem_proy_id;
        this.sem_proy_fecha_inicio = sem_proy_fecha_inicio;
        this.sem_proy_fecha_fin = sem_proy_fecha_fin;
        this.sem_proy_estado = sem_proy_estado;
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

    public String getProy_id() {
        return proy_id;
    }

    public void setProy_id(String proy_id) {
        this.proy_id = proy_id;
    }

    public String getProy_nombre() {
        return proy_nombre;
    }

    public void setProy_nombre(String proy_nombre) {
        this.proy_nombre = proy_nombre;
    }

    public String getProy_imagen() {
        return proy_imagen;
    }

    public void setProy_imagen(String proy_imagen) {
        this.proy_imagen = proy_imagen;
    }

    public String getProy_descripcion() {
        return proy_descripcion;
    }

    public void setProy_descripcion(String proy_descripcion) {
        this.proy_descripcion = proy_descripcion;
    }

    public Date getProy_fecha_inicio() {
        return proy_fecha_inicio;
    }

    public void setProy_fecha_inicio(Date proy_fecha_inicio) {
        this.proy_fecha_inicio = proy_fecha_inicio;
    }

    public Date getProy_fecha_fin() {
        return proy_fecha_fin;
    }

    public void setProy_fecha_fin(Date proy_fecha_fin) {
        this.proy_fecha_fin = proy_fecha_fin;
    }

    public String getSem_proy_id() {
        return sem_proy_id;
    }

    public void setSem_proy_id(String sem_proy_id) {
        this.sem_proy_id = sem_proy_id;
    }

    public String getSem_proy_estado() {
        return sem_proy_estado;
    }

    public void setSem_proy_estado(String sem_proy_estado) {
        this.sem_proy_estado = sem_proy_estado;
    }

    public Date getSem_proy_fecha_inicio() {
        return sem_proy_fecha_inicio;
    }

    public void setSem_proy_fecha_inicio(Date sem_proy_fecha_inicio) {
        this.sem_proy_fecha_inicio = sem_proy_fecha_inicio;
    }

    public Date getSem_proy_fecha_fin() {
        return sem_proy_fecha_fin;
    }

    public void setSem_proy_fecha_fin(Date sem_proy_fecha_fin) {
        this.sem_proy_fecha_fin = sem_proy_fecha_fin;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "sem_id='" + sem_id + '\'' +
                ", sem_nombre='" + sem_nombre + '\'' +
                ", proy_id='" + proy_id + '\'' +
                ", proy_nombre='" + proy_nombre + '\'' +
                ", proy_imagen='" + proy_imagen + '\'' +
                ", proy_descripcion='" + proy_descripcion + '\'' +
                ", proy_fecha_inicio=" + proy_fecha_inicio +
                ", proy_fecha_fin=" + proy_fecha_fin +
                ", sem_proy_id='" + sem_proy_id + '\'' +
                ", sem_proy_estado='" + sem_proy_estado + '\'' +
                ", sem_proy_fecha_inicio=" + sem_proy_fecha_inicio +
                ", sem_proy_fecha_fin=" + sem_proy_fecha_fin +
                '}';
    }
}
