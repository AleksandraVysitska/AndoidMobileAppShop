package com.example.negozio;

public class Utente {
    private String nome, cognome, id, username, eta, email, telefono, password;
    private char genere;
    //private Bitmap immagineProilo;

    public Utente(String nome, String cognome, String id, String username, String eta,
           String email, String telefono, String password, char genere/*Bitmap immagineProfilo*/){
        this.nome=nome;
        this.cognome=cognome;
        this.id=id;
        this.username=username;
        this.eta=eta;
        this.email=email;
        this.telefono=telefono;
        this.password=password;
        this.genere=genere;
        // this.immagineProilo=immagineProfilo;
    }

    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getEta(){return eta;}
    public String getEmail(){ return email; }
    public String getTelefono(){
        return telefono;
    }
    public String getPassword(){
        return password;
    }
    public char getGenere(){return genere;}
    /*public Bitmap getImmagineProilo(){
        return immagineProilo;
    }*/

    public void setNome(String sNome){
        this.nome=sNome;
    }
    public void setCognome(String sCognome){
        this.cognome=sCognome;
    }
    public void setId(String sId){
        this.id=sId;
    }
    public void setUsername(String sUsername){
        this.username=sUsername;
    }
    public void setEta(String sEta){
        this.eta=sEta;
    }
    public void setEmailE(String sEmail){
        this.email=sEmail;
    }
    public void setTelefono(String sTelefono){
        this.telefono=sTelefono;
    }
    public void setPassword(String sPassword){
        this.password=sPassword;
    }
    public void setGenere(char sGenere){
        this.genere=sGenere;
    }
    /*public void setImmagineProilo(Bitmap sImmagineProfilo){
        this.immagineProilo=sImmagineProfilo;
    }*/
}
