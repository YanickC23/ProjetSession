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

     //méthode non requise
    /*@GET("load_image.php")
    Call<List<Image>> getAllImage();*/

    @GET("voiture_load.php")
    Call<List<Voiture>> getAllVoiture();
    @GET("voiture_load_user.php")
    Call<List<Voiture>> getUserVoiture();
    @GET("voiture_changer.php")
    Call<List<Voiture>> changer_voiture();
    @GET("voiture_supprimer.php")
    Call<List<Voiture>> retirer_voiture();
    @GET("voiture_ajout.php")
    Call<List<Voiture>> nouvelle_voiture();


    @GET("client_load.php")
    Call<Client> getAllClient();

    @GET("user_conn.php")
    Call<Client> getConnectionInfo();
    @GET("user_new_user.php")
    Call<Client> créateAccount();
    @GET("user_changer_profil.php")
    Call<Client> changeProfil();
    @GET("user_changer_motdepasse.php")
    Call<Client> changePassword();












    /*@GET("/donnees")
    Call<List<Client>> getAllClientFromServer();

    @GET("/client.php")
    Call<Client> getClientFromServer();*/


















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
