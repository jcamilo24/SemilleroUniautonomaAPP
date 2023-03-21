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
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.seedbedFacultad;
import com.example.semillerouniautonoma.view.semilleros.Detalle_semillero_Activity;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class listAdapterAdministracion extends RecyclerView.Adapter<listAdapterAdministracion.ViewHolder> {
    private List<seedbedFacultad> mData;
    private LayoutInflater mInflater;
    private Context context;

    public listAdapterAdministracion(List<seedbedFacultad> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterAdministracion.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listseedbeds, null);
        return new listAdapterAdministracion.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterAdministracion.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
        holder.setOnClickListeners();
    }

    public void setItems(List<seedbedFacultad> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView text,textfecha,descripcion,rol_lider,nombre_lider;
        Button info;
        CardView expand;
        LinearLayout layout;
        Context context;
        String rol,nombre,correo_usu,codigo_semillero;
        Date textFECHA;
        String fechaaaa;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            text = itemView.findViewById(R.id.text);
            textfecha = itemView.findViewById(R.id.textfecha);
            descripcion = itemView.findViewById(R.id.descripcioncard);
            rol_lider = itemView.findViewById(R.id.rol_Lider);
            nombre_lider = itemView.findViewById(R.id.nombre_Lider);
            info = itemView.findViewById(R.id.info);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            info.setOnClickListener(this);
            text.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.info:
                    Intent intent = new Intent(context, Detalle_semillero_Activity.class);
                    intent.putExtra("text", text.getText());
                    intent.putExtra("textfecha", textfecha.getText());
                    intent.putExtra("descripcion", descripcion.getText());
                    intent.putExtra("rol",rol);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("correo",correo_usu);
                    intent.putExtra("codigo_sem", codigo_semillero);
                    context.startActivity(intent);
                    break;
                case R.id.text:
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
                    break;
            }
        }

        void bindData(final seedbedFacultad item) {
            text.setText(item.getSem_nombre());
            textFECHA = item.getSem_fecha_inicio();
            fechaaaa = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA);
            String fecha = fechaaaa;
            String output = fecha.substring(0, 1).toUpperCase() + fecha.substring(1);
            textfecha.setText(output);
            descripcion.setText(item.getSem_descripcion());
            for (int i=0; i < item.getSem_lider().size(); i++)
            {
                nombre = nombre + item.getSem_lider().get(i).getUsuaNombre().toString();
                correo_usu = correo_usu + item.getSem_lider().get(i).getUsuaCorreo().toString();
            }
            codigo_semillero = item.getSem_id();
        }
    }
}
