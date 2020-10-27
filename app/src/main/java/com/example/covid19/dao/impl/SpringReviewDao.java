package com.example.covid19.dao.impl;


import android.content.Context;
import android.os.AsyncTask;

import com.example.covid19.dao.ReviewDao;
import com.example.covid19.model.HttpClient;
import com.example.covid19.model.Review;
import com.example.covid19.model.Structure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class SpringReviewDao extends ReviewDao {

    private HttpClient httpClient;
    private static SpringReviewDao instance;
    private Gson gson;

    private SpringReviewDao(Context context){
        gson = new Gson();
        httpClient=new HttpClient(context);
    }

    public static SpringReviewDao getInstance(Context context){
        if(instance == null) {
            synchronized (SpringUserDao.class) {
                instance = new SpringReviewDao(context);
            }
        }
        return instance;
    }

    @Override
    public void save(Review entity) {

    }

    @Override
    public Review update(Review newEntity, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) { }

    @Override
    public Review getById(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> getAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public Double getAvgRating(Integer idStructure) {
        Response response= null;
        try {
            response = httpClient.requestGet("review/public/getAverageRatingOfStructure?idStructure=" + idStructure,false,null);
            if( response.isSuccessful()){
                return Double.valueOf(response.body().string());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    @Override
    public   List<Review> getAllByIdStructure(Integer idStructure){
        AsyncTask<Integer, Void,List<Review>> asyncTask=new AsyncTask<Integer, Void, List<Review>>(){
            @Override
            protected List<Review> doInBackground(Integer... objects) {
                try{
                    Response response=httpClient.requestGet("review/public/getAllReviewOfStructure?idStructure="+objects[0], false,null);
                    if( response.isSuccessful()){
                        return gson.fromJson(response.body().string(),new TypeToken<List<Review>>() {}.getType());
                    }
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }
                return null;
            }
        };

        try {
            return asyncTask.execute(idStructure).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
