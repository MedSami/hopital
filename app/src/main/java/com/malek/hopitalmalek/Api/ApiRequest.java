package com.malek.hopitalmalek.Api;

import com.malek.hopitalmalek.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {
    /******************** Authentification Login*******************/
    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("cin") String cin);

    /*************** Inscrire patient *******************/
    @FormUrlEncoded
    @POST("Inscrire.php")
    Call<ResponseDataModel> Inscrire(
            @Field("nom") String nom,
            @Field("prenom") String prenom,
            @Field("cin") String cin,
            @Field("password") String password
    );

    /******************** All medecins*******************/
    @GET("AllMedecins.php")
    Call<ResponseDataModel> getMedecins();
  /******************** All Specialite*******************/
    @GET("AllSpecialite.php")
    Call<ResponseDataModel> getSpecialite();

    /*************** Rendez vous *******************/
    @FormUrlEncoded
    @POST("AffecterRendezVous.php")
    Call<ResponseDataModel> RendezVous(
            @Field("id_patient") String id_patient,
            @Field("id_medecin") String id_medecin,
            @Field("choix") String choix,
            @Field("date") String date
    );

}
