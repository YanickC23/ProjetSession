package com.example.projetsession.retrofit;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Image;
import com.example.projetsession.Objets.Voiture;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface InterfaceServeur {

    @Multipart
    @POST("/serveur.php")
    Call<ResponseBody> upload(
            @Part("requete") RequestBody requete,
            @Part MultipartBody.Part image
    );


     //méthode non requise
    /*@GET("load_image.php")
    Call<List<Image>> getAllImage();*/

    /*@Multipart
    @POST("images")
    Call<ServerResponse> uploadImage(@Part MultipartBody.Part image);
*/
    @Multipart
    @POST("images")
    Call<ResponseBody> uploadImage(@Part("description") RequestBody description, @Part MultipartBody.Part image);


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
