package com.malek.hopitalmalek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RendezVous extends AppCompatActivity {
String idPatient;
Button btnParNom,btnParSpecialite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);
        btnParNom=findViewById(R.id.btnParNom);
        btnParSpecialite=findViewById(R.id.btnParSpecialite);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            idPatient = data.getString("idPatient");


        }

        btnParSpecialite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RendezVous.this,ListSpecialite.class);
                i.putExtra("idPatient",idPatient);
                startActivity(i);
            }
        });

        btnParNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RendezVous.this,ListMedecin.class);
                i.putExtra("idPatient",idPatient);
                startActivity(i);
            }
        });
    }
}
