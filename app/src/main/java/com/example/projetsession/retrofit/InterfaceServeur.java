package com.example.projetsession.retrofit;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Image;
import com.example.projetsession.Objets.Voiture;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceServeur {


    @GET("load_image.php")
    Call<List<Image>> getAllImage();

    @GET("load_voiture.php")
    Call<List<Voiture>> getAllVoiture();

    @GET("/donnees")
    Call<List<Client>> getAllClientFromServer();

    @GET("/client.php")
    Call<Client> getClientFromServer();

    @GET("/client.php")
    Call<List<Client>> getClientvBisFromServer();

    @POST("/client.php")
    @FormUrlEncoded
    Call<Client> getClientByIdFromServer(@Field("index") int i);

    @GET("/donnees")
    Call<List<Voiture>> getAllVoitureFromServer();

    @GET("/voiture.php")
    Call<Voiture> getVoitureFromServer();

    @GET("/voiture.php")
    Call<List<Voiture>> getVoituresBisFromServer();

    @POST("/voiture.php")
    @FormUrlEncoded
    Call<Voiture> getVoitureByIdFromServer(@Field("index") int i);

}
