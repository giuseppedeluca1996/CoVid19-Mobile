package com.example.covid19.dao;


import com.example.covid19.model.Structure;
import com.example.covid19.model.Type;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class StructureDao implements AbstractDao<Structure> {

    @Override
    public abstract void save(Structure entity);

    @Override
    public abstract Structure update(Structure newEntity, Integer id);

    @Override
    public abstract void delete(Integer id);

    @Override
    public abstract Structure getById(Integer id);

    @Override
    public abstract Map<String, Object> getAll(Integer page, Integer size);

    public abstract Map<String, Object> getAllHotel(Integer page, Integer size);

    public abstract Map<String, Object> getAllRestaurant(Integer page, Integer size);

    public abstract Map<String, Object> getAllAttraction(Integer page, Integer size);

    public abstract  Map<String, Object> getAllHotelByText(Integer page, Integer size, String text);

    public abstract Map<String, Object> getAllRestaurantByText(Integer page, Integer size, String text);

    public abstract Map<String, Object> getAllAttractionByText(Integer page, Integer size, String text);

    public abstract List<Structure> getStructureAtDistance(BigDecimal latitude, BigDecimal longitude, BigDecimal distance);

    public abstract List<Structure> getStructureAroundYou(BigDecimal latitude, BigDecimal longitude, Type type);

    public abstract List<Structure> getStructureAroundYou(BigDecimal latitude, BigDecimal longitude);

    public abstract List<Structure> getStructureByText(String query, Type type);

    public abstract List<Structure> getStructureByText(String query);

    public abstract List<String> getTips(String query);
}
