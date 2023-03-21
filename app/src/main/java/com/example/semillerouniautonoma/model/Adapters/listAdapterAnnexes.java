package com.example.semillerouniautonoma.model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.Annexes;
import com.example.semillerouniautonoma.model.Clases.seedbedFacultad;
import com.example.semillerouniautonoma.view.semilleros.Detalle_semillero_Activity;

import java.util.List;

public class listAdapterAnnexes extends RecyclerView.Adapter<listAdapterAnnexes.ViewHolder> {
    private List<Annexes> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String id;

    public listAdapterAnnexes(List<Annexes> itemList, Context context, String id) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.id = id;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterAnnexes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listannexes, null);
        return new listAdapterAnnexes.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterAnnexes.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));

        holder.setOnClickListeners();
    }

    public void setItems(List<Annexes> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tipo,descripcion;
        CardView expand;
        LinearLayout layout;

        Context context;

        ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            tipo = itemView.findViewById(R.id.tipo);
            descripcion = itemView.findViewById(R.id.descripcion);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            tipo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tipo:
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
                    break;
            }
        }

        void bindData(final Annexes item) {
                if (item.getAne_sem_id().equals(id)){
                    Log.e("mensaje anexo", id);
                    String tipo_str = item.getAne_tipo();
                    String output = tipo_str.substring(0, 1).toUpperCase() + tipo_str.substring(1);
                    tipo.setText(output);
                    descripcion.setText(item.getAne_descripcion());
                }
        }
    }
}
