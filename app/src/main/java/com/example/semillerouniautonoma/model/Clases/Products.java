package com.example.semillerouniautonoma.model.Clases;

import java.util.Date;

public class Products {
    public static final String TABLE_NAME = "Products";

    public static final String COLUMN_SEM_ID = "sem_id";
    public static final String COLUMN_SEM_NOMBRE = "sem_nombre";
    public static final String COLUMN_PROD_ID = "prod_id";
    public static final String COLUMN_PROD_NOMBRE = "prod_nombre";
    public static final String COLUMN_PROD_DESCRIPCION = "prod_descripcion";
    public static final String COLUMN_PROD_PRODUCTO_COLCIENCIA = "prod_producto_colciencia";
    public static final String COLUMN_PROD_FECHA_REGISTRO = "prod_fecha_registro";



    private String sem_id;
    private String sem_nombre;
    private String prod_id;
    private String prod_nombre;
    private String prod_descripcion;
    private String prod_producto_colciencia;
    private Date prod_fecha_registro;

    public Products(String sem_id, String sem_nombre, String prod_id, String prod_nombre, String prod_descripcion, String prod_producto_colciencia, Date prod_fecha_registro) {
        this.sem_id = sem_id;
        this.sem_nombre = sem_nombre;
        this.prod_id = prod_id;
        this.prod_nombre = prod_nombre;
        this.prod_descripcion = prod_descripcion;
        this.prod_producto_colciencia = prod_producto_colciencia;
        this.prod_fecha_registro = prod_fecha_registro;
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

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public String getProd_producto_colciencia() {
        return prod_producto_colciencia;
    }

    public void setProd_producto_colciencia(String prod_producto_colciencia) {
        this.prod_producto_colciencia = prod_producto_colciencia;
    }

    public Date getProd_fecha_registro() {
        return prod_fecha_registro;
    }

    public void setProd_fecha_registro(Date prod_fecha_registro) {
        this.prod_fecha_registro = prod_fecha_registro;
    }

    @Override
    public String toString() {
        return "Products{" +
                "sem_id='" + sem_id + '\'' +
                ", sem_nombre='" + sem_nombre + '\'' +
                ", prod_id='" + prod_id + '\'' +
                ", prod_nombre='" + prod_nombre + '\'' +
                ", prod_descripcion='" + prod_descripcion + '\'' +
                ", prod_producto_colciencia='" + prod_producto_colciencia + '\'' +
                ", prod_fecha_registro=" + prod_fecha_registro +
                '}';
    }
}
