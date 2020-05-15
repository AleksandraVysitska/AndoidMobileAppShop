package com.example.negozio.fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.negozio.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class UtenteFragment extends Fragment {

    private TextView mEmail, mNome, mCognome;
    private Button mModifica;
    private ConstraintLayout mRoot;
    private String PREF_REGISTRAZIONE="prefRegistrazione";


    public UtenteFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utente2, container, false);
        SharedPreferences registrazione = getContext().getSharedPreferences(PREF_REGISTRAZIONE, Context.MODE_PRIVATE);
        mNome=view.findViewById(R.id.nomeUtente);
        mCognome=view.findViewById(R.id.cognomeUtente);
        mEmail=view.findViewById(R.id.emailUtente);
        mModifica = view.findViewById(R.id.modifica);
        mRoot = view.findViewById(R.id.rootLayout);
        mNome.setText(registrazione.getString("nome", null));
        mCognome.setText(registrazione.getString("cognome", null));
        mEmail.setText(registrazione.getString("email", null));
        /*if(registrazione.contains("eta")){
            mEta.setText(registrazione.getString("eta",null));
        }else{
            mEta.setVisibility(View.INVISIBLE);
        }
        if(registrazione.contains("telefono")){
            mTelefono.setText(registrazione.getString("telefono",null));
        }else{
            mTelefono.setVisibility(View.INVISIBLE);
        }*/
        boolean genre;
        if(registrazione.getString("genere",null).equals("m")){
            mRoot.setBackgroundColor(Color.parseColor("#D4F1F4"));
        }else{
            mRoot.setBackgroundColor(Color.parseColor("#75E6DA"));
        }
        return view;
    }

}
