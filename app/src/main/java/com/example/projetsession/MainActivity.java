package com.example.projetsession;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Client> liste;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = new ArrayList<Client>();
        remplirListe();
        //getUtilisateur();
        //getUtilisateurById();

    }
    public void remplirListe() {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<List<Client>> call = serveur.getAllClientFromServer();

        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                liste = response.body();
                Log.d("response",liste.get(0).id + " " + liste.get(0).getNom());
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.d("response",t.getMessage());
            }
        });
    }

    public void getUtilisateur(){

        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<Client> call = serveur.getClientFromServer();

        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                client = response.body();
                Log.d("response",client.getNom() + " " + client.getPrenom());
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.d("response",t.getMessage());
            }
        });
    }

  /*  public void getUtilisateurById() {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<Client> call = RetrofitService.getService().getUtilisateurById(1);

        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                client = response.body();
                Log.d("response",client.getNom() + " " + client.getPrenom());
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.d("response",t.getMessage());
            }
        });*/


}

