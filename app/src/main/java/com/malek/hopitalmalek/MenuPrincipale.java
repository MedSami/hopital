package com.malek.hopitalmalek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipale extends AppCompatActivity {
Button btnDemandeRendezVous,btnConsulterMsg;
String idPatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principale);

    btnDemandeRendezVous=findViewById(R.id.btnDemande);
    btnConsulterMsg=findViewById(R.id.btnMessage);


        Bundle data = getIntent().getExtras();
        if (data != null) {
            idPatient = data.getString("idPatient");


        }
btnConsulterMsg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MenuPrincipale.this,ListRDV.class);
        intent.putExtra("idPatient",idPatient);
        startActivity(intent);
    }
});
btnDemandeRendezVous.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MenuPrincipale.this,RendezVous.class);
        intent.putExtra("idPatient",idPatient);
        startActivity(intent);
    }
});
    }
}
