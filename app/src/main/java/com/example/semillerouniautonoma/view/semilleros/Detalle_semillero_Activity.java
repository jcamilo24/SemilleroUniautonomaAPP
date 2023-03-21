package com.example.semillerouniautonoma.view.semilleros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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
import android.widget.Toast;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.databinding.ActivityDetalleSemilleroBinding;
import com.example.semillerouniautonoma.databinding.ActivityMainBinding;
import com.example.semillerouniautonoma.model.Adapters.listAdapterAnnexes;
import com.example.semillerouniautonoma.model.Clases.Annexes;
import com.example.semillerouniautonoma.model.Interfaces.AnnexesService;
import com.example.semillerouniautonoma.view.Contacto_lider_semillero;
import com.example.semillerouniautonoma.view.MainActivity;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import kotlin.LateinitKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detalle_semillero_Activity extends AppCompatActivity {

    private ActivityDetalleSemilleroBinding binding;
    String titulo = "";
    String fecha1 = "";
    String descripcion = "";
    String nombre = "";
    String correo_usu="";
    String codigo_sem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleSemilleroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            titulo = extras.getString("text");
            fecha1 = extras.getString("textfecha");
            descripcion = extras.getString("descripcion");
            nombre = extras.getString("nombre");
            correo_usu = extras.getString("correo");
            codigo_sem = extras.getString("codigo_sem");
        }
        binding.edu1.setText(titulo);
        binding.textfecha.setText(fecha1);
        binding.descripcion1.setText(descripcion);
        String knombre = nombre.toString().replaceAll("null","");
        binding.nombreLider.setText(knombre);
        binding.imagenAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String finalCorreo_usu = correo_usu;
        String finalCodigo_sem1 = codigo_sem;
        binding.imageContactoLider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Contacto_lider_semillero.class);
                intent.putExtra("correo_usuario", finalCorreo_usu);
                intent.putExtra("codigo_semillero", finalCodigo_sem1);
                intent.putExtra("text", titulo);
                intent.putExtra("textfecha", fecha1);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("nombre", nombre);
                intent.putExtra("correo", correo_usu);
                intent.putExtra("codigo_sem", codigo_sem);
                startActivity(intent);
            }
        });
        String finalCodigo_sem = codigo_sem;
        referenciar(finalCodigo_sem);
    }


    public void referenciar(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AnnexesService service = retrofit.create(AnnexesService.class);
        Call<List<Annexes>> call = service.Annexe(id);
        call.enqueue(new Callback<List<Annexes>>() {
            @Override
            public void onResponse(Call<List<Annexes>> call, Response<List<Annexes>> response) {
                Log.e("lista", response.body().toString());
                List<Annexes> AnnexesList = response.body();
                listAdapterAnnexes listAdapter = new listAdapterAnnexes(AnnexesList, getApplicationContext(), id);
                binding.listAnnexes.setHasFixedSize(true);
                binding.listAnnexes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                binding.listAnnexes.setAdapter(listAdapter);
                binding.preview.stopShimmer();
                binding.preview.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Annexes>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }

}