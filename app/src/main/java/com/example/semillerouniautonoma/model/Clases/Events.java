package com.example.semillerouniautonoma.model.Clases;

import java.util.Date;

public class Events {

    public static final String TABLE_NAME = "Events";

    public static final String COLUMN_EVE_ID = "eve_id";
    public static final String COLUMN_EVE_USU_CORREO = "eve_usu_correo";
    public static final String COLUMN_EVE_USU_ADMIN = "eve_usu_admin";
    public static final String COLUMN_EVE_NOMBRE = "eve_nombre";
    public static final String COLUMN_EVE_ESTADO = "eve_estado";
    public static final String COLUMN_EVE_FECHA_INICIO = "eve_fecha_inicio";
    public static final String COLUMN_EVE_FECHA_FIN = "eve_fecha_fin";
    public static final String COLUMN_EVE_URL = "eve_url";
    public static final String COLUMN_EVE_DESCRIPCION = "eve_descripcion";


    private String eve_id;
    private String eve_usu_correo;
    private String eve_usu_admin;
    private String eve_nombre;
    private String eve_estado;
    private Date eve_fecha_inicio;
    private Date eve_fecha_fin;
    private String eve_url;
    private String eve_descripcion;

    public Events(String eve_id, String eve_usu_correo, String eve_usu_admin, String eve_nombre, String eve_estado, Date eve_fecha_inicio, Date eve_fecha_fin, String eve_url, String eve_descripcion) {
        this.eve_id = eve_id;
        this.eve_usu_correo = eve_usu_correo;
        this.eve_usu_admin = eve_usu_admin;
        this.eve_nombre = eve_nombre;
        this.eve_estado = eve_estado;
        this.eve_fecha_inicio = eve_fecha_inicio;
        this.eve_fecha_fin = eve_fecha_fin;
        this.eve_url = eve_url;
        this.eve_descripcion = eve_descripcion;
    }

    public String getEve_id() {
        return eve_id;
    }

    public void setEve_id(String eve_id) {
        this.eve_id = eve_id;
    }

    public String getEve_usu_correo() {
        return eve_usu_correo;
    }

    public void setEve_usu_correo(String eve_usu_correo) {
        this.eve_usu_correo = eve_usu_correo;
    }

    public String getEve_usu_admin() {
        return eve_usu_admin;
    }

    public void setEve_usu_admin(String eve_usu_admin) {
        this.eve_usu_admin = eve_usu_admin;
    }

    public String getEve_nombre() {
        return eve_nombre;
    }

    public void setEve_nombre(String eve_nombre) {
        this.eve_nombre = eve_nombre;
    }

    public String getEve_estado() {
        return eve_estado;
    }

    public void setEve_estado(String eve_estado) {
        this.eve_estado = eve_estado;
    }

    public Date getEve_fecha_inicio() {
        return eve_fecha_inicio;
    }

    public void setEve_fecha_inicio(Date eve_fecha_inicio) {
        this.eve_fecha_inicio = eve_fecha_inicio;
    }

    public Date getEve_fecha_fin() {
        return eve_fecha_fin;
    }

    public void setEve_fecha_fin(Date eve_fecha_fin) {
        this.eve_fecha_fin = eve_fecha_fin;
    }

    public String getEve_url() {
        return eve_url;
    }

    public void setEve_url(String eve_url) {
        this.eve_url = eve_url;
    }

    public String getEve_descripcion() {
        return eve_descripcion;
    }

    public void setEve_descripcion(String eve_descripcion) {
        this.eve_descripcion = eve_descripcion;
    }

    @Override
    public String toString() {
        return "Events{" +
                "eve_id='" + eve_id + '\'' +
                ", eve_usu_correo='" + eve_usu_correo + '\'' +
                ", eve_usu_admin='" + eve_usu_admin + '\'' +
                ", eve_nombre='" + eve_nombre + '\'' +
                ", eve_estado='" + eve_estado + '\'' +
                ", eve_fecha_inicio=" + eve_fecha_inicio +
                ", eve_fecha_fin=" + eve_fecha_fin +
                ", eve_url='" + eve_url + '\'' +
                ", eve_descripcion='" + eve_descripcion + '\'' +
                '}';
    }
}
