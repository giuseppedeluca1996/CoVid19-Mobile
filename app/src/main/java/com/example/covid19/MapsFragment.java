package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.covid19.controller.SearchController;
import com.example.covid19.model.Structure;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.VisibleRegion;

import java.util.Collection;

public class MapsFragment extends Fragment {

    private static final Double DISTANCE_DEFAULT = 50D;
    private Button researchButton;
    private ImageButton closeButton;

    private Collection<Structure> structures;
    private LatLng lastLocation;

    private LocationManager locationManager;
    private LocationListener locationListener;

    GoogleMap map;

    private final OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                LatLng latLng = new LatLng(locationGPS.getLatitude(),locationGPS.getLongitude());
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,12.0f));
                googleMap.setMyLocationEnabled(true);
                map=googleMap;
            }
            if(structures !=null)
                populateMap(googleMap);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        locationManager = (LocationManager)requireActivity().getSystemService(Context.LOCATION_SERVICE);
        locationListener= new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lastLocation= new LatLng(location.getLatitude(), location.getLongitude());
            }
        };
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            lastLocation=new LatLng(location.getLatitude(),location.getLongitude());

        }
        structures= SearchController.getStructureAtDistance(lastLocation,DISTANCE_DEFAULT);
        return inflater.inflate(R.layout.fragment_maps, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        closeButton=view.findViewById(R.id.closeButtonMapsFragment);
        researchButton=view.findViewById(R.id.reserchButtonMapsFragment);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mapsFragment_to_homePage);
            }
        });

        researchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.clear();
                Double distance = getFocusDistance();
               if ( (structures= SearchController.getStructureAtDistance(map.getCameraPosition().target, distance)) != null)
                    populateMap(map);

            }
        });

    }

    private void populateMap(GoogleMap googleMap){
       synchronized (structures){
            for (Structure s : structures){
                float color;
                switch(s.getType()){
                    case HOTEL:  color=BitmapDescriptorFactory.HUE_AZURE;
                        break;
                    case ATTRACTION: color=BitmapDescriptorFactory.HUE_ORANGE;
                        break;
                    case  RESTAURANT: color=BitmapDescriptorFactory.HUE_YELLOW;
                        break;
                    default:
                       color=BitmapDescriptorFactory.HUE_RED;
                }
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(s.getLatitude().doubleValue(),s.getLongitude().doubleValue()))
                        .title(s.getName())
                        .icon(BitmapDescriptorFactory.defaultMarker(color)
                        ));
            }
        }
    }

    private double getFocusDistance(){
            VisibleRegion visibleRegion = map.getProjection().getVisibleRegion();
            float[] distanceWidth = new float[1];
            LatLng farRight = visibleRegion.farRight;
            LatLng farLeft = visibleRegion.farLeft;
            LatLng nearRight = visibleRegion.nearRight;
            LatLng nearLeft = visibleRegion.nearLeft;
            Location.distanceBetween( (farLeft.latitude + nearLeft.latitude) / 2, farLeft.longitude, (farRight.latitude + nearRight.latitude) / 2, farRight.longitude, distanceWidth);
            return distanceWidth[0]/2/1000;
    }
}