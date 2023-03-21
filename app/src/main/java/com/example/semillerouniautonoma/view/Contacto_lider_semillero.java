package com.example.semillerouniautonoma.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.Users;
import com.example.semillerouniautonoma.model.Clases.Users_rol;
import com.example.semillerouniautonoma.model.Clases.Users_seedbed;
import com.example.semillerouniautonoma.model.Interfaces.Rol_UserPostService;
import com.example.semillerouniautonoma.model.Interfaces.SeedbedsService;
import com.example.semillerouniautonoma.model.Interfaces.UserPostService;
import com.example.semillerouniautonoma.view.semilleros.Detalle_semillero_Activity;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Contacto_lider_semillero extends AppCompatActivity {

    EditText correo;
    ImageView imganterior;
    EditText correo_estudiante,nombre_estudiante,codigo,semestre,carrera,direccion,tema,contenido;
    Button button;
    String titulo = "";
    String fecha1 = "";
    String descripcion = "";
    String nombre = "";
    String codigo_sem="";
    String correo_usu="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_lider_semillero);
        correo_estudiante = findViewById(R.id.correo_estu);
        nombre_estudiante = findViewById(R.id.nombre_estu);
        codigo = findViewById(R.id.codigo_estu);
        semestre = findViewById(R.id.semestre);
        carrera = findViewById(R.id.carrera);
        tema = findViewById(R.id.tema);
        contenido = findViewById(R.id.contenido);
        correo = findViewById(R.id.correo);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            correo_usu = extras.getString("correo_usuario");
            codigo_sem = extras.getString("codigo_semillero");
            titulo = extras.getString("text");
            fecha1 = extras.getString("textfecha");
            descripcion = extras.getString("descripcion");
            nombre = extras.getString("nombre");
        }
        String uscorreo = correo_usu.toString().replaceAll("null","");
        correo.setText(uscorreo);
        String finalCodigo_sem = codigo_sem;
        button = findViewById(R.id.enviar_correo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()){
                    String enviarcorreo = correo.getText().toString();
                    String enviarasunto = tema.getText().toString();
                    String enviarmensaje = contenido.getText().toString();
                    String nombreestudiante = nombre_estudiante.getText().toString();
                    String codigoestudiante = codigo.getText().toString();
                    String semestreestudiante = semestre.getText().toString();
                    String carreraestudiante = carrera.getText().toString();
                    referenciar(correo_estudiante.getText().toString(), nombre_estudiante.getText().toString(), finalCodigo_sem);
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] { enviarcorreo });
                    intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                    intent.putExtra(Intent.EXTRA_TEXT, "Hola mi nombre es " + nombreestudiante + " con codigo: " +
                            codigoestudiante + ", actualmente estoy en el semestre " + semestreestudiante +
                            " y pertenezco al programa de "+ carreraestudiante + "." + "\n\n" + enviarmensaje);
                    startActivity(intent);
                }
                Toast.makeText(getApplicationContext(),"Peticion Enviada", Toast.LENGTH_SHORT).show();
            }
        });

        imganterior = findViewById(R.id.imagen_anterior);
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Detalle_semillero_Activity.class);
                intent.putExtra("correo_usuario", correo_usu);
                intent.putExtra("codigo_semillero", codigo_sem);
                intent.putExtra("text", titulo);
                intent.putExtra("textfecha", fecha1);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("nombre", nombre);
                intent.putExtra("correo", correo_usu);
                intent.putExtra("codigo_sem", codigo_sem);
                startActivity(intent);
            }
        });
    }

    public boolean validar(){
        boolean retorno = true;
        String campo1=correo_estudiante.getText().toString();
        String campo2=nombre_estudiante.getText().toString();
        String campo3=correo.getText().toString();
        String campo4=codigo.getText().toString();
        String campo5=semestre.getText().toString();
        String campo6=carrera.getText().toString();
        String campo7=tema.getText().toString();
        String campo8=contenido.getText().toString();
        if (campo1.isEmpty()){
            correo_estudiante.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo2.isEmpty()){
            nombre_estudiante.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo3.isEmpty()){
            correo.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo4.isEmpty()){
            codigo.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo5.isEmpty()){
            semestre.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo6.isEmpty()){
            carrera.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo7.isEmpty()){
            tema.setError("Este campo no puede ser vacio");
            retorno= false;
        }
        if (campo8.isEmpty()){
            contenido.setError("Este campo no puede ser vacio");
            retorno= false;
        }

        return retorno;
    }

    private void referenciar(String correo, String nombre, String codigo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserPostService service = retrofit.create(UserPostService.class);
        String imagen = "";
        Call<Users> call = service.NewUser(correo, nombre, imagen);
        call.enqueue(new Callback<Users>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()) {
                    SeedbedsService service = retrofit.create(SeedbedsService.class);
                    String codigo_rol = "3";
                    String estado_miembro = "pendiente";
                    LocalDate todaysDate = LocalDate.now();
                    Call<Users_seedbed> call2 = service.NewUser_seedbed(codigo, correo, codigo_rol, estado_miembro, LocalDate.parse("2030-09-14"));
                    call2.enqueue(new Callback<Users_seedbed>() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onResponse(Call<Users_seedbed> call, Response<Users_seedbed> response) {
                            Toast.makeText(getApplicationContext(), "Peticion Enviada", Toast.LENGTH_LONG).show();
                            if (response.isSuccessful()) {
                                RequestQueue myrequest = Volley.newRequestQueue(getApplicationContext());
                                JSONObject json = new JSONObject();
                                try {
                                    String token = "";
                                    json.put("to", token);
                                    JSONObject notificacion = new JSONObject();
                                    notificacion.put("titulo", "soy un titulo");
                                    notificacion.put("detalle", "soy un detalle");
                                    json.put("data", notificacion);
                                    String URL = "https://fcm.googleapis.com/fcm/send";

                                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, json, null, null) {
                                        @Override
                                        public Map<String, String> getHeaders() {
                                            Map<String, String> header = new HashMap<>();
                                            header.put("content-type", "application/json");
                                            header.put("authorization", "key=AAAAu_aN2QI:APA91bF0z430LqV6gXJGS05Dr3VypMIhr6xVxjJWY1wS8-zd5UP8NtBnRQA84oItixaggziTFulYpBy6LjEdy8S_SAAPqIQwKHH9VYBntCV3zCYNzeUkP3ILci2zFfIrj-wImiLHAeKb");
                                            return header;
                                        }
                                    };
                                    myrequest.add(request);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        @Override
                        public void onFailure(Call<Users_seedbed> call, Throwable t) {
                            Log.e("negacion", "usuario no añadido2");
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Log.e("negacion", "usuario no añadido1");
            }
        });
    }
}
