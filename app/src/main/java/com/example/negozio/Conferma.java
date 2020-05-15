package com.example.negozio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Conferma extends AppCompatActivity {

    private Button login;
    private Intent goToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferma);

        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });

    }
    public void goToMain (){
        goToMainActivity = new Intent(this, MainActivity.class);
        startActivity(goToMainActivity);
    }
}
