package com.example.santoshyadav.sqllitereglogin;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Objects;

@SuppressWarnings("ALL")
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng Rajmachi = new LatLng(18.831514, 73.395131);
        mMap.addMarker(new MarkerOptions().position(Rajmachi).title("rajmachi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rajmachi));

        LatLng Lonavala = new LatLng(18.748060, 73.407219);
        mMap.addMarker(new MarkerOptions().position(Lonavala).title("lonavala"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Lonavala));

        LatLng Raireshwar = new LatLng(18.0499998, 73.7333304);
        mMap.addMarker(new MarkerOptions().position(Raireshwar).title("Raireshwar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Raireshwar));

        final LatLng Lohagad = new LatLng(18.694317, 73.487259);
        mMap.addMarker(new MarkerOptions().position(Lohagad).title("lohagad"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Lohagad));

        LatLng SGNP = new LatLng(19.224332436, 72.867996528);
        mMap.addMarker(new MarkerOptions().position(SGNP).title("Sanjay Gandhi National Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SGNP));

        LatLng Matheran = new LatLng(18.988659, 73.271179);
        mMap.addMarker(new MarkerOptions().position(Matheran).title("Matheran"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Matheran));


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("lohagad"))
                {
                    Intent intent = new Intent(MapsActivity.this, Lohagad.class);
                    startActivity(intent);
                }
                else if(marker.getTitle().equals("Raireshwar"))
                {
                    Intent intent = new Intent(MapsActivity.this, Raireshwar.class);
                    startActivity(intent);
                }
                else if(marker.getTitle().equals("rajmachi")){
                    Intent intent = new Intent(MapsActivity.this, Rajmachi.class);
                    startActivity(intent);
                }
                else if(marker.getTitle().equals("lonavala"))
                {
                    Intent intent = new Intent(MapsActivity.this, Lonavala.class);
                    startActivity(intent);
                }
                else if(marker.getTitle().equals("Sanjay Gandhi National Park"))
                {
                    Intent intent = new Intent(MapsActivity.this, SGNP.class);
                    startActivity(intent);
                }

                else if(marker.getTitle().equals("Matheran"))
                {
                    Intent intent = new Intent(MapsActivity.this, Matheran.class);
                    startActivity(intent);
                }

                return false;
            }
        });


            }

}

