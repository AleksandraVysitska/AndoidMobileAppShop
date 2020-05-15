package com.example.negozio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class PasswordDimenticata extends AppCompatActivity {

    private Button invia;
    private Intent send;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_dimenticata);

        invia=findViewById(R.id.recuperoPassword);
        email=findViewById(R.id.editEmail);

        invia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInvia();
            }
        });

    }


        private void goToInvia() {
            String mail, pass;
            mail=email.getText().toString();
            if (!mail.contains ("@") && !mail.contains(".")) {
                showAlert("Email incompleta");
            } else {
                send = new Intent(this, Conferma.class);
                startActivity(send);
            }
        }

            public void showAlert (String messaggio){
                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                alert.setMessage(messaggio).setTitle("Attenzione").create().show();
            }

}
