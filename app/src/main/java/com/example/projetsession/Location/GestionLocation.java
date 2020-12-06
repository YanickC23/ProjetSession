package com.example.projetsession.Location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.projetsession.Accueil.Accueil;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.Voitures.GestionVoitures;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class GestionLocation extends AppCompatActivity implements ListeVoitures.InterfaceListe_LocationVoiture,
                                                                    RechercheVoiture.InterfaceRechercheVoiture{

    ListeVoitures fragListeVoitures;
    LouerVoiture fragLouerVoiture;
    RechercheVoiture fragRechercheVoiture;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavClient;
    BottomNavigationView bottomNavLocation;

    List<Voiture> listeVoiture =  new ArrayList<Voiture>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionlocation);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        bottomNavClient = findViewById(R.id.bnvClient);
        bottomNavLocation = findViewById(R.id.bnvLocation);
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
            if(extraFragment.equals("ListeVoiture")){
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestLocation, fragListeVoitures);
                fragmentTransaction.commit();
            }

        }




        bottomNavLocation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){

                Intent intentGestVoit = new Intent(getApplicationContext(), GestionVoitures.class);
                Intent intentGestLocation = new Intent(getApplicationContext(), GestionLocation.class);
                Intent intentAccueil = new Intent(getApplicationContext(), Accueil.class);

                switch (menuItem.getItemId()){


                    case R.id.mnAccueil:
                        intentAccueil.putExtra("FragmentDemande", "PageAccueil");
                        startActivity(intentAccueil);
                        return true;

                    case R.id.mnMeConnecter:
                        intentAccueil.putExtra("FragmentDemande", "PageLogin");
                        startActivity(intentAccueil);
                        return true;

                    case R.id.mnRechVehicule:
                        intentGestLocation.putExtra("FragmentDemande", "RechercheVoiture");
                        startActivity(intentGestLocation);
                        return true;

                    case R.id.mnListeVehicule:
                        intentGestLocation.putExtra("FragmentDemande", "ListeVoiture");
                        startActivity(intentGestLocation);
                        return true;

                    default:
                        return false;


                }
            }
        });

    }












    public List<Voiture> CreerListeLocationVoitures(){

        return Singleton.getInstance().getListeVoitures(this);
    }



    public void ChoixDateInf(){
        DialogFragment dialogFragment = new ChoixDateInf();
        dialogFragment.show(getSupportFragmentManager(), "choix_date");
    }

    public void ChoixDateSup(){
        DialogFragment dialogFragment = new ChoixDateSup();
        dialogFragment.show(getSupportFragmentManager(), "choix_date");
    }





}
