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

public class Inscrire extends AppCompatActivity {
EditText edtNom,edtPrenom,edtCin,edtPassword;
Button btnInscrire,btnAnnuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrire);
    edtNom=findViewById(R.id.edtNom);
    edtPrenom=findViewById(R.id.edtPrenom);
    edtCin=findViewById(R.id.edtCin);
    edtPassword=findViewById(R.id.edtPassword);
    btnAnnuler=findViewById(R.id.btnAnnuler);
    btnInscrire=findViewById(R.id.btnInscrire);

    btnAnnuler.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            edtNom.setText("");
            edtPrenom.setText("");
            edtCin.setText("");
            edtPassword.setText("");
        }
    });

    btnInscrire.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(edtNom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Nom SVP", Toast.LENGTH_SHORT).show();
            }else if(edtPrenom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Preom SVP", Toast.LENGTH_SHORT).show();
            }else if(edtCin.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre CIN SVP", Toast.LENGTH_SHORT).show();
            }else if(edtPassword.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Mot De Passe SVP", Toast.LENGTH_SHORT).show();
            }else {
                ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                //Instance Call Methode
                Call<ResponseDataModel> Inscrire=api.Inscrire(edtNom.getText().toString(),
                        edtPrenom.getText().toString(),edtCin.getText().toString()
                ,edtPassword.getText().toString());

            Inscrire.enqueue(new Callback<ResponseDataModel>() {
                @Override
                public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                    Toast.makeText(Inscrire.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                    Toast.makeText(Inscrire.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                }
            });
            }
        }
    });
    }
}
