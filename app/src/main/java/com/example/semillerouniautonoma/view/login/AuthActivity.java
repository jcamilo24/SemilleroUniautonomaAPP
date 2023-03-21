package com.example.semillerouniautonoma.view.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.model.Clases.SeedbedsByuser;
import com.example.semillerouniautonoma.model.Interfaces.SeedbedsService;
import com.example.semillerouniautonoma.view.MainActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    int isLogin = 0;
    String TAG = "GoogleSignIn";
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    ImageView imganterior;
    int SIGN_IN_CODE = 777;
    private GoogleApiClient googleApiClient;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        SignInButton button = findViewById(R.id.btnlogin);
        button.setSize(SignInButton.SIZE_WIDE);
        button.setColorScheme(SignInButton.COLOR_DARK);
        imganterior = findViewById(R.id.imagen_anterior_login);
        imganterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        mAuth = FirebaseAuth.getInstance();
        Bundle param = this.getIntent().getExtras();
        if(param != null) {
            String dat = param.getString("cerrar");
            if (dat.equals("si")) {
                FirebaseAuth.getInstance().signOut();
            }
        }
        //********  CONFIGURACION FIREBASE ***********//
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client))
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog.setMessage("Cargando ...");
                showDialog();
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, SIGN_IN_CODE);
            }
        });
        SharedPreferences shared = getSharedPreferences("datos", MODE_PRIVATE);
        String channel = (shared.getString("rol_user", ""));
        String isLogin = (shared.getString("isLogin", ""));
        mGoogleSignInClient = GoogleSignIn.getClient(AuthActivity.this, gso);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null){
                    String correo = user.getEmail();
                    String nombre = user.getDisplayName();
                    Uri foto = user.getPhotoUrl();
                    String fotoo = foto.toString();
                    referenciar(correo,nombre,fotoo);
                }
            }
        };
    }
    public void referenciar(String correo, String nombre, String fotoo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-autonoma-production-8a3b.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SeedbedsService service = retrofit.create(SeedbedsService.class);
        Call<List<SeedbedsByuser>> call = service.SeedbedUser(correo);
        call.enqueue(new Callback<List<SeedbedsByuser>>() {
            @Override
            public void onResponse(Call<List<SeedbedsByuser>> call, Response<List<SeedbedsByuser>> response) {
                if(response.isSuccessful()) {
                    Log.e("listaqqq", response.body().toString());
                    List<SeedbedsByuser> seedbedsByuserList = response.body();
                    for (int i = 0; i < seedbedsByuserList.size(); i++) {
                        String nombre_rol = seedbedsByuserList.get(i).getRol_nombre().toString();
                        String codigo = seedbedsByuserList.get(i).getSem_id().toString();
                        goMainScreen(nombre, fotoo, correo, nombre_rol,codigo);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<SeedbedsByuser>> call, Throwable t) {
                Log.e("negacion", "no funcionooooo");
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            if (task.isSuccessful()) {
                try {
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

                   // Toast.makeText(getApplicationContext(), "Bienvenido "+ account.getDisplayName()+" "+account.getEmail()+" "+account.getPhotoUrl(), Toast.LENGTH_SHORT).show();

                } catch (ApiException e) {
                    Log.w(TAG, "Google sign in failed", e);
                }
            } else {
                Log.d(TAG, "Error, login no exitoso:" + task.getException().toString());
            }
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()){
            firebaseAuthWithGoogle(result.getSignInAccount());
        }else{
            hideDialog();
            Toast.makeText(this,"No se pudo iniciar sesion", Toast.LENGTH_SHORT).show();
        }
    }
    private void goMainScreen(String nombre, String foto, String correo, String rol, String codigo) {
        hideDialog();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        if ((!rol.equals("estudiante")) && (!rol.equals("lider")) && (!rol.equals("administrador"))){
            intent.putExtra("rol", 0);
            isLogin = 0;
        }else if(rol.equals("estudiante")){
            intent.putExtra("rol", 1);
            isLogin = 1;
        }else if(rol.equals("lider")){
            intent.putExtra("rol", 2);
            isLogin = 2;
        }
        SharedPreferences pref = getApplicationContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("rol_user", rol);
        editor.putString("isLogin", String.valueOf(isLogin));
        editor.putString("nombre", nombre);
        editor.putString("foto", foto);
        editor.putString("codigoIniciado", codigo);
        editor.putString("correo", correo);
        editor.putString("correo_firebase", correo);
        editor.commit();
        startActivity(intent);
        finish();
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
    @Override
    public void onBackPressed() {
        return;
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }
    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount signInAccount) {
        AuthCredential credential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }
                    }
                });
    }
}
