package com.malek.hopitalmalek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DemandeRendezVous extends AppCompatActivity {
Button btnNom,btnSpecialite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demande_rendez_vous);

    btnNom=findViewById(R.id.btnParNom);
    btnSpecialite=findViewById(R.id.btnSpecialite);

    btnSpecialite.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });

    btnNom.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            
        }
    });
    }
}
