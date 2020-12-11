package com.example.projetsession;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements LocationListener {
    //AIzaSyA5xDEnZHM0aNuLttS101npzaGpgivcflw
    // longitude -72.572637  latitude 46.354486  cegeptr dans le local informatique
    private static final int perms_call_id = 123;
    private LocationManager lm;
    private MapFragment mapfragment;
    private GoogleMap googleMap;
    private UiSettings mUiSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        FragmentManager fragmentManager = getFragmentManager();
        mapfragment = (MapFragment) fragmentManager.findFragmentById(R.id.maps);


    }

    @Override
    //@SuppressWarnings("missingPermission")
    protected void onResume() {
        super.onResume();
        checkpermission();
    }

    private void checkpermission(){
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            },perms_call_id);
            return;
        }

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
        }
        if(lm.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0,this);
        }
        if(lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0,this);
        }
        loadmap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == perms_call_id){
            checkpermission();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(lm != null){
            lm.removeUpdates(this);
        }
    }
    //on googlemap.setmylocationenabled need to ask permisson thats why the loadmap is in the checkpermission to make sur it is
    @SuppressWarnings("missingPermission") // enabled
    private void loadmap(){
        mapfragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                MapsActivity.this.googleMap = googleMap;
                googleMap.moveCamera(CameraUpdateFactory.zoomBy(15));
                googleMap.setMyLocationEnabled(true);
                //googleMap.addMarker(new MarkerOptions().position(new LatLng(43.222222, 6.720000))); //test pour placer un marqueur

                //mUiSettings.setZoomControlsEnabled(isChecked(R.id.zoom_buttons_toggle));
            }

        });
    }

    public void onZoom(View view){
        if(view.getId() == R.id.zoominn){
            MapsActivity.this.googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if(view.getId() == R.id.zoomout){
            MapsActivity.this.googleMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longiture = location.getLongitude();

        //Toast.makeText(this, "location: " + latitude + longiture,Toast.LENGTH_SHORT).show();
        if(googleMap != null){
            LatLng googleLocation = new LatLng( latitude, longiture);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(googleLocation));
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
