package com.example.covid19.controller;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.example.covid19.R;
import com.example.covid19.SearchFragmentDirections;
import com.example.covid19.StructureListFragmentDirections;
import com.example.covid19.dao.DaoFactory;
import com.example.covid19.dao.ReviewDao;
import com.example.covid19.dao.StructureDao;
import com.example.covid19.model.Filter;
import com.example.covid19.model.Order;
import com.example.covid19.model.Structure;
import com.example.covid19.model.Type;
import com.google.android.gms.maps.model.LatLng;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;


public class SearchController {

    private static StructureDao structureDao;
    private static ReviewDao reviewDao;
    private static Context context;
    private static NavController navController;



    private static List<Structure> structures;
    private static final Filter filter =  new Filter();
    private static final Order order = new Order();



    public static Collection<Structure> getStructureAtDistance(LatLng startPosition, Double distance){
            return structureDao.getStructureAtDistance(BigDecimal.valueOf(startPosition.latitude),BigDecimal.valueOf(startPosition.longitude),BigDecimal.valueOf(distance));
    }

    public static void setContext(Context context) {
        SearchController.context = context;
        structureDao = Objects.requireNonNull(DaoFactory.getDaoFactory(context)).getStructureDao();
        reviewDao = Objects.requireNonNull(DaoFactory.getDaoFactory(context)).getReviewDao();
        navController =  Navigation.findNavController((Activity) context, R.id.fragment);

    }

    public static void  getStructureAroundYou(LatLng latLng, Type type) {
        structures = structureDao.getStructureAroundYou(BigDecimal.valueOf(latLng.latitude),BigDecimal.valueOf(latLng.longitude),type);
        AsyncTask<List<Structure>, Void,Void> asyncTask=new AsyncTask<List<Structure>, Void, Void>(){
            @Override
            protected Void doInBackground(List<Structure>... lists) {
                for(Structure s : lists[0]){
                    s.setAvgRating(reviewDao.getAvgRating(s.getId()));
                }
                return null;
            }
        };
        try {
            asyncTask.execute(structures).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }        filter.addType(type);
        SearchFragmentDirections.ActionSearchFragmentToStructureList searchFragmentDirections =  SearchFragmentDirections.actionSearchFragmentToStructureList(Arrays.copyOf(structures.toArray(), structures.size(), Structure[].class));
        navController.navigate(searchFragmentDirections);
    }
    public static void  getStructureAroundYou(LatLng latLng) {
        structures = structureDao.getStructureAroundYou(BigDecimal.valueOf(latLng.latitude),BigDecimal.valueOf(latLng.longitude));
        AsyncTask<List<Structure>, Void,Void> asyncTask=new AsyncTask<List<Structure>, Void, Void>(){
            @Override
            protected Void doInBackground(List<Structure>... lists) {
                for(Structure s : lists[0]){
                    s.setAvgRating(reviewDao.getAvgRating(s.getId()));
                }
                return null;
            }
        };
        try {
            asyncTask.execute(structures).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }        filter.removeAllType();
        SearchFragmentDirections.ActionSearchFragmentToStructureList searchFragmentDirections =  SearchFragmentDirections.actionSearchFragmentToStructureList(Arrays.copyOf(structures.toArray(), structures.size(), Structure[].class));
        navController.navigate(searchFragmentDirections);
    }

    public static void getStructureByText(String query, Type type) {
        structures =  structureDao.getStructureByText(query, type);
        AsyncTask<List<Structure>, Void,Void> asyncTask=new AsyncTask<List<Structure>, Void, Void>(){
            @Override
            protected Void doInBackground(List<Structure>... lists) {
                for(Structure s : lists[0]){
                    s.setAvgRating(reviewDao.getAvgRating(s.getId()));
                }
                return null;
            }
        };
        try {
            asyncTask.execute(structures).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        filter.addType(type);
        SearchFragmentDirections.ActionSearchFragmentToStructureList searchFragmentDirections =  SearchFragmentDirections.actionSearchFragmentToStructureList(Arrays.copyOf(structures.toArray(), structures.size(), Structure[].class));
        navController.navigate(searchFragmentDirections);
    }

    public static void getStructureByText(String query) {
        structures = structureDao.getStructureByText(query);
        AsyncTask<List<Structure>, Void,Void> asyncTask=new AsyncTask<List<Structure>, Void, Void>(){
            @Override
            protected Void doInBackground(List<Structure>... lists) {
                for(Structure s : lists[0]){
                    s.setAvgRating(reviewDao.getAvgRating(s.getId()));
                }
                return null;
            }
        };
        try {
            asyncTask.execute(structures).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        filter.removeAllType();
        SearchFragmentDirections.ActionSearchFragmentToStructureList searchFragmentDirections =  SearchFragmentDirections.actionSearchFragmentToStructureList(Arrays.copyOf(structures.toArray(), structures.size(), Structure[].class));
        navController.navigate(searchFragmentDirections);
    }

    public static List<String> getTips(String query) {
        return structureDao.getTips(query);
    }


    public static void showFilter(){
        StructureListFragmentDirections.ActionStructureListToFilterFragment actionStructureListToFilterFragment = StructureListFragmentDirections.actionStructureListToFilterFragment(filter);
        navController.navigate(actionStructureListToFilterFragment);
    }

    public static void showOrder(){

    }
}
