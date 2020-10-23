package com.example.covid19.dao.impl;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.covid19.dao.StructureDao;
import com.example.covid19.model.HttpClient;
import com.example.covid19.model.Structure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class SpringStructureDao extends StructureDao {

    private HttpClient httpClient;
    private static SpringStructureDao instance;
    private Gson gson;

    private SpringStructureDao(Context context){
        gson= new GsonBuilder().setDateFormat("hh:mm:ss").excludeFieldsWithoutExposeAnnotation().create();
        httpClient=new HttpClient(context);
    }

    public static StructureDao getInstance(Context context){
        if(instance == null) {
            synchronized (SpringStructureDao.class) {
                instance = new SpringStructureDao(context);
            }
        }
        return instance;
    }

    @Override
    public void save(Structure entity) {

    }

    @Override
    public Structure update(Structure newEntity, Integer id) {

        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Structure getById(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> getAll(Integer page, Integer size) {

        return null;
    }

    @Override
    public Map<String, Object> getAllHotel(Integer page, Integer size) {

        return null;
    }

    @Override
    public Map<String, Object> getAllRestaurant(Integer page, Integer size) {

        return null;
    }

    @Override
    public Map<String, Object> getAllAttraction(Integer page, Integer size) {

        return null;
    }

    @Override
    public Map<String, Object> getAllHotelByText(Integer page, Integer size, String text){

        return null;
    }

    @Override
    public Map<String, Object> getAllRestaurantByText(Integer page, Integer size, String text){

        return null;
    }

    @Override
    public Map<String, Object> getAllAttractionByText(Integer page, Integer size, String text){

        return null;
    }


    @Override
    public Collection<Structure> getStructureAtDistance(final BigDecimal latitude, BigDecimal longitude, BigDecimal distance) {
        AsyncTask<BigDecimal, Void,Collection<Structure>> asyncTask=new AsyncTask<BigDecimal,Void,Collection<Structure>>(){
            @Override
            protected Collection<Structure> doInBackground(BigDecimal... bigDecimals) {
                try{
                    Response response=httpClient.requestGet("structure/public/getStructureAtDistance?latitude=" +
                            bigDecimals[0] + "&longitude=" +
                            bigDecimals[1] + "&distance=" + bigDecimals[2],false,null);
                    if( response.isSuccessful()){
                        return gson.fromJson(response.body().string(),new TypeToken<List<Structure>>() {}.getType());
                    }
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }
                return null;
            }
        };

        try {
            return asyncTask.execute(latitude,longitude,distance).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
