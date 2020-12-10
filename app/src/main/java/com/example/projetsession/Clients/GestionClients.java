package com.example.projetsession.Clients;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.Button;
import android.widget.Toast;

import com.example.projetsession.Accueil.Accueil;
import com.example.projetsession.Location.GestionLocation;
import com.example.projetsession.Location.RechercheVoiture;
import com.example.projetsession.MapsActivity;
import com.example.projetsession.Objets.Client;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.Voitures.GestionVoitures;
import com.example.projetsession.Voitures.Liste_MesVoitures;
import com.example.projetsession.Voitures.ModifierVoiture;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class GestionClients extends AppCompatActivity  implements CreationCompte.InterfaceCreationCompte,
                                                                    ListeClients.InterfaceListe_Clients,
                                                                        ModificationCompte.InterfaceModifierCompte{
    RechercheVoiture fragRechercheVoiture;
    ListeClients fragListeClient;
    AccueilClient fragAccueilClient;
    CreationCompte fragCreationCompte;
    ModificationCompte fragModifCompte;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_client);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        bottomNavClient = findViewById(R.id.bnvClient);
        fragAccueilClient = new AccueilClient();
        fragCreationCompte = new CreationCompte();
        fragListeClient = new ListeClients();
        fragModifCompte = new ModificationCompte();
        fragRechercheVoiture = new RechercheVoiture();


        Intent intent = getIntent();
        String extraFragment;

        if(intent.hasExtra("FragmentDemande")){
            extraFragment = intent.getStringExtra("FragmentDemande");

           if(extraFragment.equals("CreationCompte")){
               fragmentManager = getSupportFragmentManager();
               fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.flFrag_GestClient, fragCreationCompte);
               fragmentTransaction.commit();
           }
            if(extraFragment.equals("AccueilClient")){
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.flFrag_GestClient, fragAccueilClient);
                fragmentTransaction.commit();
            }


        }

        bottomNavClient.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
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
                        Intent intent = new Intent(getApplicationContext(), GestionClients.class);
                        intent.putExtra("FragmentDemande", "AccueilClient");
                        startActivity(intent);
                        return true;

                    case R.id.mnRechVehicule:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flFrag_GestClient, fragRechercheVoiture);
                        fragmentTransaction.commit();
                        return true;
                }

                return false;

            }

        });

    }


  /* @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_gestvoiture, menu);
        return super.onCreateOptionsMenu(menu);
    }*/



   /* @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.findItem(R.id.mnListeClient).setVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }

*/
  /*
   @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch (menuItem.getItemId()){

            case R.id.mnListeClient:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestClient, fragListeClient);
                fragmentTransaction.commit();
                return true;



            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }*/












    public void Activite_GestVoit_ListeMesVoit(){
        Intent intent = new Intent(this, GestionVoitures.class);
        startActivity(intent);
    }



    public void CreerCompteClient(Client client){
        Singleton.getInstance().AjoutClient_ListeClient(client);
    }

    public void ModifierCompteClient(int index ,String _Nom, String _Prenom, String _NoTel, String _Email,
                                     String _MotDePasse, String _NoPermis, String _Carte_Credit){

        Singleton.getInstance().Modifier_ListeClients( index , _Nom,  _Prenom,  _NoTel,  _Email,
                 _MotDePasse,  _NoPermis,  _Carte_Credit);
    }


    public List<Client> CreerListeClients(){
        return Singleton.getInstance().getListeClients(this);
    }


}
