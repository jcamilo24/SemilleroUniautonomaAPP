package com.example.semillerouniautonoma.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.semillerouniautonoma.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class InformacionFragment extends Fragment {
    final String TAG = getClass().getSimpleName();
    TextView informaciongeneral;
    FirebaseFirestore db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_informacion, container, false);
        informaciongeneral = v.findViewById(R.id.informaciongeneral);
        db=FirebaseFirestore.getInstance();
        obtenerDatos1();
        return v;
    }

    public void obtenerDatos1(){
        db.collection("hero_section").document("Rxr4fTXZ6l9rLQlfYSXL").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());
                    String info = documentSnapshot.getString("her_descripcion");
                    if(informaciongeneral!= null){
                        informaciongeneral.setText(info);
                    }
                }
            }
        });
    }

}