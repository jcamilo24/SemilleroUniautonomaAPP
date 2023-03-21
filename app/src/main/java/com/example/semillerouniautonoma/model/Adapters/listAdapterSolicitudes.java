package com.example.semillerouniautonoma.model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.SeedbedsByuser;
import com.example.semillerouniautonoma.model.Clases.Solicitudes;
import com.example.semillerouniautonoma.model.Clases.Users_seedbed;
import com.example.semillerouniautonoma.model.Interfaces.SeedbedsService;
import com.example.semillerouniautonoma.view.inicio_logueados_docentes.contacto_estudents_Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listAdapterSolicitudes extends RecyclerView.Adapter<listAdapterSolicitudes.parentViewHolder> {
    private List<Solicitudes> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String correo;
    private String id_sem;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public listAdapterSolicitudes(List<Solicitudes> itemList, Context context, String id_sem) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.correo = correo;
        this.id_sem = id_sem;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterSolicitudes.parentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listsolicitudes, null);
        return new listAdapterSolicitudes.parentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterSolicitudes.parentViewHolder holder, final int position) {
        holder.bindData(mData.get(position), holder);
        holder.setOnClickListeners();
    }

    public void setItems(List<Solicitudes> items) {
        mData = items;
    }

    public class parentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titulo,nombre_estudiante,facultad_estudiante,rol_estudiante,correo_estudiante,estado_miembro_estudiante;
        CardView expand;
        LinearLayout layout;
        Context context;
        ImageView image_contacto_pendiente;
        Button aceptar_estudiante,rechazar_estudiante;
        String codigo;

        public RecyclerView ChildRecyclerView;

        parentViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            titulo = itemView.findViewById(R.id.titulo);
            nombre_estudiante = itemView.findViewById(R.id.nombre_estudiante);
            facultad_estudiante = itemView.findViewById(R.id.facultad_estudiante);
            rol_estudiante = itemView.findViewById(R.id.rol_estudiante);
            correo_estudiante = itemView.findViewById(R.id.correo_estudiante);
            estado_miembro_estudiante = itemView.findViewById(R.id.estado_miembro_estudiante);
            image_contacto_pendiente = itemView.findViewById(R.id.image_contacto_pendiente);
            aceptar_estudiante = itemView.findViewById(R.id.aceptar_estudiante);
            rechazar_estudiante = itemView.findViewById(R.id.rechazar_estudiante);

            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);

            ChildRecyclerView = itemView.findViewById(R.id.listmiembros_semillero);
        }

        void setOnClickListeners() {
            titulo.setOnClickListener(this);
            image_contacto_pendiente.setOnClickListener(this);
            aceptar_estudiante.setOnClickListener(this);
            rechazar_estudiante.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.titulo:
                    int v2 = (expand.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
                    break;
                case R.id.image_contacto_pendiente:
                    Intent intent = new Intent(context, contacto_estudents_Activity.class);
                    intent.putExtra("correo_miembro", correo_estudiante.getText());
                    context.startActivity(intent);
                    break;
                case R.id.aceptar_estudiante:
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    SeedbedsService service = retrofit.create(SeedbedsService.class);
                    Call<Users_seedbed> call = service.updateUserSeedbed(codigo,"activo");
                    call.enqueue(new Callback<Users_seedbed>() {
                        @Override
                        public void onResponse(Call<Users_seedbed> call, Response<Users_seedbed> response) {
                            Toast.makeText(context, "Estudiante Incorporado con Exito", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Users_seedbed> call, Throwable t) {
                            Log.e("lista", t.toString());
                        }
                    });
                    break;
                case R.id.rechazar_estudiante:
                    Retrofit retrofit2 = new Retrofit.Builder()
                            .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    SeedbedsService service2 = retrofit2.create(SeedbedsService.class);
                    Call<Users_seedbed> call2 = service2.updateUserSeedbed(codigo,"inactivo");
                    call2.enqueue(new Callback<Users_seedbed>() {
                        @Override
                        public void onResponse(Call<Users_seedbed> call, Response<Users_seedbed> response) {
                            Toast.makeText(context, "Estudiante Rechazado con Exito", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Users_seedbed> call, Throwable t) {
                            Log.e("lista", t.toString());
                        }
                    });
                    break;
            }
        }

        void bindData(final Solicitudes item, listAdapterSolicitudes.parentViewHolder holder) {
            if (item.getUsu_sem_sem_id().equals(id_sem)) {
                codigo = item.getUsu_sem_id();

                String nombre = item.getUsu_nombres();
                String output = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                nombre_estudiante.setText(output);

                String facultad = item.getSem_facultad();
                String output2 = facultad.substring(0, 1).toUpperCase() + facultad.substring(1);
                facultad_estudiante.setText(output2);

                String rol = item.getRol_nombre();
                String output3 = rol.substring(0, 1).toUpperCase() + rol.substring(1);
                rol_estudiante.setText(output3);

                String correoo = item.getUsu_sem_usu_correo();
                String output4 = correoo.substring(0, 1).toUpperCase() + correoo.substring(1);
                correo_estudiante.setText(output4);

                String estado = item.getUsu_sem_estado_miembro();
                String output5 = estado.substring(0, 1).toUpperCase() + estado.substring(1);
                estado_miembro_estudiante.setText(output5);
           }
        }
    }
}

