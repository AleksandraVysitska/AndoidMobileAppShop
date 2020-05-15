package com.example.negozio.fragment;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.negozio.HomeAdapter;
import com.example.negozio.HomeModel;
import com.example.negozio.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerUomo, recyclerDonna, recyclerBimbo;
            private RecyclerView.Adapter adapter, adapterD, adapterB;
    private RecyclerView.LayoutManager layoutManagerUomo, layoutManagerDonna, layoutManagerBimbo;
    private int [] categorieImg={R.drawable.ic_t_shirt,R.drawable.ic_chemise,R.drawable.ic_jumper,R.drawable.ic_pants,
            R.drawable.ic_shoe,R.drawable.ic_suit,R.drawable.ic_accessori,R.drawable.ic_underwear};
    private int [] categorieStringhe={R.string.tshirt,R.string.camicia,R.string.felpe,R.string.pantaloni,
            R.string.scarpe,R.string.giacche,R.string.accessori,R.string.intimo};
    private int [] catImgDonne={R.drawable.ic_blouse, R.drawable.ic_skirt, R.drawable.ic_pants,
            R.drawable.ic_dress, R.drawable.ic_scarpe_donna, R.drawable.ic_pointing, R.drawable.ic_purse, R.drawable.ic_undies};
    private int [] catStrDonne={R.string.maglie,R.string.gonne,R.string.pantaloni,R.string.abiti,
            R.string.scarpe,R.string.cappotti,R.string.accessori,R.string.intimo};
    private int [] catImgBimbi={R.drawable.ic_t_shirt,R.drawable.ic_pants,R.drawable.ic_skirt,R.drawable.ic_dress,
            R.drawable.ic_snowsuit,R.drawable.ic_scarpine,R.drawable.ic_pink_acc,R.drawable.ic_pink_intimo};
    private int [] catStrBimbi={R.string.tshirt,R.string.pantaloni,R.string.gonne,R.string.abiti,R.string.giacche,
            R.string.scarpe,R.string.accessori,R.string.intimo};
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerUomo = view.findViewById(R.id.r_uomini);
        recyclerDonna= view.findViewById(R.id.r_donne);
        recyclerBimbo= view.findViewById(R.id.r_bimbi);

        recyclerUomo.setHasFixedSize(true);
        recyclerDonna.setHasFixedSize(true);
        recyclerBimbo.setHasFixedSize(true);

        layoutManagerUomo = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerDonna= new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerBimbo= new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerUomo.setLayoutManager(layoutManagerUomo);
        recyclerDonna.setLayoutManager(layoutManagerDonna);
        recyclerBimbo.setLayoutManager(layoutManagerBimbo);


        final ArrayList<HomeModel> modelList= new ArrayList<>();
        for(int i=0;i<categorieImg.length;i++){
            HomeModel model=new HomeModel(categorieImg[i], categorieStringhe[i]);
                    modelList.add(model);
        }

        ArrayList<HomeModel> modelListD= new ArrayList<>();
        for(int i=0;i<catImgDonne.length;i++){
            HomeModel model=new HomeModel(catImgDonne[i], catStrDonne[i]);
            modelListD.add(model);
        }

        ArrayList<HomeModel> modelListB= new ArrayList<>();
        for(int i=0;i<catImgBimbi.length;i++){
            HomeModel model=new HomeModel(catImgBimbi[i], catStrBimbi[i]);
            modelListB.add(model);
        }

        HomeAdapter adapter = new HomeAdapter(modelList, getContext(),recyclerUomo, getFragmentManager());
        recyclerUomo.setAdapter(adapter);

        HomeAdapter adapterD=new HomeAdapter(modelListD, getContext(),recyclerDonna, getFragmentManager());
        recyclerDonna.setAdapter(adapterD);

        HomeAdapter adapterB=new HomeAdapter(modelListB, getContext(),recyclerBimbo, getFragmentManager());
        recyclerBimbo.setAdapter(adapterB);

        return view;
    }
}
