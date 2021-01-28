package com.example.proiectandroid;


//clasa pe care vom construi obiecte populate din XML BNR
public class Moneda {
    private float RON;
    private float EUR;
    private float USD;
    private float GBP;

    public float getRON() {
        return RON;
    }

    public void setRON(float RON) {
        this.RON = RON;
    }

    public float getEUR() {
        return EUR;
    }

    public void setEUR(float EUR) {
        this.EUR = EUR;
    }

    public float getUSD() {
        return USD;
    }

    public void setUSD(float USD) {
        this.USD = USD;
    }

    public float getGBP() {
        return GBP;
    }

    public void setGBP(float GBP) {
        this.GBP = GBP;
    }

    public Moneda() {
    }
}
