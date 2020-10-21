package com.example.covid19.model;


import java.util.Date;


public class Review {
    private Short rating;
    private String description;
    private Date date;
    private Short qualityPrice;
    private Short cleaning;
    private Short service;

    public Review() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (rating != null ? !rating.equals(review.rating) : review.rating != null) return false;
        if (description != null ? !description.equals(review.description) : review.description != null)
            return false;
        if (date != null ? !date.equals(review.date) : review.date != null) return false;
        if (qualityPrice != null ? !qualityPrice.equals(review.qualityPrice) : review.qualityPrice != null)
            return false;
        if (cleaning != null ? !cleaning.equals(review.cleaning) : review.cleaning != null)
            return false;
        return service != null ? service.equals(review.service) : review.service == null;
    }

    @Override
    public int hashCode() {
        int result = rating != null ? rating.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (qualityPrice != null ? qualityPrice.hashCode() : 0);
        result = 31 * result + (cleaning != null ? cleaning.hashCode() : 0);
        result = 31 * result + (service != null ? service.hashCode() : 0);
        return result;
    }
}
