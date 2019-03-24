package com.malek.hopitalmalek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.malek.hopitalmalek.Api.ApiRequest;
import com.malek.hopitalmalek.Api.RetrofitServer;
import com.malek.hopitalmalek.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AffecterRDV extends AppCompatActivity {
String idPatient,choix,idMedecin;
EditText date;
Button btnAffecterRDV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affecter_rdv);
        date=findViewById(R.id.edtdate);
        btnAffecterRDV=findViewById(R.id.btnAffecterRDV);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idPatient = data.getString("idPatient");
            idMedecin = data.getString("idMedecin");
            choix = data.getString("choix");


        }

        btnAffecterRDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(date.getText().toString().equals("")){
                    Toast.makeText(AffecterRDV.this, "Merci de remplir champ Date Rendez Vous :) ", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                    //Instance Call Methode
                    Call<ResponseDataModel> RDV=api.RendezVous(idPatient,idMedecin,choix,date.getText().toString());

                RDV.enqueue(new Callback<ResponseDataModel>() {
                    @Override
                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                        Toast.makeText(AffecterRDV.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                        Toast.makeText(AffecterRDV.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                    }
                });
                }
            }
        });
    }
}
