package com.example.semillerouniautonoma.model.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.Products;
import com.example.semillerouniautonoma.view.inicio_logueados_estudiantes.Detalle_productos_Activity;
import com.example.semillerouniautonoma.view.publicaciones.Detalle_publicaciones_Activity;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class listAdapterProducts extends RecyclerView.Adapter<listAdapterProducts.ViewHolder> {
    private List<Products> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String id;

    public listAdapterProducts(List<Products> itemList, Context context, String id) {
       try {
           this.mInflater = LayoutInflater.from(context);
           this.context = context;
           this.mData = itemList;
           this.id = id;
       }catch(Exception e){}
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterProducts.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listproducts, null);
        return new listAdapterProducts.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterProducts.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
        holder.setOnClickListeners();
    }

    public void setItems(List<Products> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView texttituloproduct,fecha_registro_producto,descripcionproduct;
        Button info_detalle_product;
        CardView expand;
        LinearLayout layout;
        Context context;
        Date textFECHA1;
        String fecha1;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            texttituloproduct = itemView.findViewById(R.id.texttituloproduct);
            fecha_registro_producto = itemView.findViewById(R.id.fecha_registro_producto);
            descripcionproduct = itemView.findViewById(R.id.descripcionproduct);
            //info_detalle_product = itemView.findViewById(R.id.info_detalle_product);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            //info_detalle_product.setOnClickListener(this);
            texttituloproduct.setOnClickListener(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                /*case R.id.info_detalle_product:
                    Intent intent = new Intent(context, Detalle_productos_Activity.class);
                    intent.putExtra("text", texttituloproduct.getText());
                    intent.putExtra("textfecha", fecha_registro_producto.getText());
                    intent.putExtra("detalle",descripcionproduct.getText());
                    context.startActivity(intent);
                    break;*/
                case R.id.texttituloproduct:
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
            }
        }

        @SuppressLint("RestrictedApi")
        void bindData(final Products item) {
            if (item.getSem_id().equals(id)){
                texttituloproduct.setText(item.getProd_nombre());
                textFECHA1 = item.getProd_fecha_registro();
                fecha1 = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA1);
                String fecha = fecha1;
                String output = fecha.substring(0, 1).toUpperCase() + fecha.substring(1);
                fecha_registro_producto.setText(output);
                descripcionproduct.setText(item.getProd_descripcion());
            }
        }
    }
}
