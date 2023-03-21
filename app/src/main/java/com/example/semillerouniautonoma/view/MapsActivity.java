package com.example.semillerouniautonoma.view;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.semillerouniautonoma.R;
import com.example.semillerouniautonoma.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng uniautonoma = new LatLng(2.440677, -76.60421);
        mMap.addMarker(new MarkerOptions().position(uniautonoma).title("Corporacion Universitaria Autonoma Del Cauca").snippet("Universidad Privada Acreditada Alta Calidad de Popayán").icon(BitmapDescriptorFactory.fromResource(R.drawable.educacion)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uniautonoma));
    }
}