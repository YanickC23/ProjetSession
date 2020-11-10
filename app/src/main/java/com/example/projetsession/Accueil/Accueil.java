package com.example.projetsession.Accueil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.projetsession.Clients.AccueilClient;
import com.example.projetsession.R;

public class Accueil extends AppCompatActivity {

    PageAccueil pageAccueil;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        pageAccueil = new PageAccueil();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.Fl_FragAccueil, pageAccueil);
        fragmentTransaction.commit();

    }
}
