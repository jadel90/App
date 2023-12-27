package com.example.app;

public class HeartDiseaseData {

    private int age;
    private int bp;
    private String chestPain;
    private int cholesterol;
    private String ekgResult;
    private String exerciseAngina;
    private String fbsOver120;
    private int maxHR;
    private String sex;
    private float stDepression;
    private String stSlope;
    private String thallium;
    private int vesselsFluroNum;


    public HeartDiseaseData() {
        // Default constructor required for Firestore
    }

    public HeartDiseaseData(int age, int bp, String chestPain, int cholesterol, String ekgResult, String exerciseAngina,
                            String fbsOver120, int maxHR, String sex, float stDepression, String stSlope, String thallium, int vesselsFluroNum) {
        this.age = age;
        this.bp = bp;
        this.chestPain = chestPain;
        this.cholesterol = cholesterol;
        this.ekgResult = ekgResult;
        this.exerciseAngina = exerciseAngina;
        this.fbsOver120 = fbsOver120;
        this.maxHR = maxHR;
        this.sex = sex;
        this.stDepression = stDepression;
        this.stSlope = stSlope;
        this.thallium = thallium;
        this.vesselsFluroNum = vesselsFluroNum;
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public String getChestPain() {
        return chestPain;
    }

    public void setChestPain(String chestPain) {
        this.chestPain = chestPain;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getEkgResult() {
        return ekgResult;
    }

    public void setEkgResult(String ekgResult) {
        this.ekgResult = ekgResult;
    }

    public String getExerciseAngina() {
        return exerciseAngina;
    }

    public void setExerciseAngina(String exerciseAngina) {
        this.exerciseAngina = exerciseAngina;
    }

    public String getFbsOver120() {
        return fbsOver120;
    }

    public void setFbsOver120(String fbsOver120) {
        this.fbsOver120 = fbsOver120;
    }

    public int getMaxHR() {
        return maxHR;
    }

    public void setMaxHR(int maxHR) {
        this.maxHR = maxHR;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getStDepression() {
        return stDepression;
    }

    public void setStDepression(float stDepression) {
        this.stDepression = stDepression;
    }

    public String getStSlope() {
        return stSlope;
    }

    public void setStSlope(String stSlope) {
        this.stSlope = stSlope;
    }

    public String getThallium() {
        return thallium;
    }

    public void setThallium(String thallium) {
        this.thallium = thallium;
    }

    public int getVesselsFluroNum() {
        return vesselsFluroNum;
    }

    public void setVesselsFluroNum(int vesselsFluroNum) {
        this.vesselsFluroNum = vesselsFluroNum;
    }


}
