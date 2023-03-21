package com.example.semillerouniautonoma.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterQuestions;
import com.example.semillerouniautonoma.model.Clases.Questions;
import com.example.semillerouniautonoma.model.Interfaces.QuestionsService;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NormatividadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NormatividadFragment extends Fragment {
    TextView titulo_norma,fecha_norma,descrip_norma,url_norma,titulo_norma2,fecha_norma2,descrip_norma2,url_norma2;
    CardView expand,expand2;
    LinearLayout layout,layout2;
    FirebaseFirestore db;
    final String TAG = getClass().getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NormatividadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NormatividadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NormatividadFragment newInstance(String param1, String param2) {
        NormatividadFragment fragment = new NormatividadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_normatividad, container, false);
        expand = v.findViewById(R.id.expand);
        layout = v.findViewById(R.id.layout);
        titulo_norma = v.findViewById(R.id.titulo_norma);
        titulo_norma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v2 = (expand.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                expand.setVisibility(v2);
            }
        });
        expand2 = v.findViewById(R.id.expand2);
        layout2 = v.findViewById(R.id.layout2);
        titulo_norma2 = v.findViewById(R.id.titulo_norma2);
        titulo_norma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v2 = (expand2.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

                TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
                expand2.setVisibility(v2);
            }
        });
        fecha_norma = v.findViewById(R.id.fecha_norma);
        descrip_norma = v.findViewById(R.id.descrip_norma);
        url_norma = v.findViewById(R.id.url_norma);
        fecha_norma2 = v.findViewById(R.id.fecha_norma2);
        descrip_norma2 = v.findViewById(R.id.descrip_norma2);
        url_norma2 = v.findViewById(R.id.url_norma2);
        db= FirebaseFirestore.getInstance();
        obtenerDatos1();
        obtenerDatos2();

        return v;
    }
    public void obtenerDatos1(){
        db.collection("normatividad").document("io9EBW50CfccjvwHD0S0").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());
                    String titu = documentSnapshot.getString("nor_titulo");
                    if(titu!= null){
                        titulo_norma.setText(titu);
                    }
                    String fechaaa = documentSnapshot.getString("nor_fecha_registro");
                    if(fechaaa!= null){
                        fecha_norma.setText(fechaaa);
                    }
                    String descripcion_norma = documentSnapshot.getString("nor_descripcion");
                    if(descripcion_norma!= null){
                        descrip_norma.setText(descripcion_norma);
                    }
                    String url_norm = documentSnapshot.getString("nor_url");
                    if (url_norm!= null){
                        //url_norma.setText(url_norm);
                        url_norma.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String links = url_norm;
                                openlink(links);
                            }
                        });
                    }
                }
            }
        });
    }
    public void obtenerDatos2(){
        db.collection("normatividad").document("EaPlTtGAYVnDPtTzNrew").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());
                    String titu2 = documentSnapshot.getString("nor_titulo");
                    if(titu2!= null){
                        titulo_norma2.setText(titu2);
                    }
                    String fechaaa2 = documentSnapshot.getString("nor_fecha_registro");
                    if(fechaaa2!= null){
                        fecha_norma2.setText(fechaaa2);
                    }
                    String descripcion_norma2 = documentSnapshot.getString("nor_descripcion");
                    if(descripcion_norma2!= null){
                        descrip_norma2.setText(descripcion_norma2);
                    }
                    String url_norm2 = documentSnapshot.getString("nor_url");
                    if (url_norm2!= null){
                        //url_norma2.setText(url_norm2);
                        url_norma2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String links = url_norm2;
                                openlink(links);
                            }
                        });
                    }
                }
            }
        });
    }
    private void openlink(String links) {
        Uri uri = Uri.parse(links);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}