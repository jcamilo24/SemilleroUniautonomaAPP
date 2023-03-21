package com.example.semillerouniautonoma.view.inicio_logueados_estudiantes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.semillerouniautonoma.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link contacto_implicitoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contacto_implicitoFragment extends Fragment {
    EditText nombre_estudiante,semestre,carrera,direccion,tema,contenido;
    Button button;
    Session session;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public contacto_implicitoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contacto_liderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static contacto_implicitoFragment newInstance(String param1, String param2) {
        contacto_implicitoFragment fragment = new contacto_implicitoFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contacto_miembro, container, false);
        nombre_estudiante = v.findViewById(R.id.nombre_estu);
        semestre = v.findViewById(R.id.semestre);
        carrera = v.findViewById(R.id.carrera);
        direccion = v.findViewById(R.id.correo);
        tema = v.findViewById(R.id.tema);
        contenido = v.findViewById(R.id.contenido);

        String correo_personal="admsemillerodesarrollo2022@gmail.com";
        String contraseña="adminsemillero2022";

        button = v.findViewById(R.id.enviar_correo_miembro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");

                try {
                    session= javax.mail.Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo_personal,contraseña);
                        }
                    });
                } catch (Exception e){
                    e.printStackTrace();
                }

                if (session!=null){
                    MimeMessage message = new MimeMessage(session);
                    try {
                        message.setFrom(new InternetAddress(correo_personal));
                        message.setSubject(tema.getText().toString());
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(direccion.getText().toString()));
                        message.setContent(contenido.getText().toString(),"text/html; charset=utf-8");
                        Transport.send(message);

                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getView().getContext(), "Tu Correo se Envio Exitosamente a "+ direccion.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return v;
    }
}