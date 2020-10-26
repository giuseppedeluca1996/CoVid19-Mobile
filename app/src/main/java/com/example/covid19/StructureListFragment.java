 package com.example.covid19;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.covid19.controller.SearchController;
import com.example.covid19.model.Structure;
import com.example.covid19.model.StructureListAdapter;

import java.util.List;


 public class StructureListFragment extends Fragment {


    private RecyclerView structureRecycleView;
    Button filterButton;
    Button orderButton;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;



    private Structure[] structures;

    private List<String>structures_name;
    private List<String>structures_address;
    private List<Double>structures_rating;
    private List<String>structures_image;

     public StructureListFragment() {
        // Required empty public constructor
    }


    public static StructureListFragment newInstance(String param1, String param2) {
        StructureListFragment fragment = new StructureListFragment();
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

        if(getArguments() != null){
            StructureListFragmentArgs args = StructureListFragmentArgs.fromBundle(getArguments());
            structures=args.getStructures();
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_structure_list, container, false);
    }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);

         filterButton=view.findViewById(R.id.filterStructureList);
         orderButton=view.findViewById(R.id.orderStructureList);
         filterButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SearchController.showFilter();
             }
         });
         orderButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SearchController.showOrder();
             }
         });
        structureRecycleView=view.findViewById(R.id.structureListRecycleView);
        StructureListAdapter structureListAdapter= new StructureListAdapter(requireContext(), structures);
        structureRecycleView.setAdapter(structureListAdapter);
        structureRecycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
     }
 }