package com.example.projetsession.Location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.projetsession.Clients.AccueilClient;
import com.example.projetsession.Clients.CreationCompte;
import com.example.projetsession.Clients.ListeClients;
import com.example.projetsession.Clients.ModificationCompte;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class GestionLocation extends AppCompatActivity implements ListeVoitures.InterfaceListe_LocationVoiture{

    ListeVoitures fragListeVoitures;
    LouerVoiture fragLouerVoiture;
    RechercheVoiture fragRechercheVoiture;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavClient;

    List<Voiture> listeVoiture =  new ArrayList<Voiture>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionlocation);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        bottomNavClient = findViewById(R.id.bnvClient);
        fragListeVoitures = new ListeVoitures();
        fragLouerVoiture = new LouerVoiture();
        fragRechercheVoiture = new RechercheVoiture();



        Intent intent = getIntent();
        String extraFragment;

        if(intent.hasExtra("FragmentDemande")){
            extraFragment = intent.getStringExtra("FragmentDemande");

            if(extraFragment.equals("RechercheVoiture")){
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestLocation, fragRechercheVoiture);
                fragmentTransaction.commit();
            }


        }
    }

    public List<Voiture> CreerListeLocationVoitures(){

        return Singleton.getInstance().getListeVoitures();
    }
}
