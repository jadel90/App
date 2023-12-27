package com.example.app;

public class PatientData {


    private String name;
    private String email;
    private String dob;
    private String phone_number;
    private String address;

    private String insuranceCompany;
    private String policyNumber;
    private String expiryDate;
    private float rating; // For RatingBar
    private String reviews;

    // Default constructor (required for Firebase)
    public PatientData() {
    }

    public PatientData(String name, String email, String dob, String phone_number, String address, String insuranceCompany, String policyNumber, String expiryDate, float rating, String reviews) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone_number = phone_number;
        this.address = address;
        this.policyNumber = policyNumber;
        this.expiryDate = expiryDate;
        this.rating = rating;
        this.reviews = reviews;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }


}
