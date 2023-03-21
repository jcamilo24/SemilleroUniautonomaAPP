package com.example.semillerouniautonoma.model.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.Annexes;
import com.example.semillerouniautonoma.model.Clases.ProductByProject;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class listAdapterproductByProject extends RecyclerView.Adapter<listAdapterproductByProject.ViewHolder> {
    private List<ProductByProject> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String id;

    public listAdapterproductByProject(List<ProductByProject> itemList, Context context, String id) {
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
    public listAdapterproductByProject.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listproductbyproject, null);
        return new listAdapterproductByProject.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterproductByProject.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));

        holder.setOnClickListeners();
    }

    public void setItems(List<ProductByProject> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titulo,fecha,descripcion;
        CardView expand;
        LinearLayout layout;
        String fecha1;
        Date textFECHA1;

        Context context;

        ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            titulo = itemView.findViewById(R.id.nombre_product);
            fecha = itemView.findViewById(R.id.fecha_regi_product);
            descripcion = itemView.findViewById(R.id.descripcion_product);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            titulo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.nombre_product:
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
                    break;
            }
        }

        @SuppressLint("LongLogTag")
        void bindData(final ProductByProject item) {
            if (item.getProy_id().equals(id)){
                Log.e("mensaje producto por id_project", id);
                String tipo_str = item.getProd_nombre();
                String output = tipo_str.substring(0, 1).toUpperCase() + tipo_str.substring(1);
                titulo.setText(output);
                textFECHA1 = item.getProd_fecha_registro();
                fecha1 = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA1);
                fecha.setText(fecha1);
                descripcion.setText(item.getProd_descripcion());
            }
        }
    }
}
