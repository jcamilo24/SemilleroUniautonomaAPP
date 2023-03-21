package com.example.semillerouniautonoma.model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.SeedbedMembers;
import com.example.semillerouniautonoma.view.inicio_logueados_docentes.contacto_estudents_Activity;
import com.example.semillerouniautonoma.view.inicio_logueados_estudiantes.contacto_miembros_Activity;

import java.util.List;

public class listAdapterSeedbedsEstudents extends RecyclerView.Adapter<listAdapterSeedbedsEstudents.childViewHolder> {
    private List<SeedbedMembers> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String id_sem;

    public listAdapterSeedbedsEstudents(List<SeedbedMembers> itemList, LayoutInflater mInflater, Context context, String id_sem) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.id_sem = id_sem;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterSeedbedsEstudents.childViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listmembers,null);
        return new listAdapterSeedbedsEstudents.childViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterSeedbedsEstudents.childViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
        holder.setOnClickListeners();
    }

    public void setItems(List<SeedbedMembers> items) {
        mData = items;
    }

    public class childViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nombre_miembro;
        Context context;
        ImageView contact_miembros;
        String correo;

        childViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            nombre_miembro = itemView.findViewById(R.id.nombre_miembro);
            contact_miembros = itemView.findViewById(R.id.image_contacto_miembro);
        }

        void setOnClickListeners(){
            contact_miembros.setOnClickListener((View.OnClickListener) this);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.image_contacto_miembro:
                    Intent intent = new Intent(context, contacto_estudents_Activity.class);
                    intent.putExtra("correo_miembro", correo);
                    context.startActivity(intent);
                    break;
            }
        }

        void bindData(final SeedbedMembers item) {
            if (item.getSem_id().equals(id_sem)) {
                String titulo_str = item.getUsu_nombres();
                String output = titulo_str.substring(0, 1).toUpperCase() + titulo_str.substring(1);
                nombre_miembro.setText(output);
                correo = item.getUsu_correo();
            }
        }
    }
}