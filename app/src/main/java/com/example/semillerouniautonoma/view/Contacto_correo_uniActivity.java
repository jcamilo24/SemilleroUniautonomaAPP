package com.example.semillerouniautonoma.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.view.semilleros.Detalle_semillero_Activity;

public class Contacto_correo_uniActivity extends AppCompatActivity {

    EditText correo;
    ImageView imganterior;

    EditText tema,contenido;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_correo_uni);

        String titulo = "";
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            titulo = extras.getString("correo");
        }
        correo = findViewById(R.id.correouniii);
        tema = findViewById(R.id.tema);
        contenido = findViewById(R.id.contenido);
        correo.setText(titulo);

        button = findViewById(R.id.enviar_correo_uniii);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()){
                    String enviarcorreo = correo.getText().toString();
                    String enviarasunto = tema.getText().toString();
                    String enviarmensaje = contenido.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] { enviarcorreo });
                    intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                    intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);
                    startActivity(intent);
                }
            }
        });

        imganterior = findViewById(R.id.imagen_anterior);
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public boolean validar(){
        boolean retorno = true;
        String campo1=correo.getText().toString();
        String campo2=tema.getText().toString();
        String campo3=contenido.getText().toString();
        if (campo1.isEmpty()){
            correo.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo2.isEmpty()){
            tema.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo3.isEmpty()){
            contenido.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        return retorno;
    }
}