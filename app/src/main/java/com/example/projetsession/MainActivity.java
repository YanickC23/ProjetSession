package com.example.projetsession;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

        if(verifierPermissions())
        {
            lancerProgramme();
        }


        liste = new ArrayList<Client>();
        //remplirListe();
        //getUtilisateur();
        //getUtilisateurById();

    }

    private void lancerProgramme() {
    }

    public boolean verifierPermissions()
    {
        String[] permissions = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};

        List<String> listePermissionsADemander = new ArrayList<>();

        for(int i=0; i< permissions.length; i++)
        {
            if(ContextCompat.checkSelfPermission(this,permissions[i]) != PackageManager.PERMISSION_GRANTED)
            {
                listePermissionsADemander.add(permissions[i]);
            }
        }

        if(listePermissionsADemander.isEmpty())
            return true;
        else
        {
            ActivityCompat.requestPermissions(this, listePermissionsADemander.toArray(new String[listePermissionsADemander.size()]),1111 );

            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        int nbPermissionsRefusees = 0;

        for(int i = 0; i<grantResults.length; i++ )
        {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                nbPermissionsRefusees++;
            }
        }

        //s'il y a des persmissions qui ne sont pas accordées on l'indique à l'utilisateur
        //sinon si toutes les permissions sont accordées, on peut rouler le programme
        if(nbPermissionsRefusees > 0)
            Toast.makeText(this, "Veuillez accepter les permissions", Toast.LENGTH_LONG).show();
        else
            lancerProgramme();

    }



    public void remplirListe() {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<List<Client>> call = serveur.getAllClientFromServer();

        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                liste = response.body();
                Log.d("response",liste.get(0).id_client + " " + liste.get(0).getNom());
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

