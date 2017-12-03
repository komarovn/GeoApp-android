package com.mobile.geoapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class MainActivity extends AppCompatActivity {

    private MapsActivity mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int result = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        switch(result) {
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                //Log.d(TAG,"SERVICE_VERSION_UPDATE_REQUIRED");
                break;
            case ConnectionResult.SUCCESS:
                //Log.d(TAG, "Play service available success");
                break;
            default:
                //Log.d(TAG, "unknown services result: " + result);
        }

        mapFragment = new MapsActivity();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mapHolder, mapFragment).commit();
    }

}
