package com.example.covid19;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomePageFragment extends Fragment implements View.OnClickListener {

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
        // Inflate the layout for this fragment
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
         hotelButton.setOnClickListener(this);
         attractionButton.setOnClickListener(this);
         restaurantButton.setOnClickListener(this);
         whereDoYouWantGo.setOnClickListener(this);
    }





    public void onClick(View view){
        switch (view.getId()){
            case R.id.imageButtonHotel:{
                /*******/
            }break;
            case R.id.imageButtonAttraction:{
                /********/
            }break;
            case R.id.imageButtonRestaurant:{
                /****/
            }break;
            case R.id.imageViewMapHomePaqeFragment:{
                /*****/
            }break;
            case R.id.whereDoYouWantGoButton:{
                /*****/
            }break;
            default:{

            }
        }
    }
}
