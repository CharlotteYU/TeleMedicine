package com.example.navigater;

import android.Manifest;

import android.content.Context;
import android.content.pm.PackageManager;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;


import com.example.navigater.DatabaseHelper;
import com.google.android.material.navigation.NavigationView;

import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView textView;
    private LocationManager locationManager;

    public DatabaseHelper getMyDb() {
        return myDb;
    }

    private DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create database and insert new values
        myDb = new DatabaseHelper(this);
        myDb.AddPatient("David","Black",56,"cold");
        myDb.AddPatient("Peter","White",66,"Cornavirus");
        myDb.AddPatient("Andy","Smith",88, "Cornavirus");

        //add dignotic program
        myDb.AddProgram(3,1," Measure body temporature ", 1);
        myDb.AddProgram(3,2," Measure blood pressure ", 1);
        myDb.AddProgram(3,3," Measure heartbeat ", 1);

        //add medicine
        myDb.AddMedicine("Antibiotics",1,1);
        myDb.AddMedicine("berberine",1,1);
        myDb.AddMedicine("Erythromycin",1,1);
/*
        myDb.AddDoctor("Tom");
        myDb.AddDoctor("Louis");
        myDb.AddGPS(56.23,13.4);
        myDb.AddGPS(53.43,14.84);
        myDb.AddGPS(55.3,12.94);
        myDb.AddQuestion("What is your temperature?","36.6");
        myDb.AddQuestion("Do you have stomach?", "No");
        myDb.AddCaseReport("fever","temperature is higher than 38","Take antipyretics");
        myDb.AddCaseReport("fracture", "Bone fracture" ,"Plaster");
        myDb.AddMedicine("Antipyretics","Body temperature drop");
        myDb.AddMedicine("Stomach medicine","Relieve stomach pain");
*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_medicine, R.id.nav_question)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        textView = (TextView) findViewById(R.id.id_textview);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
        onLocationChanged(location);



        //Toast.makeText(this,"Values saved",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onLocationChanged(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        textView.setText("Longitude: "+ longitude+"\n"+"Latitude: "+latitude);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
