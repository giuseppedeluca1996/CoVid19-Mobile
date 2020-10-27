package com.example.covid19.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;


public class Review implements Serializable, Parcelable {
    private Short rating;
    private String description;
    private Date date;
    private Short qualityPrice;
    private Short cleaning;
    private Short service;
    private User idUser;

    protected Review(Parcel in) {
        int tmpRating = in.readInt();
        rating = tmpRating != Integer.MAX_VALUE ? (short) tmpRating : null;
        description = in.readString();
        int tmpQualityPrice = in.readInt();
        qualityPrice = tmpQualityPrice != Integer.MAX_VALUE ? (short) tmpQualityPrice : null;
        int tmpCleaning = in.readInt();
        cleaning = tmpCleaning != Integer.MAX_VALUE ? (short) tmpCleaning : null;
        int tmpService = in.readInt();
        service = tmpService != Integer.MAX_VALUE ? (short) tmpService : null;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rating != null ? (int) rating : Integer.MAX_VALUE);
        dest.writeString(description);
        dest.writeInt(qualityPrice != null ? (int) qualityPrice : Integer.MAX_VALUE);
        dest.writeInt(cleaning != null ? (int) cleaning : Integer.MAX_VALUE);
        dest.writeInt(service != null ? (int) service : Integer.MAX_VALUE);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getQualityPrice() {
        return qualityPrice;
    }

    public void setQualityPrice(Short qualityPrice) {
        this.qualityPrice = qualityPrice;
    }

    public Short getCleaning() {
        return cleaning;
    }

    public void setCleaning(Short cleaning) {
        this.cleaning = cleaning;
    }

    public Short getService() {
        return service;
    }

    public void setService(Short service) {
        this.service = service;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

}
