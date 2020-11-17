package com.example.projetsession.Clients;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.Voitures.GestionVoitures;
import com.example.projetsession.Voitures.Liste_MesVoitures;
import com.example.projetsession.Voitures.ModifierVoiture;

import java.util.List;

public class GestionClients extends AppCompatActivity  implements CreationCompte.InterfaceCreationCompte,
                                                                    ListeClients.InterfaceListe_Clients,
                                                                        ModificationCompte.InterfaceModifierCompte{

    ListeClients fragListeClient;
    AccueilClient fragAccueilClient;
    CreationCompte fragCreationCompte;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_client);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        fragAccueilClient = new AccueilClient();
        fragCreationCompte = new CreationCompte();
        fragListeClient = new ListeClients();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flFrag_GestClient, fragAccueilClient);
        fragmentTransaction.commit();


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
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_gestvoiture, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.findItem(R.id.mnListeClient).setVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }


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
    }












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
        return Singleton.getInstance().getListeClients();
    }


}
