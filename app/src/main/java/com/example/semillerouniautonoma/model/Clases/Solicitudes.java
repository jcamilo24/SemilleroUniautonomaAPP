package com.example.semillerouniautonoma.model.Clases;

public class Solicitudes {

    public static final String TABLE_NAME = "Solicitudes";

    public static final String COLUMN_USU_SEM_ID = "usu_sem_id";
    public static final String COLUMN_USU_SEM_SEM_ID = "usu_sem_sem_id";
    public static final String COLUMN_USU_SEM_USU_CORREO = "usu_sem_usu_correo";
    public static final String COLUMN_SEM_NOMBRE = "sem_nombre";
    public static final String COLUMN_SEM_FACULTAD = "sem_facultad";
    public static final String COLUMN_USU_NOMBRES = "usu_nombres";
    public static final String COLUMN_ROL_NOMBRE = "rol_nombre";
    public static final String COLUMN_USU_SEM_ESTADO_MIEMBRO = "usu_sem_estado_miembro";
    public static final String COLUMN_USU_SEM_FECHA_INICIO = "usu_sem_fecha_inicio";
    public static final String COLUMN_USU_SEM_FECHA_FIN = "usu_sem_fecha_fin";


    private String usu_sem_id;
    private String usu_sem_sem_id;
    private String usu_sem_usu_correo;
    private String sem_nombre;
    private String sem_facultad;
    private String usu_nombres;
    private String rol_nombre;
    private String usu_sem_estado_miembro;
    private String usu_sem_fecha_inicio;
    private String usu_sem_fecha_fin;

    public Solicitudes(String usu_sem_id, String usu_sem_sem_id, String usu_sem_usu_correo, String sem_nombre, String sem_facultad, String usu_nombres, String rol_nombre, String usu_sem_estado_miembro, String usu_sem_fecha_inicio, String usu_sem_fecha_fin) {
        this.usu_sem_id = usu_sem_id;
        this.usu_sem_sem_id = usu_sem_sem_id;
        this.usu_sem_usu_correo = usu_sem_usu_correo;
        this.sem_nombre = sem_nombre;
        this.sem_facultad = sem_facultad;
        this.usu_nombres = usu_nombres;
        this.rol_nombre = rol_nombre;
        this.usu_sem_estado_miembro = usu_sem_estado_miembro;
        this.usu_sem_fecha_inicio = usu_sem_fecha_inicio;
        this.usu_sem_fecha_fin = usu_sem_fecha_fin;
    }

    public String getUsu_sem_id() {
        return usu_sem_id;
    }

    public void setUsu_sem_id(String usu_sem_id) {
        this.usu_sem_id = usu_sem_id;
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

    public String getSem_nombre() {
        return sem_nombre;
    }

    public void setSem_nombre(String sem_nombre) {
        this.sem_nombre = sem_nombre;
    }

    public String getSem_facultad() {
        return sem_facultad;
    }

    public void setSem_facultad(String sem_facultad) {
        this.sem_facultad = sem_facultad;
    }

    public String getUsu_nombres() {
        return usu_nombres;
    }

    public void setUsu_nombres(String usu_nombres) {
        this.usu_nombres = usu_nombres;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
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

    public String getUsu_sem_fecha_fin() {
        return usu_sem_fecha_fin;
    }

    public void setUsu_sem_fecha_fin(String usu_sem_fecha_fin) {
        this.usu_sem_fecha_fin = usu_sem_fecha_fin;
    }

    @Override
    public String toString() {
        return "Solicitudes{" +
                "usu_sem_id='" + usu_sem_id + '\'' +
                ", usu_sem_sem_id='" + usu_sem_sem_id + '\'' +
                ", usu_sem_usu_correo='" + usu_sem_usu_correo + '\'' +
                ", sem_nombre='" + sem_nombre + '\'' +
                ", sem_facultad='" + sem_facultad + '\'' +
                ", usu_nombres='" + usu_nombres + '\'' +
                ", rol_nombre='" + rol_nombre + '\'' +
                ", usu_sem_estado_miembro='" + usu_sem_estado_miembro + '\'' +
                ", usu_sem_fecha_inicio='" + usu_sem_fecha_inicio + '\'' +
                ", usu_sem_fecha_fin='" + usu_sem_fecha_fin + '\'' +
                '}';
    }
}
