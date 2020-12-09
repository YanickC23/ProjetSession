package com.example.projetsession.retrofit;

import com.example.projetsession.Objets.Image;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    //url pour les fichiers php et autre
    public static final String BASE_URL = "http://10.0.2.2/images/" ; //"http://10.0.2.2/images" //http://206.167.140.56:8080/A2020/420505Ri/Equipe_11/Android/"
    //url pour les images
    public static final String BASE_URL_IMAGE = "http://206.167.140.56:8080/A2020/420505Ri/Equipe_11/";
    private static Retrofit retrofit;

    public static Retrofit getInstance(){

        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
