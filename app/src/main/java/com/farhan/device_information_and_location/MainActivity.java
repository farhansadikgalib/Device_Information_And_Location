package com.farhan.device_information_and_location;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    //Device Info
    TextView textView;
    Build build;
    Build.VERSION version;
    String info;

    //Device Location
    private FusedLocationProviderClient client;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
       //Device Info
        DeviceInfo();
        textView.setText(info);

        //Device Location

        client = LocationServices.getFusedLocationProviderClient(this);

        button = findViewById(R.id.find_loaction);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                client.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                    }
                });

//                client.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//
//                    }
//                });

            }
        });







    }

    private void DeviceInfo() {

        info = "Brand: "+ build.BRAND +"\n"+
                "Product: "+ build.PRODUCT +"\n"+
                "Hardware: "+ build.HARDWARE +"\n"+
                "Manufacturer: "+ build.MANUFACTURER +"\n"+
                "Device: "+ build.DEVICE +"\n"+
                "Model: "+ build.MODEL +"\n"+
                "Security Patch: "+ version.SECURITY_PATCH +"\n"+
                "SDK: "+ version.SDK_INT +"\n";






    }
}
