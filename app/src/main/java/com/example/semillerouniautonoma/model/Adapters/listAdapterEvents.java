package com.example.semillerouniautonoma.model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.Events;
import com.example.semillerouniautonoma.model.Clases.Questions;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class listAdapterEvents extends RecyclerView.Adapter<listAdapterEvents.ViewHolder> {
    private List<Events> mData;
    private LayoutInflater mInflater;
    private Context context;

    public listAdapterEvents(List<Events> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterEvents.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listevents, null);
        return new listAdapterEvents.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterEvents.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
        holder.setOnClickListeners();
    }

    public void setItems(List<Events> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView texttituloevento,fecha_inicio_evento,fecha_fin_evento,descripcionevento;
        Button link_eventosss;
        String link_evento;
        CardView expand;
        LinearLayout layout;
        Context context;
        String fecha1,fecha2;
        Date textFECHA1,textFECHA2;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            texttituloevento = itemView.findViewById(R.id.texttituloevento);
            fecha_inicio_evento = itemView.findViewById(R.id.fecha_inicio_evento);
            fecha_fin_evento = itemView.findViewById(R.id.fecha_fin_evento);
            descripcionevento = itemView.findViewById(R.id.descripcionevento);
            link_eventosss = itemView.findViewById(R.id.link_evento);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            texttituloevento.setOnClickListener(this);
            link_eventosss.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.texttituloevento:
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
                    break;
                case R.id.link_evento:
                    Uri _link = Uri.parse(link_evento);
                    Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                    context.startActivity(intent);
                    break;
            }
        }

        void bindData(final Events item) {
            texttituloevento.setText(item.getEve_nombre());
            textFECHA1 = item.getEve_fecha_inicio();
            fecha1 = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA1);
            String fecha = fecha1;
            String output = fecha.substring(0, 1).toUpperCase() + fecha.substring(1);
            fecha_inicio_evento.setText(output);
            textFECHA2 = item.getEve_fecha_fin();
            fecha2 = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA2);
            String fechaa = fecha2;
            String output2 = fechaa.substring(0, 1).toUpperCase() + fechaa.substring(1);
            fecha_fin_evento.setText(output2);
            descripcionevento.setText(item.getEve_descripcion());
            link_evento = item.getEve_url();
        }
    }
}