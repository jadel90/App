package com.example.app;

public class RatingData {

    private float rating;
    private String feedback;

    // Default constructor (required for Firebase)
    public RatingData() {
        // Default constructor is needed for Firebase to deserialize objects
    }

    public RatingData(float rating, String feedback) {
        this.rating = rating;
        this.feedback = feedback;
    }

    public float getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

}
