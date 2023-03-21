package com.example.semillerouniautonoma.view.inicio_logueados_docentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.SeedbedMembers;
import com.example.semillerouniautonoma.view.inicio_logueados_estudiantes.Inicio_LogueadosFragment;

import java.util.Collections;
import java.util.List;

import javax.mail.Session;

public class contacto_grupal_Activity extends AppCompatActivity {
    EditText direccion,tema,contenido;
    Button button;
    ImageView imganterior;
    TextView titulo_contacto;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_grupal);

        direccion = findViewById(R.id.correo_miembro);
        tema = findViewById(R.id.tema_miembro);
        contenido = findViewById(R.id.contenido_miembro);

        String correo_usu = "";

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            correo_usu = extras.getString("lista_miembros_correos");
        }
        Log.e("lista_miembrossss", correo_usu);
        direccion.setText(correo_usu);

        button = findViewById(R.id.enviar_correo_miembro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()){
                    String enviarcorreo = direccion.getText().toString();
                    String enviarasunto = tema.getText().toString();
                    String enviarmensaje = contenido.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] { enviarcorreo });
                    intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                    intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Tu Correo se Envio Exitosamente a "+ enviarcorreo, Toast.LENGTH_LONG).show();

                }
            }
        });

        imganterior = findViewById(R.id.imagen_anterior_de_contactMiembro);
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent(getApplicationContext(), Inicio_LogueadosFragment.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });
    }

    public boolean validar(){
        boolean retorno = true;
        String campo1=direccion.getText().toString();
        String campo2=tema.getText().toString();
        String campo3=contenido.getText().toString();
        if (campo1.isEmpty()){
            direccion.setError("Este campo no puede ser vacio");
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