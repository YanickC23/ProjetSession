package com.example.projetsession.Accueil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.projetsession.R;

public class Accueil extends AppCompatActivity implements Login.InterfaceLogin{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Login fragLogin;
    PageAccueil fragPageAccueil;

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








    }




   public String ValiderConnexion(String identifiant, String motDePasse){
        return "Valide";
   }



}
