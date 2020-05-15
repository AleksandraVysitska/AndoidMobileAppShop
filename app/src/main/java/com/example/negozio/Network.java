package com.example.negozio;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;


//Network - oggetto personalizzato, load in background per tutti i loader

public class Network {

    private static Context mContext;

    //trasforma stringa in oggeto url
    //dichiara una stringa per il ritorno della richiesta
    //assegno alla stringa il ritorno
    //estraggo gli oggetti dal json ***

    public static ArrayList<CapiAbbigliamento> connection (String url, Context context){
        mContext=context;
        URL indirizzo = createUrl(url); //creo oggetto url
        String result;
        result = httpConnection (indirizzo); // risultato della connessione, risposta server
        ArrayList<CapiAbbigliamento> listaCapi = estraiDaJson(result);
        return listaCapi;

    }

    private static ArrayList<CapiAbbigliamento> estraiDaJson(String jsonResponse) {
        ArrayList<CapiAbbigliamento> estratti = new ArrayList();
        try {
            final JSONArray arrayCapi = new JSONArray();
            for (int i = 0; i < arrayCapi.length(); i++) {
                final JSONObject currentItem = arrayCapi.getJSONObject(i);

                String prodotto = currentItem.getString("prodotto");
                String id = currentItem.getString("_id");
                String brand = currentItem.getString("brand");
                String tessuto = currentItem.getString("tessuto");
                String descrizione = currentItem.getString("descrizione");
                String tipo=currentItem.getString("tipo");
                Bitmap immagine=null;
                int quantita = 0;

                JSONArray arrayTaglia = currentItem.getJSONArray("taglia");
                String[] taglie = new String[arrayTaglia.length()];
                for (int t = 0; t < arrayTaglia.length(); t++) {
                    taglie[t] = arrayTaglia.getString(t);
                }

                 ArrayList<Colore> listCorori = new ArrayList();
                    JSONArray arrayColori = currentItem.getJSONArray("colore");
                    for(int c = 0; c<arrayColori.length();c++){
                        JSONObject currentColor = arrayColori.getJSONObject(c);
                        String nome = currentColor.getString("nome");
                        String hex = currentColor.getString("hex");
                        Colore colore = new Colore (nome, hex);
                        listCorori.add(colore);
                    }
                 ArrayList<Prezzo>  listPrezzo = new ArrayList();
                 JSONArray arrayPrezzo = currentItem.getJSONArray("prezzo");
                 for (int p=0; p<arrayPrezzo.length(); p++){
                     JSONObject currentPrezzo=arrayPrezzo.getJSONObject(p);
                     String valuta = currentPrezzo.getString("valuta");
                     Float costo = Float.parseFloat(currentPrezzo.getString("costo"));
                     Prezzo prezzo=new Prezzo(valuta, costo);
                     listPrezzo.add(prezzo);
                 }

                 CapiAbbigliamento capo = new CapiAbbigliamento(taglie, listCorori, id, tipo, tessuto, listPrezzo, brand, quantita, descrizione, immagine );
                 estratti.add(capo);


                //JSONArray array
            }

        }catch (JSONException jsonException){

        }
        return estratti;
    }

    //controllo if se url è vuoto
    //oggetto HttpURL connection, !ogni connessione aperta va chiusa! ,

    private static String httpConnection(URL url) {
        String jsonRequest="";
        if (url==null){
            return jsonRequest;
        }

        HttpURLConnection urlConnection=null;
        InputStream inputStream=null;

        try{
            urlConnection=(HttpURLConnection) url.openConnection();//
            urlConnection.setReadTimeout(10000);//
            urlConnection.setConnectTimeout(15000);//
            urlConnection.setRequestMethod("GET");//
            urlConnection.connect();//apriamo la connessione

            if(urlConnection.getResponseCode()==200){//200-connessione è andata a buon fine e ci torna un risultato che viene immagazzinato nella stringa response
                inputStream=urlConnection.getInputStream();
                jsonRequest=readInputStream(inputStream);
            }else{
                Toast.makeText(mContext,urlConnection.getResponseCode(), Toast.LENGTH_LONG).show();
            }
        }catch (IOException e){
            Toast.makeText(mContext,"Problemi alla connessione!", Toast.LENGTH_LONG).show();
        }finally {
            if(url!=null){
                urlConnection.disconnect();
            }
            if (inputStream !=null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
                    //e.printStackTrace();
                }
            }
        }
            return jsonRequest;
    }

    private static String readInputStream(InputStream inputStream) throws IOException{
        //creare stringBuilder, legge riga per riga
        StringBuilder output = new StringBuilder();
        if(inputStream!=null){
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = reader.readLine();
                while (line!=null){
                    output.append(line);
                    line=reader.readLine();
                }
            }catch (IOException ioException){
                Toast.makeText(mContext,ioException.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        return output.toString();
    }

    private static URL createUrl(String url) {
        URL link = null;
        try {
            link = new URL(url);
        } catch (MalformedURLException urlException) {
            Toast.makeText(mContext, urlException.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return link;
    }


}
