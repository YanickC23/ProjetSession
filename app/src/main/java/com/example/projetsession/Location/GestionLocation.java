package com.example.projetsession.Location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.projetsession.Accueil.Accueil;
import com.example.projetsession.Clients.GestionClients;
import com.example.projetsession.MapsActivity;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.Voitures.GestionVoitures;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GestionLocation extends AppCompatActivity
        implements ListeVoitures.InterfaceListe_LocationVoiture,
        RechercheVoiture.InterfaceRechercheVoiture,
SearchView.OnQueryTextListener{

    ListeVoitures fragListeVoitures;
    LouerVoiture fragLouerVoiture;
    RechercheVoiture fragRechercheVoiture;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavLocation;

    List<Voiture> listeVoiture =  new ArrayList<Voiture>();

    private RecyclerView rvListedesvoitres;
    public Adapter_Toute_Voiture adapter_toute_voiture;
    public List<Voiture> marques = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionlocation);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        bottomNavLocation = findViewById(R.id.bnvLocation);
        fragListeVoitures = new ListeVoitures();
        fragLouerVoiture = new LouerVoiture();
        fragRechercheVoiture = new RechercheVoiture();

        configView();
        remplirListeVoiture();


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
                Intent AccueilIntent = new Intent(getApplicationContext(), Accueil.class);

                switch (menuItem.getItemId()){

                    /*case R.id.mnMonProfil:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFrag_GestClient, fragModifCompte);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.mnListeClient:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFrag_GestClient, fragListeClient);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.mnOffrirLocation:
                        intentGestVoit.putExtra("FragmentDemande", "OffrirLocation");
                        startActivity(intentGestVoit);
                        return true;

                    case R.id.mnMesAuto:
                        intentGestVoit.putExtra("FragmentDemande", "ListeMesVoitures");
                        startActivity(intentGestVoit);
                        return true;

                    case R.id.mnLouer:
                        intentGestLocation.putExtra("FragmentDemande", "RechercheVoiture");
                        startActivity(intentGestLocation);
                        return true;*/

                    case R.id.mnAccueil:
                        AccueilIntent.putExtra("FragmentDemande", "PageAccueil");
                        startActivity(AccueilIntent);
                        return true;

                    case R.id.mnGooglemap:
                        Intent MapIntent = new Intent(getApplicationContext(), MapsActivity.class);
                        startActivity(MapIntent);
                        return true;

                    case R.id.mnlogin:
                        AccueilIntent.putExtra("FragmentDemande", "PageLogin");
                        startActivity(AccueilIntent);
                        return true;

                    case R.id.mnProfil:
                        Intent intent = new Intent(getApplicationContext(), GestionLocation.class);
                        intent.putExtra("FragmentDemande", "AccueilClient");
                        startActivity(intent);
                        return true;

                    case R.id.mnRechVehicule:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFrag_GestLocation, fragRechercheVoiture);
                        fragmentTransaction.commit();
                        return true;
                }

                return false;

            }

        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_location, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);

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




    public void configView(){
        rvListedesvoitres = (RecyclerView) findViewById(R.id.rvLocation);
        rvListedesvoitres.setHasFixedSize(true);
        rvListedesvoitres.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        rvListedesvoitres.setLayoutManager(new LinearLayoutManager(this));
        adapter_toute_voiture = new Adapter_Toute_Voiture(marques);
        rvListedesvoitres.setAdapter(adapter_toute_voiture);
    }


    public void remplirListeVoiture(){
        InterfaceServeur interfaceServeur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<List<Voiture>> call = interfaceServeur.getAllVoiture();

        call.enqueue(new Callback<List<Voiture>>() {
            @Override
            public void onResponse(Call<List<Voiture>> call, Response<List<Voiture>> response) {

                if (response.isSuccessful()) {
                    List<Voiture> listVoiture = response.body();

                    for (int i = 0; i < listVoiture.size(); i++) {
                        Voiture voiture = listVoiture.get(i);
                        //Toast.makeText(getContext(),"" + response.body().get(i),Toast.LENGTH_LONG).show();
                        adapter_toute_voiture.ajouterVoiture(voiture);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Voiture>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter_toute_voiture.notifyDataSetChanged();
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String userInput = newText.toLowerCase();
        List<Voiture> newList = new ArrayList<>();
        String text;
        for(Voiture marque : marques ){
                text = marque.getMarque().toString();
              if(text.toLowerCase().contains(userInput)){
                  newList.add(marque);
              }
        }
        adapter_toute_voiture.updateList(newList);
        return true;
    }
/*
      Voiture voitureData;
           public Voiture GetAfficherLocationVoitureData(){
                return voitureData;
           }

           public void SetAfficherLocationVoitureData(Voiture voiture){
                this.voitureData = voiture;
           }*/


}
