package com.example.projetsession.retrofit;

import com.example.projetsession.Objets.Image;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static final String BASE_URL = "http://10.0.2.2/images/";   //"http://206.167.140.56/Cours/A2020/420505RI/Equipe_11/"; //http://206.167.140.56/Equipe_11/  //http://10.0.2.2/images/
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
