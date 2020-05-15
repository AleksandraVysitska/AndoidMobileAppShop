package com.example.negozio;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class CapiAbbigliamento {
    private String [] taglia;
    private ArrayList<Colore> colore;
    private String id;
    private String tipologia;
    private String tessuto;
    private ArrayList<Prezzo> prezzo;
    private String brand;
    private int quantita;
    private String descrizione;
    private Bitmap immagine;

    public CapiAbbigliamento(String [] taglia, ArrayList<Colore> colore, String id, String tipologia, String tessuto, ArrayList<Prezzo> prezzo,
                      String brand, int quantita, String descrizione, Bitmap immagine){
        this.taglia= taglia;
        this.colore=colore;
        this.id=id;
        this.tipologia=tipologia;
        this.tessuto=tessuto;
        this.prezzo=prezzo;
        this.brand=brand;
        this.quantita=quantita;
        this.descrizione=descrizione;
        this.immagine=immagine;
    }

    public String[] getTaglia() { return taglia; }
    public ArrayList<Colore> getColore() { return colore; }
    public String getId() { return id; }
    public String getTipologia() { return tipologia; }
    public String getTessuto() { return tessuto; }
    public ArrayList<Prezzo> getPrezzo() { return prezzo; }
    public String getBrand() { return brand; }
    public int getQuantita() { return quantita; }
    public String getDescrizione() { return descrizione; }
    public Bitmap getImmagine() { return immagine; }
}
