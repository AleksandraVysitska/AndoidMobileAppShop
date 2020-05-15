package com.example.negozio;

public class Prezzo {

private String mValuta;
private float mCosto;

    public Prezzo(String mValuta, float mCosto) {
        this.mValuta = mValuta;
        this.mCosto = mCosto;
    }

    public String getmValuta() {
        return mValuta;
    }

    public float getmCosto() {
        return mCosto;
    }
}
