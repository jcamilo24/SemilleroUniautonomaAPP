package com.example.semillerouniautonoma.view.inicio_logueados_docentes;

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
import android.widget.LinearLayout;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterSolicitudes;
import com.example.semillerouniautonoma.model.Clases.Solicitudes;
import com.example.semillerouniautonoma.model.Interfaces.SeedbedsService;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link solicitudes_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class solicitudes_Fragment extends Fragment {
    CardView expand;
    LinearLayout layout;
    RecyclerView listSolicitudes;
    ShimmerFrameLayout shimmerFrameLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public solicitudes_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contacto_miembrosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static solicitudes_Fragment newInstance(String param1, String param2) {
        solicitudes_Fragment fragment = new solicitudes_Fragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_solicitudes, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        listSolicitudes = v.findViewById(R.id.listSolicitudes);

        String id_semillero = "";
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
        id_semillero = sharedPreferences.getString("id_semi_docente","");
        Log.e("id_semillero_solicitudes",id_semillero);
        String finalId_semillero = id_semillero;

        referenciar(finalId_semillero);
        return v;
    }

    public void referenciar(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SeedbedsService service = retrofit.create(SeedbedsService.class);
        Call<List<Solicitudes>> call = service.SolicitudesAll(id);
        call.enqueue(new Callback<List<Solicitudes>>() {
            @Override
            public void onResponse(Call<List<Solicitudes>> call, Response<List<Solicitudes>> response) {
                Log.e("lista", response.body().toString());
                List<Solicitudes> SolicitudesList = response.body();
                listAdapterSolicitudes listAdapter = new listAdapterSolicitudes(SolicitudesList, getActivity(), id);
                listSolicitudes.setHasFixedSize(true);
                listSolicitudes.setLayoutManager(new LinearLayoutManager(getActivity()));
                listSolicitudes.setAdapter(listAdapter);

                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Solicitudes>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
}