package com.example.negozio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String mPwdRegistrazione, mEmailRegistrazione, pwdAccesso;
    private final static String PREF_REGISTRAZIONE = "prefRegistrazione", PREF_ACCESSO = "prefAccesso";
    private Button login, mRegistrazione, passwordDimenticata;
    private CheckBox ricorda;
    private Intent goToRegistrazione, goToLogin, goToPasswordDimenticata;
    private EditText mEmail, mPass;
    private TextView requiredEmail, requiredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences registrazione = getSharedPreferences(PREF_REGISTRAZIONE, MODE_PRIVATE);
        SharedPreferences accesso = getSharedPreferences(PREF_ACCESSO, MODE_PRIVATE);
        mPwdRegistrazione = "";
        mEmailRegistrazione = "";
        pwdAccesso = "";
        if (registrazione.contains("password")) {
            mPwdRegistrazione = registrazione.getString("password", null);
            mEmailRegistrazione = registrazione.getString("email", null);
        }
        if (accesso.contains("pwd")) {
            pwdAccesso = accesso.getString("pwd", null);
        }
        if (!mPwdRegistrazione.equals("") && !pwdAccesso.equals("")) {
            matchPwd(mPwdRegistrazione, pwdAccesso);
        } else {
            login = findViewById(R.id.login);
            mRegistrazione = findViewById(R.id.registrazione);
            passwordDimenticata = findViewById(R.id.passwordDimenticata);
            mEmail = findViewById(R.id.email);
            mPass = findViewById(R.id.pass);
            ricorda = findViewById(R.id.ricorda);
            requiredEmail=findViewById(R.id.reqEmail);
            requiredPassword=findViewById(R.id.reqPassword);

            final String user = "";
            mPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus != true && mPass.getText().toString().equals("")) {
                        requiredPassword.setText("Password richiesta");
                        requiredPassword.setTextColor(getResources().getColor(R.color.textError));
                    } else {
                        requiredPassword.setText(R.string.required);
                        requiredPassword.setTextColor(Color.parseColor("#333333"));
                    }
                }
            });
            mEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus != true && mEmail.getText().toString().equals("")) {
                        requiredEmail.setText("Email richiesta");
                        requiredEmail.setTextColor(getResources().getColor(R.color.textError));
                    } else {
                        requiredEmail.setText(R.string.required);
                        requiredEmail.setTextColor(Color.parseColor("#333333"));
                    }
                }
            });
            mRegistrazione.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToRegistrazione = new Intent(getApplicationContext(), Registrazione.class);
                    startActivity(goToRegistrazione);
                }
            });
            passwordDimenticata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToPasswordDimenticata = new Intent(getApplicationContext(), PasswordDimenticata.class);
                    startActivity(goToPasswordDimenticata);
                }
            });
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verifyAccess(mEmail.getText().toString(), mPass.getText().toString());
                }
            });

        }




  /* @Override
        protected void onResume () {
            super.onResume();
            mEmail.setText("");
            mPass.setText("");
        }*/
    }

    public void showAlert (String messaggio){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(messaggio).setTitle("Attenzione").create().show();
    }

    private void verifyAccess(String mail, String pwd) {
        if (mail.equals(mEmailRegistrazione) && pwd.equals(mPwdRegistrazione)) {
            if (ricorda.isChecked()) {
                SharedPreferences accesso = getBaseContext().getSharedPreferences("accessoUtente", MODE_PRIVATE);
                accesso.edit().putString("mail", mail).putString("pwd", pwd).commit();
            }
            goHome();
        } else if (mail.equals(mEmailRegistrazione) && !pwd.equals(mPwdRegistrazione)) {
            showAlert("Password errata!");
        } else if (!mail.equals(mEmailRegistrazione) && pwd.equals(mPwdRegistrazione)) {
            showAlert("Username sbagliato!");
        } else {
            showAlert("Credenziali errate!");
        }
    }

    public void goHome () {
        Intent home = new Intent(this, Home.class);
        startActivity(home);
    }


    private void matchPwd (String reg, String acc){
        if (acc.equals(reg)) {
            goHome();
        }
    }




       /* public void goToLogIn () {
        String email = "", password = "";
        email = mEmail.getText().toString();
        password = mPass.getText().toString();

        if (email.isEmpty() | password.isEmpty()) {
            showAlert("Mancano i dati");
        } else {
            if (password.length() < 8) {
                showAlert("Password incompleta");
            } else if (!email.contains("@") && !email.contains(".")) {
                showAlert("Email incompleta");
            } else {
                goToLogin = new Intent(this, Home.class);
                startActivity(goToLogin);
            }
        }
    }*/
}


