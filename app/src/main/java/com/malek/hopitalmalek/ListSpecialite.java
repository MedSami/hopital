package com.malek.hopitalmalek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.malek.hopitalmalek.Adapter.MedecinAdapter;
import com.malek.hopitalmalek.Adapter.SpecialiteAdapter;
import com.malek.hopitalmalek.Api.ApiRequest;
import com.malek.hopitalmalek.Api.RetrofitServer;
import com.malek.hopitalmalek.Model.DataModel;
import com.malek.hopitalmalek.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSpecialite extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter specialiteAdapter;
    String idPatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_specialite);
        RecycleLayout = findViewById(R.id.recyclerview);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idPatient = data.getString("idPatient");


        }

        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> listSpecialite=api.getSpecialite();

        listSpecialite.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListSpecialite.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    specialiteAdapter = new SpecialiteAdapter(item, ListSpecialite.this,idPatient);

                    RecycleLayout.setAdapter(specialiteAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListSpecialite.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
