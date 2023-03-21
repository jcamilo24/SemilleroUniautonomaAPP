package com.example.semillerouniautonoma.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.bumptech.glide.Glide;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.view.login.AuthActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    Button button, button2;
    FirebaseFirestore db;
    ImageView header_image;
    TextView header_text_1, rol_nombre;
    private FirebaseAuth mAuth;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String rol_usu;

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences shared = getSharedPreferences("datos", MODE_PRIVATE);
        String channel = (shared.getString("rol_user", ""));
        String isLogin = (shared.getString("isLogin", ""));
        if(isLogin.equals("1")){
            String correo_usuario="";
            String nombre_usuario="";
            String foto="";
            SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
            rol_usu = pref.getString("rol_user","");
            foto = pref.getString("foto","");
            nombre_usuario = pref.getString("nombre","");
            correo_usuario = pref.getString("correo","");
            Log.e("verificacionDatos",nombre_usuario + correo_usuario + foto);
            header_text_1.setText(nombre_usuario);
            Glide.with(this).load(foto).into(header_image);
            preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            editor = preferences.edit();
            editor.putString("correo_firebase",correo_usuario);
            editor.commit();
        }
        if(isLogin.equals("2")){
            String correo_usuario="";
            String nombre_usuario="";
            String foto="";
            SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
            rol_usu = pref.getString("rol_user","");
            foto = pref.getString("foto","");
            nombre_usuario = pref.getString("nombre","");
            correo_usuario = pref.getString("correo","");
            Log.e("verificacionDatos",nombre_usuario + correo_usuario + foto);
            header_text_1.setText(nombre_usuario);
            Glide.with(this).load(foto).into(header_image);
            preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            editor = preferences.edit();
            editor.putString("correo_firebase",correo_usuario);
            editor.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        SharedPreferences shared = getSharedPreferences("datos", MODE_PRIVATE);
        String channel = (shared.getString("rol_user", ""));
        String isLogin = (shared.getString("isLogin", ""));

        if (isLogin.equals("0") || isLogin.equals("")) {
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.activity_main_drawer);
            button2 = findViewById(R.id.btncerrarSesion);
            button2.setEnabled(false);
            button2.setVisibility(View.GONE);
            mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_publicaciones,R.id.nav_eventos,
                    R.id.nav_semillero_1, R.id.nav_semillero_2, R.id.nav_preguntas, R.id.nav_normatividad,
                    R.id.nav_contacto_uni, R.id.nav_copyright)
                    .setDrawerLayout(drawer)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        } else if (isLogin.equals("1")){
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.menu_login_estudiantes);
            button = findViewById(R.id.btnlogin);
            button.setEnabled(false);
            button.setVisibility(View.GONE);
            View header_view = navigationView.getHeaderView(0);
            header_view.setVisibility(View.GONE);
            View header = LayoutInflater.from(this).inflate(R.layout.nav_header_logueados_estudiantes, null);
            navigationView.addHeaderView(header);
            header_text_1 = header.findViewById(R.id.nombre_usuario);
            header_image = header.findViewById(R.id.imageperfil);
            rol_nombre = header.findViewById(R.id.texto_del_rol);
            String rol_usu="";
            SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
            rol_usu = pref.getString("rol_user","");
            Log.e("rol_traido1",rol_usu);
            String s = rol_usu.substring(0, 1).toUpperCase() + rol_usu.substring(1);
            rol_nombre.setText(s);
            mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.menu_start_session_estudiante, R.id.nav_redes_estudiante_1, R.id.nav_redes_estudiante_2,
                    R.id.nav_redes_estudiante_3, R.id.nav_redes_estudiante_4, R.id.nav_ayuda_login, R.id.nav_copyright_login)
                    .setDrawerLayout(drawer)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.setGraph(R.navigation.mobile_login_estudiantes_navigation);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        } else if (isLogin.equals("2")){
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.menu_login_docente);
            button = findViewById(R.id.btnlogin);
            button.setEnabled(false);
            button.setVisibility(View.GONE);
            View header_view = navigationView.getHeaderView(0);
            header_view.setVisibility(View.GONE);
            View header = LayoutInflater.from(this).inflate(R.layout.nav_header_logueados_estudiantes, null);
            navigationView.addHeaderView(header);
            header_text_1 = header.findViewById(R.id.nombre_usuario);
            header_image = header.findViewById(R.id.imageperfil);
            rol_nombre = header.findViewById(R.id.texto_del_rol);
            String rol_usu="";
            SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
            rol_usu = pref.getString("rol_user","");
            Log.e("rol_traido2",rol_usu);
            String s = rol_usu.substring(0, 1).toUpperCase() + rol_usu.substring(1);
            rol_nombre.setText(s);
            mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.menu_start_session_docente,R.id.nav_redes_docente_1,
                    R.id.nav_redes_docente_2,R.id.nav_redes_docente_3,R.id.nav_redes_docente_4,R.id.nav_redes_docente_5
                    ,R.id.nav_redes_docente_6,R.id.nav_ayuda_login,R.id.nav_copyright_login)
                    .setDrawerLayout(drawer)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.setGraph(R.navigation.mobile_login_docente_navigation);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void login(View view) {
        Intent intent = new Intent(MainActivity.this, AuthActivity.class);
        startActivity(intent);
    }
    public void logOut(View view) {
        editor.clear().apply();
        Intent intent = new Intent(MainActivity.this, AuthActivity.class);
        intent.putExtra("cerrar", "si");
        startActivity(intent);
    }
}
