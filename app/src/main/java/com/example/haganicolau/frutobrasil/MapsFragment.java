package com.example.haganicolau.frutobrasil;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
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

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);

        // Add a marker in Sydney and move the camera
        LatLng cardinalidade1 = new LatLng(-16.6554902, -49.2385342);
        mMap.addMarker(new MarkerOptions()
                .position(cardinalidade1).title("Marker in Goiânia"));

        LatLng cardinalidade2 = new LatLng(-16.7159734, -49.2067566);
        mMap.addMarker(new MarkerOptions()
                .position(cardinalidade2).title("Marker in Goiânia2"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cardinalidade1));
        mMap.animateCamera(zoom);
        
    }
}
