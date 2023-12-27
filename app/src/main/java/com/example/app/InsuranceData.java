package com.example.app;

public class InsuranceData {

    private String insuranceCompany;
    private String expiryDate;

    public InsuranceData() {
        // Default constructor required for Firebase
    }

    public InsuranceData(String insuranceCompany, String expiryDate) {
        this.insuranceCompany = insuranceCompany;

        this.expiryDate = expiryDate;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }


    public String getExpiryDate() {
        return expiryDate;
    }

}
