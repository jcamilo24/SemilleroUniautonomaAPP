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

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterProducts;
import com.example.semillerouniautonoma.model.Adapters.listAdapterProjects;
import com.example.semillerouniautonoma.model.Clases.Products;
import com.example.semillerouniautonoma.model.Clases.Projects;
import com.example.semillerouniautonoma.model.Interfaces.ProductService;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Productos_EstuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Productos_EstuFragment extends Fragment {
    Button boton1;
    CardView expand;
    LinearLayout layout;
    RecyclerView listproductos;
    ShimmerFrameLayout shimmerFrameLayout;
    List<Products> ProductsList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Productos_EstuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment proyectos_novedososFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Productos_EstuFragment newInstance(String param1, String param2) {
        Productos_EstuFragment fragment = new Productos_EstuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onResume() {
        super.onResume();
        if(ProductsList  != null){
            String id_semillero="";
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
            id_semillero = sharedPreferences.getString("id_semi","");
            CargarAdapter(ProductsList , id_semillero);
        }
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
        View v = inflater.inflate(R.layout.fragment_estu_productos, container, false);
        View v2 = inflater.inflate(R.layout.listproducts, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        String id_semillero = "";
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
        id_semillero = sharedPreferences.getString("id_semi","");
        Log.e("id_semillero_para_productos",id_semillero);
        referenciar(id_semillero);
        listproductos = v.findViewById(R.id.listproductos);
        expand = v2.findViewById(R.id.expand);
        layout = v2.findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        return v;
    }

    public void referenciar(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductService service = retrofit.create(ProductService.class);
        Call<List<Products>> call = service.Products(id);
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if(response.isSuccessful()) {
                    Log.e("lista", response.body().toString());
                    ProductsList = response.body();
                    CargarAdapter(ProductsList, id);
                }
            }
            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
    public void CargarAdapter(List<Products> ProjectsList, String id){
        listAdapterProducts listAdapter = new listAdapterProducts(ProductsList, getActivity(), id);
        listproductos.setHasFixedSize(true);
        listproductos.setLayoutManager(new LinearLayoutManager(getActivity()));
        listproductos.setAdapter(listAdapter);
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
    }
}