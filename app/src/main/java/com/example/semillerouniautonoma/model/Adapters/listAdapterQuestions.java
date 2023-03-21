package com.example.semillerouniautonoma.model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.LastNews;
import com.example.semillerouniautonoma.model.Clases.Questions;
import com.example.semillerouniautonoma.view.publicaciones.Detalle_publicaciones_Activity;

import java.util.List;

public class listAdapterQuestions extends RecyclerView.Adapter<listAdapterQuestions.ViewHolder> {
    private List<Questions> mData;
    private LayoutInflater mInflater;
    private Context context;

    public listAdapterQuestions(List<Questions> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterQuestions.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listquestions, null);
        return new listAdapterQuestions.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterQuestions.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
        holder.setOnClickListeners();
    }

    public void setItems(List<Questions> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titulo_pregunta,respuesta,categoria;
        CardView expand;
        LinearLayout layout;

        Context context;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            titulo_pregunta = itemView.findViewById(R.id.titulo_pregunta);
            respuesta = itemView.findViewById(R.id.respuesta);
            categoria = itemView.findViewById(R.id.categoria);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            titulo_pregunta.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.titulo_pregunta:
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
            }
        }

        void bindData(final Questions item) {
            titulo_pregunta.setText(item.getPre_pregunta());
            respuesta.setText(item.getPre_respuesta());
            categoria.setText(item.getPre_categoria());
        }
    }
}
