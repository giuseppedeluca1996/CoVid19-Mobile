package com.example.covid19.dao.impl;


import android.content.Context;

import com.example.covid19.dao.ReviewDao;
import com.example.covid19.model.HttpClient;
import com.example.covid19.model.Review;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class SpringReviewDao extends ReviewDao {

    private HttpClient httpClient;
    private static SpringReviewDao instance;
    private Gson gson;

    private SpringReviewDao(Context context){
        gson = new GsonBuilder().setDateFormat("HH:mm:ss").create();
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




}
