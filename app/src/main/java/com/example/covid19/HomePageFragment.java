package com.example.covid19;


import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.covid19.controller.HomePageController;

public class HomePageFragment extends Fragment {

    private ImageView imageViewHomePageFragment;
    private ImageView imageViewMapHomePaqeFragment;

    private ImageButton hotelButton;
    private ImageButton attractionButton;
    private ImageButton restaurantButton;
    private Button whereDoYouWantGo;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomePageFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageViewHomePageFragment=view.findViewById(R.id.imageViewHomePageFragment);
        imageViewHomePageFragment.setScaleType(ImageView.ScaleType.FIT_XY);
        imageViewMapHomePaqeFragment=view.findViewById(R.id.imageViewMapHomePaqeFragment);
        imageViewMapHomePaqeFragment.setScaleType(ImageView.ScaleType.FIT_XY);
         hotelButton=view.findViewById(R.id.imageButtonHotel);
         attractionButton=view.findViewById(R.id.imageButtonAttraction);
         restaurantButton=view.findViewById(R.id.imageButtonRestaurant);
         whereDoYouWantGo=view.findViewById(R.id.whereDoYouWantGoButton);


         whereDoYouWantGo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Navigation.findNavController(v).navigate(R.id.action_homepage_to_search_fragment);
             }
         });

        imageViewMapHomePaqeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(HomePageController.showMap()){
                    Navigation.findNavController(v).navigate(R.id.action_homePage_to_mapsFragment);
                }else {
                    showGPSDisabledAlertToUser();
                }


            }
        });
    }



    private  void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.getContext());
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Enable GPS",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
