package com.example.semillerouniautonoma.view.publicaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.view.MainActivity;
import com.example.semillerouniautonoma.view.semilleros.IngenieriaInicioFragment;

public class Detalle_publicaciones_Activity extends AppCompatActivity {
    ImageView imganterior;
    ImageView imagendetallenews;
    static TextView titulopubli,descripciondetalle,fechadetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_publicaciones);

        String titulo = "";
        String fecha1 = "";
        String descripcion ="";
        String imagen = "";

        titulopubli = findViewById(R.id.titulopublidetalle);
        fechadetalle = findViewById(R.id.textfechadetalle);
        descripciondetalle = findViewById(R.id.descripciondetalle);
        imagendetallenews = findViewById(R.id.imagendetallenews);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            titulo = extras.getString("text");
            fecha1 = extras.getString("textfecha");
            descripcion = extras.getString("detalle");
            imagen = extras.getString("imagen");
        }
        titulopubli.setText(titulo);
        fechadetalle.setText(fecha1);
        descripciondetalle.setText(descripcion);
        Glide.with(getApplicationContext()).load(imagen).centerCrop().into(imagendetallenews);

        imganterior = findViewById(R.id.imagen_anterior);
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}