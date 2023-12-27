package com.example.app;

public class DiabetesData {
    private int pregnancy;
    private int glucose;
    private int bloodPressure;
    private int skinThickness;
    private int insulin;
    private double bmi;
    private double pedigreeFunction;
    private int age;
    private int outcome;

    // Constructor
    public DiabetesData(int pregnancy, int glucose, int bloodPressure, int skinThickness, int insulin,
                        double bmi, double pedigreeFunction, int age, int outcome) {
        this.pregnancy = pregnancy;
        this.glucose = glucose;
        this.bloodPressure = bloodPressure;
        this.skinThickness = skinThickness;
        this.insulin = insulin;
        this.bmi = bmi;
        this.pedigreeFunction = pedigreeFunction;
        this.age = age;
        this.outcome = outcome;
    }

    // Getters and setters for the fields

    public int getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(int pregnancy) {
        this.pregnancy = pregnancy;
    }

    public int getGlucose() {
        return glucose;
    }

    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getSkinThickness() {
        return skinThickness;
    }

    public void setSkinThickness(int skinThickness) {
        this.skinThickness = skinThickness;
    }

    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getPedigreeFunction() {
        return pedigreeFunction;
    }

    public void setPedigreeFunction(double pedigreeFunction) {
        this.pedigreeFunction = pedigreeFunction;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOutcome() {
        return outcome;
    }

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }
}
