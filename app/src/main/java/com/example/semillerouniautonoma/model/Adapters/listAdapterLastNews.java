package com.example.semillerouniautonoma.model.Adapters;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.example.semillerouniautonoma.model.Clases.seedbedFacultad;
import com.example.semillerouniautonoma.view.publicaciones.Detalle_publicaciones_Activity;
import com.example.semillerouniautonoma.view.semilleros.Detalle_semillero_Activity;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class listAdapterLastNews extends RecyclerView.Adapter<listAdapterLastNews.ViewHolder> {
    private List<LastNews> mData;
    private LayoutInflater mInflater;
    private Context context;

    public listAdapterLastNews(List<LastNews> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterLastNews.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listnews, null);
        return new listAdapterLastNews.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterLastNews.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
        holder.setOnClickListeners();
    }

    public void setItems(List<LastNews> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView texttitulopubli,textfechapubli,descripcionpubli;
        ImageView image1news;
        String imagen_a_detalle;
        Button infopubli;
        CardView expand;
        LinearLayout layout;
        Context context;
        String detalledecrip;
        Date textFECHA;
        String fechaaaa;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            texttitulopubli = itemView.findViewById(R.id.texttitulopubli);
            textfechapubli = itemView.findViewById(R.id.textfechapubli);
            descripcionpubli = itemView.findViewById(R.id.descripcionpubli);
            image1news = itemView.findViewById(R.id.imagenews);
            infopubli = itemView.findViewById(R.id.infopubli);
            expand = itemView.findViewById(R.id.expand);
            layout = itemView.findViewById(R.id.layout);
        }

        void setOnClickListeners(){
            infopubli.setOnClickListener(this);
            texttitulopubli.setOnClickListener(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.infopubli:
                    Intent intent = new Intent(context, Detalle_publicaciones_Activity.class);
                    intent.putExtra("text", texttitulopubli.getText());
                    intent.putExtra("textfecha", textfechapubli.getText());
                    intent.putExtra("detalle",detalledecrip);
                    intent.putExtra("imagen", imagen_a_detalle);
                    context.startActivity(intent);
                    break;
                case R.id.texttitulopubli:
                    int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expand.setVisibility(v2);
            }
        }

        @SuppressLint("RestrictedApi")
        void bindData(final LastNews item) {
            texttitulopubli.setText(item.getNot_titulo());
            Glide.with(context).load(item.getNot_imagen()).centerCrop().into(image1news);
            imagen_a_detalle = item.getNot_imagen();
            textFECHA = item.getNot_fecha_publicacion();
            fechaaaa = DateFormat.getDateInstance(DateFormat.FULL).format(textFECHA);
            String fecha = fechaaaa;
            String output = fecha.substring(0, 1).toUpperCase() + fecha.substring(1);
            textfechapubli.setText(output);
            descripcionpubli.setText(item.getNot_resumen());
            detalledecrip = item.getNot_descripcion();
        }
    }
}
