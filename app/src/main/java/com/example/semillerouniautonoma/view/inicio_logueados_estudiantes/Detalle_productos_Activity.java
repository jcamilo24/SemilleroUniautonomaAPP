package com.example.semillerouniautonoma.view.inicio_logueados_estudiantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.semillerouniautonoma.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class Detalle_productos_Activity extends AppCompatActivity {
    ImageView imganterior;
    static TextView texttituloproduct,fecha_inicio_product,detalledecrip;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_productos);

        String titulo = "";
        String fecha1 = "";
        String descripcion ="";

        texttituloproduct = findViewById(R.id.producto_titulo);
        fecha_inicio_product = findViewById(R.id.fecha_inicio_product_detalle);
        detalledecrip = findViewById(R.id.descripcion_producto);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            titulo = extras.getString("text");
            fecha1 = extras.getString("textfecha");;
            descripcion = extras.getString("detalle");
        }
        texttituloproduct.setText(titulo);
        fecha_inicio_product.setText(fecha1);
        detalledecrip.setText(descripcion);

        imganterior = findViewById(R.id.imagen_anterior);
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}