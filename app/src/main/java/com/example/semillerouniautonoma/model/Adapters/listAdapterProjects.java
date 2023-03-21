package com.example.semillerouniautonoma.model.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.LastNews;
import com.example.semillerouniautonoma.model.Clases.Projects;
import com.example.semillerouniautonoma.view.inicio_logueados_estudiantes.Detalle_proyecto_Activity;
import com.example.semillerouniautonoma.view.inicio_logueados_estudiantes.Proyectos_EstuFragment;
import com.example.semillerouniautonoma.view.publicaciones.Detalle_publicaciones_Activity;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class listAdapterProjects extends RecyclerView.Adapter<listAdapterProjects.ViewHolder> {
    private List<Projects> mData;
    private LayoutInflater mInflater;
    private Context context;
    private String id;
    private Proyectos_EstuFragment fragment;

    public listAdapterProjects(List<Projects> itemList, Context context, String id, Proyectos_EstuFragment fragment) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.id = id;
        this.fragment = fragment;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterProjects.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listprojects, null);
        return new listAdapterProjects.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterProjects.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
        holder.setOnClickListeners();
    }

    public void setItems(List<Projects> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView texttituloproject,fecha_inicio_project,fecha_fin_project,descripcionproject,descripciondetalle;
        ImageView imageproject;
        Button info_detalle_project;
        CardView expand;
        LinearLayout layout;
        Context context;
        String imagen_a_detalle,fecha1,fecha2,estado,id_pro;
        Date textFECHA1,textFECHA2;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            texttituloproject = itemView.findViewById(R.id.texttituloproject);
            fecha_inicio_project = itemView.findViewById(R.id.fecha_inicio_project);
            fecha_fin_project = itemView.findViewById(R.id.fecha_fin_project);
            //imageproject = itemView.findViewById(R.id.imageproject);
            descripcionproject = itemView.findViewById(R.id.descripcionproject);
            info_detalle_project = itemView.findViewById(R.id.info_detalle_project);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            info_detalle_project.setOnClickListener(this);
            texttituloproject.setOnClickListener(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.info_detalle_project:
                    Intent intent = new Intent(context, Detalle_proyecto_Activity.class);
                    intent.putExtra("titulo_pro", texttituloproject.getText());
                    intent.putExtra("fecha_inicio", fecha_inicio_project.getText());
                    intent.putExtra("fecha_fin", fecha_fin_project.getText());
                    intent.putExtra("descripcion_pro",descripcionproject.getText());
                    intent.putExtra("imagen", imagen_a_detalle);
                    intent.putExtra("estado", estado);
                    intent.putExtra("idd", id_pro);
                    context.startActivity(intent);
                    break;

                case R.id.texttituloproject:
                    //notifyDataSetChanged();
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
            }
        }


        @SuppressLint("RestrictedApi")
        void bindData(final Projects item) {
            if (item.getSem_id().equals(id)){
                texttituloproject.setText(item.getProy_nombre());
                //Glide.with(context).load(item.getProy_imagen()).centerCrop().into(imageproject);
                textFECHA1 = item.getProy_fecha_inicio();
                fecha1 = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA1);
                String fecha11 = fecha1;
                String output = fecha11.substring(0, 1).toUpperCase() + fecha11.substring(1);
                fecha_inicio_project.setText(output);
                textFECHA2 = item.getProy_fecha_fin();
                fecha2 = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA2);
                String fecha12 = fecha2;
                String output2 = fecha12.substring(0, 1).toUpperCase() + fecha12.substring(1);
                fecha_fin_project.setText(output2);
                descripcionproject.setText(item.getProy_descripcion());
                imagen_a_detalle = item.getProy_imagen();
                String estado_proj = item.getSem_proy_estado();
                String output3 = estado_proj.substring(0, 1).toUpperCase() + estado_proj.substring(1);
                estado = output3;
                id_pro = item.getProy_id();
                SharedPreferences pref3 = context.getSharedPreferences("Datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor3 = pref3.edit();
                editor3.putString("id_P", item.getProy_id());
                editor3.commit();
            }
        }
    }
}
