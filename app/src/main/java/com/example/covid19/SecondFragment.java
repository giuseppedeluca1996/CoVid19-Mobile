package com.example.covid19;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    List<String> nameArray=new ArrayList<>();



    SearchView searchView;
    Button searchButton;
    Button aroundYouButton;
    ImageButton backButton;
    ImageView aroundYouImg;
    ListView listView;
    private String mParam1;
    private String mParam2;
    long lastSearchTime=0;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        return inflater.inflate(R.layout.fragment_second, container, false);


    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //searchButton=view.findViewById(R.id.searchButton);
        final Button footer = new Button(getContext());
        footer.setVisibility(View.INVISIBLE);

        final CustomListAdapter whatever = new CustomListAdapter(getActivity(), nameArray);
        listView= view.findViewById(R.id.listView);
        listView.setAdapter(whatever);


        footer.setGravity(Gravity.LEFT);
        footer.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        footer.setHeight(48);
        footer.setTextSize(14);
        footer.setBackgroundColor(Color.parseColor("#FFFFFF"));
        footer.setTextColor(Color.parseColor("#1859FF"));
        footer.setAllCaps(false);
        footer.setText("Search");
        if ( footer != null ) {
            listView.addFooterView(footer);
        } else {
            throw new NullPointerException("footer is null");
        }



        aroundYouImg=view.findViewById(R.id.aroundYouImage);

        searchView=view.findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {



            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("err","sto provandookokokokokokokokom,oo");

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                long actualSearchTime = (Calendar.getInstance()).getTimeInMillis();

                if(newText.length()>=3 && actualSearchTime > lastSearchTime + 1000){
                    lastSearchTime=actualSearchTime;

                    aroundYouButton.setVisibility(View.INVISIBLE);
                    aroundYouImg.setVisibility(View.INVISIBLE);
                    footer.setVisibility(View.VISIBLE);


                    nameArray.clear();


                    for(int i=0;i<3;i++)
                        nameArray.add(newText);


                    whatever.notifyDataSetChanged();

                }else{
                    nameArray.clear();
                    whatever.notifyDataSetChanged();



                }



                return false;
            }



        });



        backButton=view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_secondFragment_to_homePage);
            }
        });

        aroundYouButton=view.findViewById(R.id.aroundYouBtn);
        aroundYouButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("err","SETTAMI LE COORDINATE DELLA POSIZIONE CORRENTE E APRI MAPPA KITABBIVV");
            }
        });
















    }




}