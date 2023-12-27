package com.example.app;

public class LungCancerData {

//    private int id; // Unique identifier for the questionnaire
    private int age;
    private String alcoholConsumption;
    private String allergy;
    private String breathShortness;
    private String chestPain;
    private String chronicDisease;
    private String coughing;
    private String fatigue;
    private String gender;
    private String peerPressure;
    private String smoking;
    private String swallowingDifficulty;
    private String wheezing;
    private String yellowFingers;

    // Default constructor
    public LungCancerData(int age, String alcoholConsumption, String allergy, String breathShortness, String chestPain,
                          String chronicDisease, String coughing, String fatigue, String gender, String peerPressure,
                          String smoking, String swallowingDifficulty, String wheezing, String yellowFingers) {

        this.age = age;
        this.alcoholConsumption = alcoholConsumption;
        this.allergy = allergy;
        this.breathShortness = breathShortness;
        this.chestPain = chestPain;
        this.chronicDisease = chronicDisease;
        this.coughing = coughing;
        this.fatigue = fatigue;
        this.gender = gender;
        this.peerPressure = peerPressure;
        this.smoking = smoking;
        this.swallowingDifficulty = swallowingDifficulty;
        this.wheezing = wheezing;
        this.yellowFingers = yellowFingers;

    }

    // Getter and setter methods for the questionnaire fields
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAlcoholConsumption() {
        return alcoholConsumption;
    }

    public void setAlcoholConsumption(String alcoholConsumption) {
        this.alcoholConsumption = alcoholConsumption;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getBreathShortness() {
        return breathShortness;
    }

    public void setBreathShortness(String breathShortness) {
        this.breathShortness = breathShortness;
    }

    public String getChestPain() {
        return chestPain;
    }

    public void setChestPain(String chestPain) {
        this.chestPain = chestPain;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getCoughing() {
        return coughing;
    }

    public void setCoughing(String coughing) {
        this.coughing = coughing;
    }

    public String getFatigue() {
        return fatigue;
    }

    public void setFatigue(String fatigue) {
        this.fatigue = fatigue;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPeerPressure() {
        return peerPressure;
    }

    public void setPeerPressure(String peerPressure) {
        this.peerPressure = peerPressure;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getSwallowingDifficulty() {
        return swallowingDifficulty;
    }

    public void setSwallowingDifficulty(String swallowingDifficulty) {
        this.swallowingDifficulty = swallowingDifficulty;
    }

    public String getWheezing() {
        return wheezing;
    }

    public void setWheezing(String wheezing) {
        this.wheezing = wheezing;
    }

    public String getYellowFingers() {
        return yellowFingers;
    }

    public void setYellowFingers(String yellowFingers) {
        this.yellowFingers = yellowFingers;
    }


}
