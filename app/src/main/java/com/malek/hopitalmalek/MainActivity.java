package com.malek.hopitalmalek;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
EditText edtCin,edtMotDePasse;
Button btnInscrire,btnEntrer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCin=findViewById(R.id.edtCin);
        edtMotDePasse=findViewById(R.id.edtPassword);
        btnEntrer=findViewById(R.id.btnEntrer);
        btnInscrire=findViewById(R.id.btnInscrire);

    btnInscrire.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,Inscrire.class);
            startActivity(intent);
        }
    });

    btnEntrer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(edtCin.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Saisir votre CIN SVP", Toast.LENGTH_SHORT).show();
            }else if(edtMotDePasse.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Saisir Votre Mot De Passe SVP", Toast.LENGTH_SHORT).show();
            }else {
                ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                //Instance Call Methode
                Call<ResponseDataModel> Login=api.Login(edtCin.getText().toString());
                Login.enqueue(new Callback<ResponseDataModel>() {
                    @Override
                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {

                            if(response.isSuccessful()){
                                if(!response.body().getResult().isEmpty()){
                                if(response.body().getResult().get(0).getCin().equals(edtCin.getText().toString())){
                                    if(response.body().getResult().get(0).getMotDePasse().equals(edtMotDePasse.getText().toString())){

                                        Intent intent=new Intent(MainActivity.this,MenuPrincipale.class);
                                        intent.putExtra("idPatient",""+response.body().getResult().get(0).getId());
                                        startActivity(intent);

                                    }else {
                                        Toast.makeText(MainActivity.this, "Mot De Passe Incorrect", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(MainActivity.this, "CIN Incorrect", Toast.LENGTH_SHORT).show();

                                }}else {
                                    Toast.makeText(MainActivity.this, "CIN Incorrect", Toast.LENGTH_SHORT).show();

                                }
                            }else {
                                Toast.makeText(MainActivity.this, "CIN Incorrect", Toast.LENGTH_SHORT).show();
                            }

                    }

                    @Override
                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    });
    }
}
