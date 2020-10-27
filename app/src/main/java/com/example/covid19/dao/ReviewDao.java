package com.example.covid19.dao;


import com.example.covid19.model.Review;

import java.util.List;
import java.util.Map;

public abstract class ReviewDao implements AbstractDao<Review> {


    @Override
    public void save(Review entity) {

    }

    @Override
    public Review update(Review newEntity, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Review getById(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> getAll(Integer page, Integer size) {
        return null;
    }

    public abstract  List<Review> getAllByIdStructure(Integer idStructure);

    public abstract Double getAvgRating(Integer idStructure);
}
