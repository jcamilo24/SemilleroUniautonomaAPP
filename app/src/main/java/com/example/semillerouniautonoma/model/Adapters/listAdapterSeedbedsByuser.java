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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.Annexes;
import com.example.semillerouniautonoma.model.Clases.SeedbedsByuser;
import com.example.semillerouniautonoma.model.Clases.SemLider;
import com.example.semillerouniautonoma.model.Clases.seedbedFacultad;
import com.example.semillerouniautonoma.model.Interfaces.SeedbedsService;
import com.example.semillerouniautonoma.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listAdapterSeedbedsByuser extends RecyclerView.Adapter<listAdapterSeedbedsByuser.parentViewHolder> {
    private List<SeedbedsByuser> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String correo;
    private String id_sem;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public listAdapterSeedbedsByuser(List<SeedbedsByuser> itemList, Context context, String correo, String id_sem) {
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
    public listAdapterSeedbedsByuser.parentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listseedbedbyuser, null);
        return new listAdapterSeedbedsByuser.parentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final parentViewHolder holder, final int position) {
        holder.bindData(mData.get(position), holder);
        holder.setOnClickListeners();
    }

    public void setItems(List<SeedbedsByuser> items) {
        mData = items;
    }

    public class parentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titulo,nombre_lider,descripcion,rol;
        CardView expand;
        LinearLayout layout;
        Context context;

        public RecyclerView ChildRecyclerView;

        parentViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            titulo = itemView.findViewById(R.id.titulo_semillero);
            nombre_lider = itemView.findViewById(R.id.nombre_lider);
            descripcion = itemView.findViewById(R.id.descripcion_semillero);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
            ChildRecyclerView = itemView.findViewById(R.id.listmiembros_semillero);
        }

        void setOnClickListeners() {
            titulo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.titulo_semillero:
                    int v2 = (expand.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
                    break;
            }
        }

        void bindData(final SeedbedsByuser item, parentViewHolder holder) {
           if (item.getUsu_correo().equals(correo)) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(holder.ChildRecyclerView
                                .getContext(),LinearLayoutManager.VERTICAL,false);
                layoutManager.setInitialPrefetchItemCount(item.getMembers().size());
                listAdapterSeedbedsMembers childItemAdapter = new listAdapterSeedbedsMembers(
                    item.getMembers(),mInflater,context,id_sem);
                holder.ChildRecyclerView.setLayoutManager(layoutManager);
                holder.ChildRecyclerView.setAdapter(childItemAdapter);
                holder.ChildRecyclerView.setRecycledViewPool(viewPool);

                String titulo_str = item.getSem_nombre();
                String output = titulo_str.substring(0, 1).toUpperCase() + titulo_str.substring(1);
                titulo.setText(output);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                SeedbedsService service = retrofit.create(SeedbedsService.class);
                Call<List<seedbedFacultad>> call = service.SeedbedLider(item.getSem_id());
                call.enqueue(new Callback<List<seedbedFacultad>>() {
                    @Override
                    public void onResponse(Call<List<seedbedFacultad>> call, Response<List<seedbedFacultad>> response) {
                        if(response.isSuccessful()) {
                            Log.e("lista", response.body().toString());
                            List<seedbedFacultad> seedbedsList = response.body();
                            for (int i = 0; i < seedbedsList.size(); i++) {
                                String nombre_liderrr = seedbedsList.get(i).getSem_lider().get(i).getUsuaNombre().toString();
                                nombre_lider.setText(nombre_liderrr);
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<List<seedbedFacultad>> call, Throwable t) {
                        Log.e("negacion", "no funcionooooo");
                    }

                });
                descripcion.setText(item.getSem_descripcion());
                SharedPreferences pref = context.getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("id_semi", item.getSem_id());
                editor.commit();
            }
        }
    }
}
