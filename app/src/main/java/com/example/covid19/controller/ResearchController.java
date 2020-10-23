package com.example.covid19.controller;

import android.content.Context;

import com.example.covid19.dao.DaoFactory;
import com.example.covid19.dao.StructureDao;
import com.example.covid19.model.Structure;
import com.google.android.gms.maps.model.LatLng;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public class ResearchController {

    private static StructureDao structureDao;
    private static Context context;

    public static Collection<Structure> getStructureAtDistance(LatLng startPosition, Double distance){
            return structureDao.getStructureAtDistance(BigDecimal.valueOf(startPosition.latitude),BigDecimal.valueOf(startPosition.longitude),BigDecimal.valueOf(distance));
    }

    public static void setContext(Context context) {
        ResearchController.context = context;
        structureDao= Objects.requireNonNull(DaoFactory.getDaoFactory(context)).getStructureDao();
    }
}
