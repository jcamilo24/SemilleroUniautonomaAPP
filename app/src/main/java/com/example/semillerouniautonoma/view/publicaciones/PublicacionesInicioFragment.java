package com.example.semillerouniautonoma.view.publicaciones;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterLastNews;
import com.example.semillerouniautonoma.model.Adapters.listAdapterProjects;
import com.example.semillerouniautonoma.model.Clases.LastNews;
import com.example.semillerouniautonoma.model.Clases.Projects;
import com.example.semillerouniautonoma.model.Clases.Users;
import com.example.semillerouniautonoma.model.Interfaces.LastNewsService;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PublicacionesInicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PublicacionesInicioFragment extends Fragment{
    CardView expand;
    LinearLayout layout;
    RecyclerView listpublicacionesEducacion;
    ShimmerFrameLayout shimmerFrameLayout;
    List<LastNews> LastnewsList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PublicacionesInicioFragment() {
        // Required empty public constructor
    }
    @Override
    public void onResume() {
        super.onResume();
        if(LastnewsList != null){
            CargarAdapter(LastnewsList);
        }
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PublicacionEducacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PublicacionesInicioFragment newInstance(String param1, String param2) {
        PublicacionesInicioFragment fragment = new PublicacionesInicioFragment();
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
        View v = inflater.inflate(R.layout.fragment_publicacion_inicio, container, false);
        View v2 = inflater.inflate(R.layout.listnews, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        referenciar();
        listpublicacionesEducacion = v.findViewById(R.id.listpublicacionesEducacion);
        expand = v2.findViewById(R.id.expand);
        layout = v2.findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        return v;
    }

    public void referenciar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LastNewsService service = retrofit.create(LastNewsService.class);
        Call<List<LastNews>> call = service.Lastnews();
        call.enqueue(new Callback<List<LastNews>>() {
            @Override
            public void onResponse(Call<List<LastNews>> call, Response<List<LastNews>> response) {
                if(response.isSuccessful()) {
                    Log.e("lista", response.body().toString());
                    LastnewsList = response.body();
                    CargarAdapter(LastnewsList);
                }
            }

            @Override
            public void onFailure(Call<List<LastNews>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
    public void CargarAdapter(List<LastNews> LastnewsList){
        listAdapterLastNews listAdapter = new listAdapterLastNews(LastnewsList, getActivity());
        listpublicacionesEducacion.setHasFixedSize(true);
        listpublicacionesEducacion.setLayoutManager(new LinearLayoutManager(getActivity()));
        listpublicacionesEducacion.setAdapter(listAdapter);
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
    }
}
