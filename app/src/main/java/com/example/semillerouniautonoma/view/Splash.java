package com.example.semillerouniautonoma.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.view.login.AuthActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();
    TextView titulo_splash;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences shared = getSharedPreferences("datos", MODE_PRIVATE);
        String channel = (shared.getString("rol_user", ""));
        String idLogin = (shared.getString("isLogin", ""));
         TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                intent.putExtra("login", false);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 4500);
        titulo_splash = findViewById(R.id.titulo_splash);
        db=FirebaseFirestore.getInstance();
        obtenerDatos1();
    }

    public void obtenerDatos1(){
        db.collection("hero_section").document("Rxr4fTXZ6l9rLQlfYSXL").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());
                    String titulo = documentSnapshot.getString("her_titulo");
                    if(titulo_splash!= null){
                        titulo_splash.setText(titulo);
                    }
                }
            }
        });
    }
}
