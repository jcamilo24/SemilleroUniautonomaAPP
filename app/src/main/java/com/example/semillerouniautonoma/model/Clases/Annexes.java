package com.example.semillerouniautonoma.model.Clases;


public class Annexes {
    public static final String TABLE_NAME = "Annexes";

    public static final String COLUMN_ANE_ID = "ane_id";
    public static final String COLUMN_ANE_SEM_ID = "ane_sem_id";
    public static final String COLUMN_ANE_NOMBRE = "ane_nombre";
    public static final String COLUMN_ANE_DESCRIPCION = "ane_descripcion";
    public static final String COLUMN_ANE_TIPO = "ane_tipo";

    private String ane_id;
    private String ane_sem_id;
    private String ane_nombre;
    private String ane_descripcion;
    private String ane_tipo;

    public Annexes(String ane_id, String ane_sem_id, String ane_nombre, String ane_descripcion, String ane_tipo) {
        this.ane_id = ane_id;
        this.ane_sem_id = ane_sem_id;
        this.ane_nombre = ane_nombre;
        this.ane_descripcion = ane_descripcion;
        this.ane_tipo = ane_tipo;
    }

    public String getAne_id() {
        return ane_id;
    }

    public void setAne_id(String ane_id) {
        this.ane_id = ane_id;
    }

    public String getAne_sem_id() {
        return ane_sem_id;
    }

    public void setAne_sem_id(String ane_sem_id) {
        this.ane_sem_id = ane_sem_id;
    }

    public String getAne_nombre() {
        return ane_nombre;
    }

    public void setAne_nombre(String ane_nombre) {
        this.ane_nombre = ane_nombre;
    }

    public String getAne_descripcion() {
        return ane_descripcion;
    }

    public void setAne_descripcion(String ane_descripcion) {
        this.ane_descripcion = ane_descripcion;
    }

    public String getAne_tipo() {
        return ane_tipo;
    }

    public void setAne_tipo(String ane_tipo) {
        this.ane_tipo = ane_tipo;
    }

    @Override
    public String toString() {
        return "Annexes{" +
                "id='" + ane_id + '\'' +
                ", id_semillero='" + ane_sem_id + '\'' +
                ", nombre='" + ane_nombre + '\'' +
                ", descripcion='" + ane_descripcion + '\'' +
                ", tipo='" + ane_tipo + '\'' +
                '}';
    }
}
