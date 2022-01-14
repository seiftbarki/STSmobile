package com.example.stsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inscription extends AppCompatActivity {
    private DatabaseHelper db;
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    Button btn_enregistrement,annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        e1=findViewById(R.id.cin);
        e2=findViewById(R.id.np);
        e3=findViewById(R.id.tel);
        e4=findViewById(R.id.adresse);
        e5=findViewById(R.id.mail);
        e6=findViewById(R.id.login);
        e7=findViewById(R.id.pwd);
        e8=findViewById(R.id.cpwd);
        btn_enregistrement=findViewById(R.id.btn_inscri2);
        db=new DatabaseHelper(this);
        btn_enregistrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cin=e1.getText().toString();
                String nompren=e2.getText().toString();
                String phone=e3.getText().toString();
                String adresse=e4.getText().toString();
                String email=e5.getText().toString();
                String login=e6.getText().toString();
                String password=e7.getText().toString();
                String cpassword=e8.getText().toString();
                if(cin.equals("")||nompren.equals("")||phone.equals("")||adresse.equals("")||email.equals("")||login.equals("")) {
                    Toast.makeText(inscription.this, "champ vide", Toast.LENGTH_LONG).show();}

                else {
                        if (cpassword.equals(password)) {
                            Toast.makeText(inscription.this, "inscription avec succes", Toast.LENGTH_LONG).show();
                            abonne a = new abonne(cin, nompren, phone, adresse, email, login, password);
                            db.addStudent(a);
                            Intent i = new Intent(inscription.this, authentification.class);
                            startActivity(i);
                        } else
                            Toast.makeText(inscription.this, "verifier votre password", Toast.LENGTH_LONG).show();

                    }

            }
        });
        annuler=findViewById(R.id.b2);
        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(inscription.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}