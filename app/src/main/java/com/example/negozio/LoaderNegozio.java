package com.example.negozio;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class LoaderNegozio extends AsyncTaskLoader <ArrayList<CapiAbbigliamento>>{
    private String mUrl;
    private Context mContext;

    public LoaderNegozio(@NonNull Context context, String url){
        super(context);
        mUrl=url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public ArrayList<CapiAbbigliamento> loadInBackground() {
        //esegue la connessione passando url
        if (mUrl==null){
            return null;
        }
        ArrayList<CapiAbbigliamento> listaCapi = Network.connection(mUrl, mContext);
        return listaCapi;
    }
}
