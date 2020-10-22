package com.example.covid19.dao.impl;


import android.content.Context;

import com.example.covid19.dao.StructureDao;
import com.example.covid19.model.HttpClient;
import com.example.covid19.model.Structure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;

public class SpringStructureDao extends StructureDao {

    private HttpClient httpClient;
    private static SpringStructureDao instance;
    private Gson gson;

    private SpringStructureDao(Context context){
        gson= new GsonBuilder().setDateFormat("HH:mm:ss").excludeFieldsWithoutExposeAnnotation().create();
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
       /* Map<String, Object> map =new HashMap<>();
        map.put("numberOfTotalItems",0);
        map.put("collectionItems", null);
        map.put("sizeCollectionItems", 0);
        try {
            HttpResponse<String> response= httpRequest.requestGet("/structure/public/getAllStructures?page=" + page + "&size=" +size, false,null);

            if (response.statusCode()==200 ) {
                try {
                    JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                    if(!(Boolean )jsonObject.get("empty")){
                        JSONArray userContent = (JSONArray) jsonObject.get("content");
                        map.replace("collectionItems", gson.fromJson(userContent.toJSONString(), new TypeToken<List<Structure>>() {}.getType()));
                        map.replace("numberOfTotalItems", Integer.valueOf(jsonObject.get("totalElements").toString()));
                        map.replace("sizeCollectionItems", Integer.valueOf(jsonObject.get("numberOfElements").toString()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;*/
        return null;
    }

    @Override
    public Map<String, Object> getAllHotel(Integer page, Integer size) {
      /*  Map<String, Object> map =new HashMap<>();
        map.put("numberOfTotalItems",0);
        map.put("collectionItems", null);
        map.put("sizeCollectionItems", 0);
        try {
            HttpResponse<String> response= httpRequest.requestGet("/structure/public/getAllStructures/HOTEL?page=" + page + "&size=" +size, false,null);
            if (response.statusCode()==200 ) {
                try {
                    JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                    if(!(Boolean )jsonObject.get("empty")){
                        JSONArray userContent = (JSONArray) jsonObject.get("content");
                        map.replace("collectionItems", gson.fromJson(userContent.toJSONString(), new TypeToken<List<Structure>>() {}.getType()));
                        map.replace("numberOfTotalItems", Integer.valueOf(jsonObject.get("totalElements").toString()));
                        map.replace("sizeCollectionItems", Integer.valueOf(jsonObject.get("numberOfElements").toString()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;*/
        return null;
    }

    @Override
    public Map<String, Object> getAllRestaurant(Integer page, Integer size) {
    /*    Map<String, Object> map =new HashMap<>();
        map.put("numberOfTotalItems",0);
        map.put("collectionItems", null);
        map.put("sizeCollectionItems", 0);
        try {
            HttpResponse<String> response= httpRequest.requestGet("/structure/public/getAllStructures/RESTAURANT?page=" + page + "&size=" +size, false,null);
            if (response.statusCode()==200 ) {
                try {
                    JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                    if(!(Boolean )jsonObject.get("empty")){
                        JSONArray userContent = (JSONArray) jsonObject.get("content");
                        map.replace("collectionItems", gson.fromJson(userContent.toJSONString(), new TypeToken<List<Structure>>() {}.getType()));
                        map.replace("numberOfTotalItems", Integer.valueOf(jsonObject.get("totalElements").toString()));
                        map.replace("sizeCollectionItems", Integer.valueOf(jsonObject.get("numberOfElements").toString()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;*/
        return null;
    }

    @Override
    public Map<String, Object> getAllAttraction(Integer page, Integer size) {
      /*  Map<String, Object> map =new HashMap<>();
        map.put("numberOfTotalItems",0);
        map.put("collectionItems", null);
        map.put("sizeCollectionItems", 0);
        try {
            HttpResponse<String> response= httpRequest.requestGet("/structure/public/getAllStructures/ATTRACTION?page=" + page + "&size=" +size, false,null);
            if (response.statusCode()==200 ) {
                try {
                    JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                    if(!(Boolean )jsonObject.get("empty")){
                        JSONArray userContent = (JSONArray) jsonObject.get("content");
                        map.replace("collectionItems", gson.fromJson(userContent.toJSONString(), new TypeToken<List<Structure>>() {}.getType()));
                        map.replace("numberOfTotalItems", Integer.valueOf(jsonObject.get("totalElements").toString()));
                        map.replace("sizeCollectionItems", Integer.valueOf(jsonObject.get("numberOfElements").toString()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;*/
        return null;
    }

    @Override
    public Map<String, Object> getAllHotelByText(Integer page, Integer size, String text){
       /* Map<String, Object> map =new HashMap<>();
        map.put("numberOfTotalItems",0);
        map.put("collectionItems", null);
        map.put("sizeCollectionItems", 0);
        try {
            HttpResponse<String> response= httpRequest.requestGet("/structure/public/getAllStructuresByText/HOTEL/"+text+"?page=" + page + "&size=" +size, false,null);
            if (response.statusCode()==200 ) {
                try {
                    JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                    if(!(Boolean )jsonObject.get("empty")){
                        JSONArray userContent = (JSONArray) jsonObject.get("content");
                        map.replace("collectionItems", gson.fromJson(userContent.toJSONString(), new TypeToken<List<Structure>>() {}.getType()));
                        map.replace("numberOfTotalItems", Integer.valueOf(jsonObject.get("totalElements").toString()));
                        map.replace("sizeCollectionItems", Integer.valueOf(jsonObject.get("numberOfElements").toString()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;*/
        return null;
    }

    @Override
    public Map<String, Object> getAllRestaurantByText(Integer page, Integer size, String text){
     /*   Map<String, Object> map =new HashMap<>();
        map.put("numberOfTotalItems",0);
        map.put("collectionItems", null);
        map.put("sizeCollectionItems", 0);
        try {
            HttpResponse<String> response= httpRequest.requestGet("/structure/public/getAllStructuresByText/RESTAURANT/"+text+"?page=" + page + "&size=" +size, false,null);
            if (response.statusCode()==200 ) {
                try {
                    JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                    if(!(Boolean )jsonObject.get("empty")){
                        JSONArray userContent = (JSONArray) jsonObject.get("content");
                        map.replace("collectionItems", gson.fromJson(userContent.toJSONString(), new TypeToken<List<Structure>>() {}.getType()));
                        map.replace("numberOfTotalItems", Integer.valueOf(jsonObject.get("totalElements").toString()));
                        map.replace("sizeCollectionItems", Integer.valueOf(jsonObject.get("numberOfElements").toString()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;*/
        return null;
    }

    @Override
    public Map<String, Object> getAllAttractionByText(Integer page, Integer size, String text){
       /* Map<String, Object> map =new HashMap<>();
        map.put("numberOfTotalItems",0);
        map.put("collectionItems", null);
        map.put("sizeCollectionItems", 0);
        try {
            HttpResponse<String> response= httpRequest.requestGet("/structure/public/getAllStructuresByText/ATTRACTION/"+text+"?page=" + page + "&size=" +size, false,null);
            if (response.statusCode()==200 ) {
                try {
                    JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                    if(!(Boolean )jsonObject.get("empty")){
                        JSONArray userContent = (JSONArray) jsonObject.get("content");
                        map.replace("collectionItems", gson.fromJson(userContent.toJSONString(), new TypeToken<List<Structure>>() {}.getType()));
                        map.replace("numberOfTotalItems", Integer.valueOf(jsonObject.get("totalElements").toString()));
                        map.replace("sizeCollectionItems", Integer.valueOf(jsonObject.get("numberOfElements").toString()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;*/
        return null;
    }

}
