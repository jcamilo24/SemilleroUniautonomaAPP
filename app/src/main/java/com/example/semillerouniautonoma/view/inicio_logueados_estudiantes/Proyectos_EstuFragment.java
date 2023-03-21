package com.example.semillerouniautonoma.view.inicio_logueados_estudiantes;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterProjects;
import com.example.semillerouniautonoma.model.Clases.Projects;
import com.example.semillerouniautonoma.model.Interfaces.ProjectService;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Proyectos_EstuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Proyectos_EstuFragment extends Fragment {
    Button boton1;
    CardView expand;
    LinearLayout layout;
    RecyclerView listproyectos;
    ShimmerFrameLayout shimmerFrameLayout;;
    List<Projects> ProjectsList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Proyectos_EstuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nuevo_proyectoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Proyectos_EstuFragment newInstance(String param1, String param2) {
        Proyectos_EstuFragment fragment = new Proyectos_EstuFragment();
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

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_estu_proyectos, container, false);
        View v2 = inflater.inflate(R.layout.listprojects, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        String id_semillero="";
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
        id_semillero = sharedPreferences.getString("id_semi","");
        Log.e("id_semillero_para_proyectos",id_semillero);
        referenciar(id_semillero);
        listproyectos = v.findViewById(R.id.listproyectos);
        boton1 = v2.findViewById(R.id.info_detalle_project);
        expand = v2.findViewById(R.id.expand);
        layout = v2.findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        return v;
    }
    @Override
    public void onResume() {
        super.onResume();
        if(ProjectsList != null){
            String id_semillero="";
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
            id_semillero = sharedPreferences.getString("id_semi","");
            CargarAdapter(ProjectsList, id_semillero);
        }
     }
    public void referenciar(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProjectService service = retrofit.create(ProjectService.class);
        Call<List<Projects>> call = service.Projects(id);
        call.enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(Call<List<Projects>> call, Response<List<Projects>> response) {
                if(response.isSuccessful()) {
                    Log.e("lista", response.body().toString());
                    ProjectsList = response.body();
                    CargarAdapter(ProjectsList, id);
                }
            }
            @Override
            public void onFailure(Call<List<Projects>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
    public void CargarAdapter(List<Projects> ProjectsList, String id){
        listAdapterProjects listAdapter = new listAdapterProjects(ProjectsList, getActivity(), id, this);
        listproyectos.setHasFixedSize(true);
        listproyectos.setLayoutManager(new LinearLayoutManager(getActivity()));
        listproyectos.setAdapter(listAdapter);
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
    }
}