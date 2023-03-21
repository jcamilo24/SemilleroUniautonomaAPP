package com.example.semillerouniautonoma.model.Clases;

import java.util.Date;

public class ProductByProject {

    public static final String TABLE_NAME = "ProductByProject";

    public static final String COLUMN_PROY_ID = "proy_id";
    public static final String COLUMN_PROY_NOMBRE = "proy_nombre";
    public static final String COLUMN_PROD_ID = "prod_id";
    public static final String COLUMN_PROD_NOMBRE = "prod_nombre";
    public static final String COLUMN_PROD_DESCRIPCION = "prod_descripcion";
    public static final String COLUMN_PROD_PRODUCTO_COLCIENCIA = "prod_producto_colciencia";
    public static final String COLUMN_PROD_FECHA_REGISTRO = "prod_fecha_registro";
    public static final String COLUMN_PROY_PROD_ID = "proy_prod_id";
    public static final String COLUMN_PROY_PROD_PROY_ID = "proy_prod_proy_id";
    public static final String COLUMN_PROY_PROD_PROD_ID = "proy_prod_prod_id";
    public static final String COLUMN_PROY_PROD_FECHA_ASOCIACION = "proy_prod_fecha_asociacion";


    private String proy_id;
    private String proy_nombre;
    private String prod_id;
    private String prod_nombre;
    private String prod_descripcion;
    private String prod_producto_colciencia;
    private Date prod_fecha_registro;
    private String proy_prod_id;
    private String proy_prod_proy_id;
    private String proy_prod_prod_id;
    private Date proy_prod_fecha_asociacion;

    public ProductByProject(String proy_id, String proy_nombre, String prod_id, String prod_nombre, String prod_descripcion, String prod_producto_colciencia, Date prod_fecha_registro, String proy_prod_id, String proy_prod_proy_id, String proy_prod_prod_id, Date proy_prod_fecha_asociacion) {
        this.proy_id = proy_id;
        this.proy_nombre = proy_nombre;
        this.prod_id = prod_id;
        this.prod_nombre = prod_nombre;
        this.prod_descripcion = prod_descripcion;
        this.prod_producto_colciencia = prod_producto_colciencia;
        this.prod_fecha_registro = prod_fecha_registro;
        this.proy_prod_id = proy_prod_id;
        this.proy_prod_proy_id = proy_prod_proy_id;
        this.proy_prod_prod_id = proy_prod_prod_id;
        this.proy_prod_fecha_asociacion = proy_prod_fecha_asociacion;
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

    public String getProy_prod_id() {
        return proy_prod_id;
    }

    public void setProy_prod_id(String proy_prod_id) {
        this.proy_prod_id = proy_prod_id;
    }

    public String getProy_prod_proy_id() {
        return proy_prod_proy_id;
    }

    public void setProy_prod_proy_id(String proy_prod_proy_id) {
        this.proy_prod_proy_id = proy_prod_proy_id;
    }

    public String getProy_prod_prod_id() {
        return proy_prod_prod_id;
    }

    public void setProy_prod_prod_id(String proy_prod_prod_id) {
        this.proy_prod_prod_id = proy_prod_prod_id;
    }

    public Date getProy_prod_fecha_asociacion() {
        return proy_prod_fecha_asociacion;
    }

    public void setProy_prod_fecha_asociacion(Date proy_prod_fecha_asociacion) {
        this.proy_prod_fecha_asociacion = proy_prod_fecha_asociacion;
    }

    @Override
    public String toString() {
        return "ProductByProject{" +
                "proy_id='" + proy_id + '\'' +
                ", proy_nombre='" + proy_nombre + '\'' +
                ", prod_id='" + prod_id + '\'' +
                ", prod_nombre='" + prod_nombre + '\'' +
                ", prod_descripcion='" + prod_descripcion + '\'' +
                ", prod_producto_colciencia='" + prod_producto_colciencia + '\'' +
                ", prod_fecha_registro=" + prod_fecha_registro +
                ", proy_prod_id='" + proy_prod_id + '\'' +
                ", proy_prod_proy_id='" + proy_prod_proy_id + '\'' +
                ", proy_prod_prod_id='" + proy_prod_prod_id + '\'' +
                ", proy_prod_fecha_asociacion=" + proy_prod_fecha_asociacion +
                '}';
    }
}
