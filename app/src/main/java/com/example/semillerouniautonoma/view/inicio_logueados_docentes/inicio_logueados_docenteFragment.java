package com.example.semillerouniautonoma.view.inicio_logueados_docentes;

import android.animation.LayoutTransition;
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
import com.example.semillerouniautonoma.model.Adapters.listAdapterSeedbedsByuserdocente;
import com.example.semillerouniautonoma.model.Clases.SeedbedMembers;
import com.example.semillerouniautonoma.model.Clases.SeedbedsByuser;
import com.example.semillerouniautonoma.model.Interfaces.SeedbedsService;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link inicio_logueados_docenteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class inicio_logueados_docenteFragment extends Fragment {
    CardView expand;
    LinearLayout layout;
    RecyclerView listSeedbedsbyUserdocente,listmiembros_semillero;
    ShimmerFrameLayout shimmerFrameLayout;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public inicio_logueados_docenteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment inicio_logueados_docenteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static inicio_logueados_docenteFragment newInstance(String param1, String param2) {
        inicio_logueados_docenteFragment fragment = new inicio_logueados_docenteFragment();
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
        View v = inflater.inflate(R.layout.fragment_inicio_logueados_docente, container, false);
        View v2 = inflater.inflate(R.layout.listseedbedbyuserdocente, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        String correo_usu="";
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
        correo_usu = sharedPreferences.getString("correo_firebase","");
        Log.e("correo_traido",correo_usu);
        referenciar(correo_usu);
        listSeedbedsbyUserdocente = v.findViewById(R.id.listSeedbedsbyUserdocente);
        listmiembros_semillero = v2.findViewById(R.id.listmiembros_semillero);
        expand = v2.findViewById(R.id.expand);
        layout = v2.findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        return v;
    }


    public void referenciar(String correo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SeedbedsService service = retrofit.create(SeedbedsService.class);
        Call<List<SeedbedsByuser>> call = service.SeedbedUser(correo);
        call.enqueue(new Callback<List<SeedbedsByuser>>() {
            @Override
            public void onResponse(Call<List<SeedbedsByuser>> call, Response<List<SeedbedsByuser>> response) {
                if (response.isSuccessful()) {
                    Log.e("lista", response.body().toString());
                    List<SeedbedsByuser> seedbedsByuserList = response.body();
                    String id_semillero = "";

                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
                    id_semillero = sharedPreferences.getString("codigoIniciado","");
                    Log.e("id_semillero_docente",id_semillero);
                    String finalId_semillero = id_semillero;

                    SeedbedsService service = retrofit.create(SeedbedsService.class);
                    Call<List<SeedbedMembers>> call2 = service.seedbedmembers(id_semillero);
                    call2.enqueue(new Callback<List<SeedbedMembers>>() {
                        @Override
                        public void onResponse(Call<List<SeedbedMembers>> call, Response<List<SeedbedMembers>> response) {
                            if (response.isSuccessful()) {
                                Log.e("lista", response.body().toString());
                                List<SeedbedMembers> seedbedsMembersList = response.body();
                                for (int i = 0; i < seedbedsByuserList.size(); i++) {
                                    seedbedsByuserList.get(i).setMembers(seedbedsMembersList);
                                }
                                listAdapterSeedbedsByuserdocente listAdapter = new listAdapterSeedbedsByuserdocente(seedbedsByuserList, getActivity(), correo, finalId_semillero);
                                listSeedbedsbyUserdocente.setHasFixedSize(true);
                                listSeedbedsbyUserdocente.setLayoutManager(new LinearLayoutManager(getActivity()));
                                listSeedbedsbyUserdocente.setAdapter(listAdapter);
                                shimmerFrameLayout.stopShimmer();
                                shimmerFrameLayout.setVisibility(View.GONE);
                            }
                        }
                        @Override
                        public void onFailure(Call<List<SeedbedMembers>> call, Throwable t) {
                            Log.e("lista", t.toString());
                        }
                    });
                  }
                }

                @Override
                public void onFailure (Call < List < SeedbedsByuser >> call, Throwable t){
                    Log.e("lista", t.toString());
                }
        });
    }
}