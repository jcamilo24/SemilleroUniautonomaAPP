package com.example.semillerouniautonoma.view.inicio_logueados_estudiantes;

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
import com.example.semillerouniautonoma.model.Adapters.listAdapterEvents;
import com.example.semillerouniautonoma.model.Adapters.listAdapterQuestions;
import com.example.semillerouniautonoma.model.Clases.Events;
import com.example.semillerouniautonoma.model.Clases.Questions;
import com.example.semillerouniautonoma.model.Interfaces.EventsService;
import com.example.semillerouniautonoma.model.Interfaces.QuestionsService;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link eventosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class eventosFragment extends Fragment {
    CardView expand;
    LinearLayout layout;
    RecyclerView listEvents;
    ShimmerFrameLayout shimmerFrameLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public eventosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment eventosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static eventosFragment newInstance(String param1, String param2) {
        eventosFragment fragment = new eventosFragment();
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
        View v = inflater.inflate(R.layout.fragment_eventos, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        referenciar();
        listEvents = v.findViewById(R.id.listEvents);
        return v;
    }


    public void referenciar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EventsService service = retrofit.create(EventsService.class);
        Call<List<Events>> call = service.EventsAll();
        call.enqueue(new Callback<List<Events>>() {
            @Override
            public void onResponse(Call<List<Events>> call, Response<List<Events>> response) {
                Log.e("lista", response.body().toString());
                List<Events> EventsList = response.body();
                listAdapterEvents listAdapter = new listAdapterEvents(EventsList, getActivity());
                listEvents.setHasFixedSize(true);
                listEvents.setLayoutManager(new LinearLayoutManager(getActivity()));
                listEvents.setAdapter(listAdapter);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Events>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
}