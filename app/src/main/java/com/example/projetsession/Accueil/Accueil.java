package com.example.projetsession.Accueil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.projetsession.Location.GestionLocation;
import com.example.projetsession.R;
import com.example.projetsession.Voitures.GestionVoitures;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Accueil extends AppCompatActivity implements Login.InterfaceLogin, PageAccueil.InterfacePageAccueil{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Login fragLogin;
    PageAccueil fragPageAccueil;
    BottomNavigationView bottomNavAccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        fragPageAccueil = new PageAccueil();
        fragLogin = new Login();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flFragAccueil, fragPageAccueil);
        fragmentTransaction.commit();
        bottomNavAccueil = findViewById(R.id.bnvAccueil);




        Intent intent = getIntent();
        String extraFragment;

        if(intent.hasExtra("FragmentDemande")){

            extraFragment = intent.getStringExtra("FragmentDemande");

            if(extraFragment.equals("PageAccueil")){
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFragAccueil, fragPageAccueil);
                fragmentTransaction.commit();
            }

            if(extraFragment.equals("PageLogin")){
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFragAccueil, fragLogin);
                fragmentTransaction.commit();
            }
        }



        bottomNavAccueil.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
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

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_gestvoiture, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.findItem(R.id.mnAjoutVoiture).setVisible(true);
        menu.findItem(R.id.mnListeVoiture).setVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        Intent intentGestVoit = new Intent(getApplicationContext(), GestionVoitures.class);
        Intent intentGestLocation = new Intent(getApplicationContext(), GestionLocation.class);
        Intent intentAccueil = new Intent(getApplicationContext(), GestionVoitures.class);

        switch (menuItem.getItemId()){

            case R.id.mnAccueil:
                intentAccueil.putExtra("FragmentDemande", "PageAccueil");
                startActivity(intentGestVoit);
                return true;

            case R.id.mnMeConnecter:
                intentAccueil.putExtra("FragmentDemande", "PageLogin");
                startActivity(intentGestVoit);
                return true;

            case R.id.mnRechVehicule:
                intentGestLocation.putExtra("FragmentDemande", "RechercheVoiture");
                startActivity(intentGestVoit);
                return true;

            case R.id.mnListeVehicule:
                intentGestLocation.putExtra("FragmentDemande", "ListeVoiture");
                startActivity(intentGestVoit);
                return true;



            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
*/
   public String ValiderConnexion(String identifiant, String motDePasse){
        return "Valide";
   }


    public void CacherBarreNav(){
        bottomNavAccueil = findViewById(R.id.bnvAccueil);
        bottomNavAccueil.setVisibility(View.INVISIBLE);
    }

    public void AfficherBarreNav(){
        bottomNavAccueil = findViewById(R.id.bnvAccueil);
        bottomNavAccueil.setVisibility(View.VISIBLE);
    }

    public void ChangerMenu_ProfilClient(){
        bottomNavAccueil = findViewById(R.id.bnvAccueil);
        bottomNavAccueil.getMenu().clear();
        bottomNavAccueil.inflateMenu(R.menu.menu_profil_client);
    }

}
