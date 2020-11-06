package com.example.projetsession.Clients;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.projetsession.R;
import com.example.projetsession.Voitures.GestionVoitures;
import com.example.projetsession.Voitures.Liste_MesVoitures;
import com.example.projetsession.Voitures.ModifierVoiture;

public class GestionClients extends AppCompatActivity {

    AccueilClient fragAccueilClient;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_client);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        fragAccueilClient = new AccueilClient();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flFrag_GestClient, fragAccueilClient);
        fragmentTransaction.commit();



    }


    public void Activite_GestVoit_ListeMesVoit(){
        Intent intent = new Intent(this, GestionVoitures.class);
        startActivity(intent);
    }






}
