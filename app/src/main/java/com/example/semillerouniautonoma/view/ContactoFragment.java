package com.example.semillerouniautonoma.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.semillerouniautonoma.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactoFragment extends Fragment {

    final String TAG = getClass().getSimpleName();
    TextView direccionUNI,correoUNI;
    Button telefonoUNI;
    FirebaseFirestore db;

    ImageView mapsgoogle,iv_facebook,iv_twitter,iv_instagram,iv_youtube;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactoFragment newInstance(String param1, String param2) {
        ContactoFragment fragment = new ContactoFragment();
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
        View v = inflater.inflate(R.layout.fragment_contacto_uni, container, false);
        mapsgoogle = v.findViewById(R.id.mapsgoogle);
        mapsgoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        iv_facebook = v.findViewById(R.id.iv_facebook);
        iv_twitter = v.findViewById(R.id.iv_twitter);
        iv_instagram = v.findViewById(R.id.iv_instagram);
        iv_youtube = v.findViewById(R.id.iv_youtube);
        direccionUNI = v.findViewById(R.id.direccionUNI);
        telefonoUNI = v.findViewById(R.id.TELEFONOUNI);
        correoUNI = v.findViewById(R.id.correoUNI);
        db=FirebaseFirestore.getInstance();
        obtenerDatos1();
        return v;
    }

    public void obtenerDatos1(){
        db.collection("autonoma").document("zfBkoaAUapJeiwcpjZLk").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());
                    String correo = documentSnapshot.getString("aut_correo");
                    if(correoUNI!= null){
                        correoUNI.setText(correo);
                        correoUNI.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String correo = (String) correoUNI.getText();
                                Intent correoUNI = new Intent(getContext(),Contacto_correo_uniActivity.class);
                                correoUNI.putExtra("correo",correo);
                                startActivity(correoUNI);
                            }
                        });
                    }
                    String telefono = documentSnapshot.getString("aut_telefono");
                    if(telefonoUNI!= null){
                        telefonoUNI.setText(telefono);
                        telefonoUNI.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String numero = (String) telefonoUNI.getText();
                                String inicio = "tel:" + numero;
                                Intent llamada = new Intent(Intent.ACTION_CALL);
                                llamada.setData(Uri.parse(inicio));
                                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) !=
                                        PackageManager.PERMISSION_GRANTED){
                                    ActivityCompat.requestPermissions((Activity) getContext(),new String[]{
                                            Manifest.permission.CALL_PHONE}, 255);
                                }else{
                                    startActivity(llamada);
                                }
                            }
                        });
                    }
                    String direccion = documentSnapshot.getString("aut_direccion");
                    if(direccionUNI!= null){
                        direccionUNI.setText(direccion);
                    }
                    String facebook = documentSnapshot.getString("aut_facebook");
                    if (facebook!= null){
                        iv_facebook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String links = facebook;
                                openlink(links);
                            }
                        });
                    }
                    String twitter = documentSnapshot.getString("aut_twitter");
                    if (twitter!= null){
                        iv_twitter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String links = twitter;
                                openlink(links);
                            }
                        });
                    }
                    String instagram = documentSnapshot.getString("aut_instagram");
                    if (instagram!= null){
                        iv_instagram.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String links = instagram;
                                openlink(links);
                            }
                        });
                    }
                    String youtube = documentSnapshot.getString("aut_youtube");
                    if (youtube!= null){
                        iv_youtube.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String links = youtube;
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