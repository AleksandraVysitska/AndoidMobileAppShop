package com.example.negozio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Registrazione extends AppCompatActivity {

        private String PREF_REGISTRAZIONE="prefRegistrazione";
        private TextView mReqGenere, mReqNome, mReqCognome, mReqEmail, mReqPassword;
        private EditText editNome, editCognome, editEmail, editPassword;
        private Button button;
        private RadioButton mM, mF;
        private String mEmail, mPwd;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registrazione);

            editNome=findViewById(R.id.editNome);
            mReqNome=findViewById(R.id.reqNome);
            editNome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus && editNome.getText().toString().equals("")){
                        mReqNome.setText("Nome richiesto!");
                        mReqNome.setTextColor(Color.parseColor("#333333"));
                    }
                }
            });
            editCognome=findViewById(R.id.editCognome);
            mReqCognome=findViewById(R.id.reqCognome);
            editCognome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus && editCognome.getText().toString().equals("")){
                        mReqCognome.setText("Cognome richiesto!");
                        mReqCognome.setTextColor(Color.parseColor("#333333"));
                    }
                }
            });
            editEmail=findViewById(R.id.editEmail);
            mReqEmail=findViewById(R.id.reqEmail);
            editEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus && editEmail.getText().toString().equals("")){
                        mReqEmail.setText("Email richiesta!");
                        mReqEmail.setTextColor(Color.parseColor("#333333"));
                    }
                }
            });
            editPassword=findViewById(R.id.editPassword);
            mReqPassword=findViewById(R.id.reqPassword);
            editPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    mReqPassword.setText("Password richiestsa!");
                    mReqPassword.setTextColor(Color.parseColor("#333333"));
                }
            });
            mReqGenere=findViewById(R.id.reqGenere);
            mM=findViewById(R.id.m);
            mF=findViewById(R.id.f);
            button=findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verificaRegistrazione();
                }
            });
        }

        @Override
        protected void onResume(){
            super.onResume();
            editNome.setText("");
            editCognome.setText("");
            editEmail.setText("");
            editPassword.setText("");
        }

        private void verificaRegistrazione(){
            String nome, cognome, email, password, genere="";
            nome=editNome.getText().toString();
            cognome=editCognome.getText().toString();
            email=editEmail.getText().toString();
            password=editPassword.getText().toString();
            if (mM.isChecked()){
                genere = "m";
            }else if(mF.isChecked()){
                genere="f";
            }else if(!mM.isChecked()&&!mF.isChecked()){
                mReqGenere.setText("Genere richiesto!");
                mReqGenere.setTextColor(getResources().getColor(R.color.textError));
            }

            if(!cognome.equals("") && !password.equals("") && !nome.equals("") && !email.equals("")){
               SharedPreferences preferences=getBaseContext().getSharedPreferences(PREF_REGISTRAZIONE, MODE_PRIVATE);
                preferences.edit().putString("nome", nome)
                        .putString("cognome", cognome)
                        .putString("password", password)
                        .putString("email", email)
                        .putString("genere", genere).commit();
                /*if(telefono!=""){
                    preferences.edit().putString("telefono", telefono).commit();
                }
                if(eta!=""){
                    preferences.edit().putString("eta", eta).commit();
                }
                 */
                mostraAlert(email, password);
            }
        }

        private void mostraAlert(final String email, final String pwd){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            View alertView = LayoutInflater.from(this).inflate(R.layout.alert_registrazione, null);
            Button si,no;
            si=alertView.findViewById(R.id.si);
            no=alertView.findViewById(R.id.no);
            alert.setView(alertView)
                    .create()
                    .show();
            si.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences accesso = getBaseContext().getSharedPreferences("accessoUtente",MODE_PRIVATE);
                    accesso.edit().putString("email", email)
                            .putString("pwd",pwd).commit();
                    goToHome();
                }
            });

            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToLogin();
                }
            });
        }

        private void  goToHome (){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }

        private void goToLogin(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
}


        /*public void button (View view){
            String nome, cognome, email, password;
            nome=editNome.getText().toString();
            cognome=editCognome.getText().toString();
            email=editEmail.getText().toString();
            password=editPassword.getText().toString();

            if (nome.isEmpty()||cognome.isEmpty()||email.isEmpty()||password.isEmpty()){
                showAlert("mancano i dati");
            }else{
                if(password.length()>=8){
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    showAlert("Password incomleta");
                }
            }


        }

        public void showAlert (String messaggio){
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setMessage(messaggio).setTitle("Attenzione").create().show();
        }*/