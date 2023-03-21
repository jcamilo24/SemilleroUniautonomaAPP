package com.example.semillerouniautonoma.model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.SeedbedMembers;
import com.example.semillerouniautonoma.model.Clases.SeedbedsByuser;
import com.example.semillerouniautonoma.view.inicio_logueados_docentes.contacto_grupal_Activity;
import com.example.semillerouniautonoma.view.inicio_logueados_estudiantes.Detalle_proyecto_Activity;

import java.nio.file.SecureDirectoryStream;
import java.util.List;

public class listAdapterSeedbedsByuserdocente extends RecyclerView.Adapter<listAdapterSeedbedsByuserdocente.parentViewHolder> {
    private List<SeedbedsByuser> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String correo;
    private String id_sem;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public listAdapterSeedbedsByuserdocente(List<SeedbedsByuser> itemList, Context context, String correo, String id_sem) {
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
    public listAdapterSeedbedsByuserdocente.parentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listseedbedbyuserdocente, null);
        return new listAdapterSeedbedsByuserdocente.parentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterSeedbedsByuserdocente.parentViewHolder holder, final int position) {
        holder.bindData(mData.get(position), holder);
        holder.setOnClickListeners();
    }

    public void setItems(List<SeedbedsByuser> items) {
        mData = items;
    }

    public class parentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titulo,descripcion;
        CardView expand;
        LinearLayout layout;
        Context context;
        Button mensaje_grupal;
        List<SeedbedMembers> lista_miembros;

        public RecyclerView ChildRecyclerView;

        parentViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            titulo = itemView.findViewById(R.id.titulo_semillero);
            descripcion = itemView.findViewById(R.id.descripcion_semillero);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
            mensaje_grupal = itemView.findViewById(R.id.mensaje_grupal);
            ChildRecyclerView = itemView.findViewById(R.id.listmiembros_semillero);
        }

        void setOnClickListeners() {
            titulo.setOnClickListener(this);
            mensaje_grupal.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.titulo_semillero:
                    int v2 = (expand.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
                    break;
                case R.id.mensaje_grupal:
                    Intent intent = new Intent(context, contacto_grupal_Activity.class);
                    String correos = "";
                    for (int i=0;i<lista_miembros.size();i++){
                        correos = correos + lista_miembros.get(i).getUsu_correo() + ",";
                    }
                    intent.putExtra("lista_miembros_correos", correos);
                    context.startActivity(intent);
                    break;
            }
        }

        void bindData(final SeedbedsByuser item, listAdapterSeedbedsByuserdocente.parentViewHolder holder) {
            if (item.getUsu_correo().equals(correo)) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(holder.ChildRecyclerView
                        .getContext(),LinearLayoutManager.VERTICAL,false);
                layoutManager.setInitialPrefetchItemCount(item.getMembers().size());
                listAdapterSeedbedsEstudents childItemAdapter = new listAdapterSeedbedsEstudents(
                        item.getMembers(),mInflater,context,id_sem);
                holder.ChildRecyclerView.setLayoutManager(layoutManager);
                holder.ChildRecyclerView.setAdapter(childItemAdapter);
                holder.ChildRecyclerView.setRecycledViewPool(viewPool);
                lista_miembros = item.getMembers();
                String titulo_str = item.getSem_nombre();
                String output = titulo_str.substring(0, 1).toUpperCase() + titulo_str.substring(1);
                titulo.setText(output);

                descripcion.setText(item.getSem_descripcion());

                SharedPreferences pref = context.getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("id_semi_docente", item.getSem_id());
                editor.commit();
            }
        }
    }
}
