package com.mobile.geoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.CameraPosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private MapsActivity mapFragment;
    private Map<String, CameraPosition> locations = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = new MapsActivity();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mapHolder, mapFragment).commit();

        setupZoomButtons();
        setupLocationButtons();
    }

    private void setupZoomButtons() {
        Button zoomInButton = (Button) findViewById(R.id.zoomInButton);
        Button zoomOutButton = (Button) findViewById(R.id.zoomOutButton);

        zoomInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapFragment.zoomIn();
            }
        });

        zoomOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapFragment.zoomOut();
            }
        });
    }

    private void setupLocationButtons() {
        Button showCurrentLocationButton = (Button) findViewById(R.id.showCurrentLocationButton);
        Button saveLocationButton = (Button) findViewById(R.id.saveLocationButton);
        Button goToButton = (Button) findViewById(R.id.goToButon);

        showCurrentLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapFragment.showCurrentLocation();
            }
        });

        saveLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 locations.put(mapFragment.getNameOfLocation(), mapFragment.getLocation());
            }
        });

        goToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LocationsActivity.class);
                intent.putExtra("locations", new ArrayList<String>(locations.keySet()));
                startActivityForResult(intent, 0);
            }
        });
    }
}
