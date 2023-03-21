package com.example.semillerouniautonoma.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Adapters.listAdapterQuestions;
import com.example.semillerouniautonoma.model.Clases.Questions;
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
 * Use the {@link PreguntasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreguntasFragment extends Fragment {
    RecyclerView listpreguntas;
    ShimmerFrameLayout shimmerFrameLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PreguntasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AyudaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreguntasFragment newInstance(String param1, String param2) {
        PreguntasFragment fragment = new PreguntasFragment();
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
        View v = inflater.inflate(R.layout.fragment_preguntas, container, false);
        shimmerFrameLayout = v.findViewById(R.id.preview);
        referenciar();
        listpreguntas = v.findViewById(R.id.listpreguntas);
        return v;
    }

    public void referenciar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuestionsService service = retrofit.create(QuestionsService.class);
        Call<List<Questions>> call = service.questionsAll();
        call.enqueue(new Callback<List<Questions>>() {
            @Override
            public void onResponse(Call<List<Questions>> call, Response<List<Questions>> response) {
                Log.e("lista", response.body().toString());
                List<Questions> QuestionsList = response.body();
                listAdapterQuestions listAdapter = new listAdapterQuestions(QuestionsList, getActivity());
                listpreguntas.setHasFixedSize(true);
                listpreguntas.setLayoutManager(new LinearLayoutManager(getActivity()));
                listpreguntas.setAdapter(listAdapter);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Questions>> call, Throwable t) {
                Log.e("lista", t.toString());
            }
        });
    }
}