package com.example.semillerouniautonoma.model.Clases;

import java.util.Date;
import java.util.List;

public class SeedbedsByuser {

    public static final String TABLE_NAME = "SeedbedsByuser";

    public static final String COLUMN_SEM_ID = "sem_id";
    public static final String COLUMN_SEM_NOMBRE = "sem_nombre";
    public static final String COLUMN_SEM_FECHA_INICIO = "sem_fecha_inicio";
    public static final String COLUMN_SEM_DESCRIPCION = "sem_descripcion";
    public static final String COLUMN_SEM_FACULTAD = "sem_facultad";
    public static final String COLUMN_USU_CORREO = "usu_correo";
    public static final String COLUMN_USU_NOMBRES = "usu_nombres";
    public static final String COLUMN_ROL_NOMBRE = "rol_nombre";


    private String sem_id;
    private String sem_nombre;
    private Date sem_fecha_inicio;
    private String sem_descripcion;
    private String sem_facultad;
    private String sem_imagen;
    private String usu_sem_id;
    private String usu_sem_estado_miembro;
    private Date usu_sem_fecha_inicio;
    private Date usu_sem_fecha_fin;
    private String usu_sem_token;
    private String usu_correo;
    private String usu_nombres;
    private String rol_id;
    private String rol_nombre;
    private List<SeedbedMembers> members;

    public SeedbedsByuser(String sem_id, String sem_nombre, Date sem_fecha_inicio, String sem_descripcion, String sem_facultad, String sem_imagen, String usu_sem_id, String usu_sem_estado_miembro, Date usu_sem_fecha_inicio, Date usu_sem_fecha_fin, String usu_sem_token, String usu_correo, String usu_nombres, String rol_id, String rol_nombre, List<SeedbedMembers> members) {
        this.sem_id = sem_id;
        this.sem_nombre = sem_nombre;
        this.sem_fecha_inicio = sem_fecha_inicio;
        this.sem_descripcion = sem_descripcion;
        this.sem_facultad = sem_facultad;
        this.sem_imagen = sem_imagen;
        this.usu_sem_id = usu_sem_id;
        this.usu_sem_estado_miembro = usu_sem_estado_miembro;
        this.usu_sem_fecha_inicio = usu_sem_fecha_inicio;
        this.usu_sem_fecha_fin = usu_sem_fecha_fin;
        this.usu_sem_token = usu_sem_token;
        this.usu_correo = usu_correo;
        this.usu_nombres = usu_nombres;
        this.rol_id = rol_id;
        this.rol_nombre = rol_nombre;
        this.members = members;
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

    public String getSem_facultad() {
        return sem_facultad;
    }

    public void setSem_facultad(String sem_facultad) {
        this.sem_facultad = sem_facultad;
    }

    public String getSem_imagen() {
        return sem_imagen;
    }

    public void setSem_imagen(String sem_imagen) {
        this.sem_imagen = sem_imagen;
    }

    public String getUsu_sem_id() {
        return usu_sem_id;
    }

    public void setUsu_sem_id(String usu_sem_id) {
        this.usu_sem_id = usu_sem_id;
    }

    public String getUsu_sem_estado_miembro() {
        return usu_sem_estado_miembro;
    }

    public void setUsu_sem_estado_miembro(String usu_sem_estado_miembro) {
        this.usu_sem_estado_miembro = usu_sem_estado_miembro;
    }

    public Date getUsu_sem_fecha_inicio() {
        return usu_sem_fecha_inicio;
    }

    public void setUsu_sem_fecha_inicio(Date usu_sem_fecha_inicio) {
        this.usu_sem_fecha_inicio = usu_sem_fecha_inicio;
    }

    public Date getUsu_sem_fecha_fin() {
        return usu_sem_fecha_fin;
    }

    public void setUsu_sem_fecha_fin(Date usu_sem_fecha_fin) {
        this.usu_sem_fecha_fin = usu_sem_fecha_fin;
    }

    public String getUsu_sem_token() {
        return usu_sem_token;
    }

    public void setUsu_sem_token(String usu_sem_token) {
        this.usu_sem_token = usu_sem_token;
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

    public List<SeedbedMembers> getMembers() {
        return members;
    }

    public void setMembers(List<SeedbedMembers> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "SeedbedsByuser{" +
                "sem_id='" + sem_id + '\'' +
                ", sem_nombre='" + sem_nombre + '\'' +
                ", sem_fecha_inicio=" + sem_fecha_inicio +
                ", sem_descripcion='" + sem_descripcion + '\'' +
                ", sem_facultad='" + sem_facultad + '\'' +
                ", sem_imagen='" + sem_imagen + '\'' +
                ", usu_sem_id='" + usu_sem_id + '\'' +
                ", usu_sem_estado_miembro='" + usu_sem_estado_miembro + '\'' +
                ", usu_sem_fecha_inicio=" + usu_sem_fecha_inicio +
                ", usu_sem_fecha_fin=" + usu_sem_fecha_fin +
                ", usu_sem_token='" + usu_sem_token + '\'' +
                ", usu_correo='" + usu_correo + '\'' +
                ", usu_nombres='" + usu_nombres + '\'' +
                ", rol_id='" + rol_id + '\'' +
                ", rol_nombre='" + rol_nombre + '\'' +
                ", members=" + members +
                '}';
    }
}
