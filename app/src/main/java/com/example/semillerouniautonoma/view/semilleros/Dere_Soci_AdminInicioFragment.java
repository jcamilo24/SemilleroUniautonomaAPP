package com.example.semillerouniautonoma.view.semilleros;

import android.animation.LayoutTransition;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterAdministracion;
import com.example.semillerouniautonoma.model.Clases.seedbedFacultad;
import com.example.semillerouniautonoma.model.Interfaces.FacultadesService;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dere_Soci_AdminInicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dere_Soci_AdminInicioFragment extends Fragment {
    ImageView imgAnterior;
    CardView expand;
    LinearLayout layout;
    RecyclerView listsemillerosAdministracion;
    ShimmerFrameLayout shimmerFrameLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Dere_Soci_AdminInicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdministracionInicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Dere_Soci_AdminInicioFragment newInstance(String param1, String param2) {
        Dere_Soci_AdminInicioFragment fragment = new Dere_Soci_AdminInicioFragment();
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
        View v = inflater.inflate(R.layout.fragment_dere_soci_admin_inicio, container, false);
        View v2 = inflater.inflate(R.layout.listseedbeds, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        referenciar();
        listsemillerosAdministracion = v.findViewById(R.id.listsemillerosAdministracion);
        imgAnterior = v.findViewById(R.id.imagen_anterior);
        imgAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.nav_host_fragment_content_main, new IngenieriaInicioFragment()).commit();
                ft.addToBackStack(null);
            }
        });
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
        FacultadesService service = retrofit.create(FacultadesService.class);
        Call<List<seedbedFacultad>> call = service.allseedbedsAdministracion();
        call.enqueue(new Callback<List<seedbedFacultad>>() {
            @Override
            public void onResponse(Call<List<seedbedFacultad>> call, Response<List<seedbedFacultad>> response) {
                Log.e("lista", response.body().toString());
                List<seedbedFacultad> seedbedAdministracionList = response.body();
                listAdapterAdministracion listAdapter = new listAdapterAdministracion(seedbedAdministracionList, getActivity());
                listsemillerosAdministracion.setHasFixedSize(true);
                listsemillerosAdministracion.setLayoutManager(new LinearLayoutManager(getActivity()));
                listsemillerosAdministracion.setAdapter(listAdapter);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<seedbedFacultad>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
}