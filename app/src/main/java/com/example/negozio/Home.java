package com.example.negozio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.negozio.fragment.CarrelloFragment;
import com.example.negozio.fragment.HomeFragment;
import com.example.negozio.fragment.OfferteFragment;
import com.example.negozio.fragment.UtenteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView=findViewById(R.id.bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selected = new Fragment();

                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        selected=new HomeFragment();
                        break;

                    case R.id.menu_carrello:
                        selected=new CarrelloFragment();
                        break;

                    case R.id.menu_offerte:
                        selected=new OfferteFragment();
                        break;

                    case R.id.menu_profilo:
                        selected=new UtenteFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.menu_home);

    }


}
