package com.example.projetsession.Location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Adapter;

import com.example.projetsession.Accueil.Accueil;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
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
            if(extraFragment.equals("ListeVoiture")){
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestLocation, fragListeVoitures);
                fragmentTransaction.commit();
            }

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_location, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Adapter_Toute_Voiture adapter_toute_voiture = new Adapter_Toute_Voiture();
                //fragListeVoitures.adapter_toute_voiture.getFilter().filter(newText);
                adapter_toute_voiture.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.findItem(R.id.mnAccueil).setVisible(true);
        menu.findItem(R.id.mnMeConnecter).setVisible(true);
        menu.findItem(R.id.mnRechVehicule).setVisible(true);
        menu.findItem(R.id.mnListeVehicule).setVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        Intent intent = new Intent(this, Accueil.class);
        switch (menuItem.getItemId()){


            case R.id.mnAccueil:
                intent.putExtra("FragmentDemande", "PageAccueil");
                startActivity(intent);
                return true;

            case R.id.mnMeConnecter:
                intent.putExtra("FragmentDemande", "PageLogin");
                startActivity(intent);
                return true;

            case R.id.mnRechVehicule:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragRechercheVoiture);
                fragmentTransaction.commit();
                return true;

            case R.id.mnListeVehicule:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragListeVoitures);
                fragmentTransaction.commit();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);


        }
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
