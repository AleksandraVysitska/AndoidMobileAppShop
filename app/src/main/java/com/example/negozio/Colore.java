package com.example.negozio;

public class Colore {

    private String mDescrizione;
    private String mHexadecimal;

    Colore (String descrizione, String hexadecimal){
        mDescrizione=descrizione;
        mHexadecimal=hexadecimal;
    }

    public String getmDescrizione() {
        return mDescrizione;
    }

    public String getmHexadecimal() {
        return mHexadecimal;
    }
}
