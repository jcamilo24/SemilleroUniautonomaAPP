package com.example.semillerouniautonoma.view.inicio_logueados_estudiantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterproductByProject;
import com.example.semillerouniautonoma.model.Clases.ProductByProject;
import com.example.semillerouniautonoma.model.Interfaces.ProductByProjectService;
import com.example.semillerouniautonoma.view.MainActivity;
import com.example.semillerouniautonoma.view.semilleros.IngenieriaInicioFragment;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detalle_proyecto_Activity extends AppCompatActivity {

    ImageView imganterior;
    Button button;
    ImageView imagen_a_detalle;
    RecyclerView listproductosbyIDproject;
    static TextView texttituloproject,fecha_inicio_project,fecha_fin_project,detalledecrip,estado_pro;
    CardView card_1;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_proyecto);
        shimmerFrameLayout = findViewById(R.id.preview);

        String titulo = "";
        String fecha1 = "";
        String fecha2 = "";
        String descripcion ="";
        String imagen = "";
        String estado = "";
        String id_pro = "";

        texttituloproject = findViewById(R.id.proyecto_titulo);
        fecha_inicio_project = findViewById(R.id.fecha_inicio_project_detalle);
        fecha_fin_project = findViewById(R.id.fecha_fin_project_detalle);
        detalledecrip = findViewById(R.id.descripcion_proyecto);
        estado_pro = findViewById(R.id.estado_proyecto);
        //imagen_a_detalle = findViewById(R.id.image_proyecto);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            titulo = extras.getString("titulo_pro");
            fecha1 = extras.getString("fecha_inicio");
            fecha2 = extras.getString("fecha_fin");
            descripcion = extras.getString("descripcion_pro");
            imagen = extras.getString("imagen");
            estado = extras.getString("estado");
            id_pro = extras.getString("idd");
        }
        texttituloproject.setText(titulo);
        fecha_inicio_project.setText(fecha1);
        fecha_fin_project.setText(fecha2);
        detalledecrip.setText(descripcion);
        String estadooo = estado.toString().replaceAll("_"," ");
        estado_pro.setText(estadooo);
        //Glide.with(getApplicationContext()).load(imagen).centerCrop().into(imagen_a_detalle);

        imganterior = findViewById(R.id.imagen_anterior);
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String finalCodigo_pro = id_pro;
        referenciar(finalCodigo_pro);
        listproductosbyIDproject = findViewById(R.id.listproductosbyIDproject);
    }

    public void referenciar(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductByProjectService service = retrofit.create(ProductByProjectService.class);
        Call<List<ProductByProject>> call = service.productbyproject(id);
        call.enqueue(new Callback<List<ProductByProject>>() {
            @Override
            public void onResponse(Call<List<ProductByProject>> call, Response<List<ProductByProject>> response) {
                Log.e("lista", response.body().toString());
                List<ProductByProject> productByProjectListList = response.body();
                listAdapterproductByProject listAdapter = new listAdapterproductByProject(productByProjectListList, getApplicationContext(), id);
                listproductosbyIDproject.setHasFixedSize(true);
                listproductosbyIDproject.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                listproductosbyIDproject.setAdapter(listAdapter);

                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<ProductByProject>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
}