package com.example.semillerouniautonoma.model.Clases;

import android.graphics.Bitmap;
import java.util.Date;

public class LastNews {

    public static final String TABLE_NAME = "LastNews";

    public static final String COLUMN_NOT_ID = "not_id";
    public static final String COLUMN_NOT_TITULO = "not_titulo";
    public static final String COLUMN_NOT_FECHA_PUBLICACION = "not_fecha_publicacion";
    public static final String COLUMN_NOT_DESCRIPCION = "not_descripcion";
    public static final String COLUMN_NOT_ESTADO = "not_estado";
    public static final String COLUMN_NOT_IMAGEN = "not_imagen";
    public static final String COLUMN_NOT_RESUMEN = "not_resumen";

  
    private String not_id;
    private String not_titulo;
    private Date not_fecha_publicacion;
    private String not_descripcion;
    private String not_estado;
    private String not_imagen;
    private String not_resumen;

    public LastNews(String not_id, String not_titulo, Date not_fecha_publicacion, String not_descripcion, String not_estado, String not_imagen, String not_resumen) {
        this.not_id = not_id;
        this.not_titulo = not_titulo;
        this.not_fecha_publicacion = not_fecha_publicacion;
        this.not_descripcion = not_descripcion;
        this.not_estado = not_estado;
        this.not_imagen = not_imagen;
        this.not_resumen = not_resumen;
    }

    public String getNot_id() {
        return not_id;
    }

    public void setNot_id(String not_id) {
        this.not_id = not_id;
    }

    public String getNot_titulo() {
        return not_titulo;
    }

    public void setNot_titulo(String not_titulo) {
        this.not_titulo = not_titulo;
    }

    public Date getNot_fecha_publicacion() {
        return not_fecha_publicacion;
    }

    public void setNot_fecha_publicacion(Date not_fecha_publicacion) {
        this.not_fecha_publicacion = not_fecha_publicacion;
    }

    public String getNot_descripcion() {
        return not_descripcion;
    }

    public void setNot_descripcion(String not_descripcion) {
        this.not_descripcion = not_descripcion;
    }

    public String getNot_estado() {
        return not_estado;
    }

    public void setNot_estado(String not_estado) {
        this.not_estado = not_estado;
    }

    public String getNot_imagen() {
        return not_imagen;
    }

    public void setNot_imagen(String not_imagen) {
        this.not_imagen = not_imagen;
    }

    public String getNot_resumen() {
        return not_resumen;
    }

    public void setNot_resumen(String not_resumen) {
        this.not_resumen = not_resumen;
    }

    @Override
    public String toString() {
        return "LastNews{" +
                "id='" + not_id + '\'' +
                ", titulo='" + not_titulo + '\'' +
                ", fecha_publicacion='" + not_fecha_publicacion + '\'' +
                ", descripcion='" + not_descripcion + '\'' +
                ", estado='" + not_estado + '\'' +
                ", imagen='" + not_imagen + '\'' +
                ", resumen='" + not_resumen + '\'' +
                '}';
    }
}
