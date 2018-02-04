package cheryl.fishackathon;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsActivity extends FragmentActivity {

    GoogleMap mMap;
    SupportMapFragment mapFragment;

    private FusedLocationProviderClient mFusedLocationClient;
    MapView mMapView;
    //    SupportMapFragment mapFragment;
    private static final int MY_PERMISSIONS_REQUEST = 100;
    String[] permissionArray = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    public void nextOnClick(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isChoose", true);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
*/
        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume(); // needed to get the map to display immediately
        setUpMap();

    }

    private void setUpMap() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(MapsActivity.this);
        try {
            MapsInitializer.initialize(MapsActivity.this.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                mMap = googleMap;
                if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MapsActivity.this,
                            permissionArray,
                            MY_PERMISSIONS_REQUEST);
                } else {
                    mMap.setMyLocationEnabled(true);
                    mFusedLocationClient.getLastLocation()
                            .addOnSuccessListener(MapsActivity.this, new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                    // Got last known location. In some rare situations this can be null.
                                    if (location != null) {
                                        double latitude = location.getLatitude();
                                        double longitude = location.getLongitude();
                                        LatLng latLng = new LatLng(latitude, longitude);
                                        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 12);
                                        mMap.animateCamera(yourLocation);
                                    }
                                }
                            });
                }
            }
        });
    }
    /*
    @Override
    public void onMapReady(GoogleMap mMap) {
        mMap = mMap;

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    permissionArray,
                    MY_PERMISSIONS_REQUEST);
        }else {
            Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, true));
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            LatLng latLng = new LatLng(latitude, longitude);
            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 5);
            mMap.animateCamera(yourLocation);
        }
    }
    */
}
