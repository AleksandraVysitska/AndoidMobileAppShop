package com.example.negozio.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.negozio.CapiAbbigliamento;
import com.example.negozio.LoaderNegozio;
import com.example.negozio.R;
import com.example.negozio.TransformerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransformerFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<CapiAbbigliamento>> {

    public TransformerFragment(int prova) {

    }

    private RecyclerView mRV;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transformer, container, false);

        mRV=view.findViewById(R.id.r_capi);
        mRV.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getContext());
        mRV.setLayoutManager(layoutManager);

        LoaderManager loaderManager=getLoaderManager();
        loaderManager.initLoader(1,null,this);

        adapter=new TransformerAdapter(new ArrayList());
        mRV.setAdapter(adapter);

        return view;
    }

    @NonNull
    @Override
    public Loader<ArrayList<CapiAbbigliamento>> onCreateLoader(int id, @Nullable Bundle args) {
        //bisogna passargli URL e creare loader e passargli URL

        String url = "https://78.47.166.184:8000/search?";
        LoaderNegozio loaderNegozio = new LoaderNegozio(getContext(), url);
        return loaderNegozio;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<CapiAbbigliamento>> loader, ArrayList<CapiAbbigliamento> data) {
        if(data!=null){
            adapter=new TransformerAdapter(data);
            mRV.setAdapter(adapter);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<CapiAbbigliamento>> loader) {

    }
}
