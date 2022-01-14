package com.example.stsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stsproject.view.MoyenTransport;

public class authentification extends AppCompatActivity {
    private DatabaseHelper db;
    EditText t1,t2;
    Button cnx,annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        t1=findViewById(R.id.login);
        t2=findViewById(R.id.pwd);
        cnx=findViewById(R.id.b1);
        annuler=findViewById(R.id.b2);
        db=new DatabaseHelper(this);
        cnx.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
             String user=t1.getText().toString();
             String pass=t2.getText().toString();
             if (user.equals("")||pass.equals(""))
                 Toast.makeText(authentification.this,"champs vide",Toast.LENGTH_LONG).show();
             else{
                 Boolean checkuserpass=db.checkusernamepassword(user,pass);
                 if(checkuserpass==true){
                     Toast.makeText(authentification.this,"connexion réussie",Toast.LENGTH_LONG).show();
                     Intent i=new Intent(authentification.this, evaluation.class);
                     startActivity(i);
                 }
                 else{
                     Toast.makeText(authentification.this,"les informations d'identification invalides",Toast.LENGTH_LONG).show();
                 }
             }

            }

        });
        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(authentification.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}