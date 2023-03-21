package com.example.semillerouniautonoma.model.Clases;

public class Questions {
    public static final String TABLE_NAME = "Questions";

    public static final String COLUMN_PRE_ID = "pre_id";
    public static final String COLUMN_PRE_USUARIO_CORREO = "pre_usuario_correo";
    public static final String COLUMN_PRE_CATEGORIAS = "pre_categoria";
    public static final String COLUMN_PRE_PREGUNTAS = "pre_preguntas";
    public static final String COLUMN_PRE_RESPUESTAS = "pre_respuestas";
  
    private String pre_id;
    private String pre_usu_correo;
    private String pre_categoria;
    private String pre_pregunta;
    private String pre_respuesta;

    public Questions(String pre_id, String pre_usu_correo, String pre_categoria, String pre_pregunta, String pre_respuesta) {
        this.pre_id = pre_id;
        this.pre_usu_correo = pre_usu_correo;
        this.pre_categoria = pre_categoria;
        this.pre_pregunta = pre_pregunta;
        this.pre_respuesta = pre_respuesta;
    }

    public String getPre_id() {
        return pre_id;
    }

    public void setPre_id(String pre_id) {
        this.pre_id = pre_id;
    }

    public String getPre_usu_correo() {
        return pre_usu_correo;
    }

    public void setPre_usu_correo(String pre_usu_correo) {
        this.pre_usu_correo = pre_usu_correo;
    }

    public String getPre_categoria() {
        return pre_categoria;
    }

    public void setPre_categoria(String pre_categoria) {
        this.pre_categoria = pre_categoria;
    }

    public String getPre_pregunta() {
        return pre_pregunta;
    }

    public void setPre_pregunta(String pre_pregunta) {
        this.pre_pregunta = pre_pregunta;
    }

    public String getPre_respuesta() {
        return pre_respuesta;
    }

    public void setPre_respuesta(String pre_respuesta) {
        this.pre_respuesta = pre_respuesta;
    }

    @Override
    public String toString() {
        return "preguntas{" +
                "id='" + pre_id + '\'' +
                ", correo_usuario='" + pre_usu_correo + '\'' +
                ", categoria='" + pre_categoria + '\'' +
                ", pregunta='" + pre_pregunta + '\'' +
                ", respuesta='" + pre_respuesta + '\'' +
                '}';
    }
}
