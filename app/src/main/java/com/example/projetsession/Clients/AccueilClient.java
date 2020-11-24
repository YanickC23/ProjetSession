package com.example.projetsession.Clients;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projetsession.R;
import com.example.projetsession.Voitures.GestionVoitures;
import com.example.projetsession.Voitures.Liste_MesVoitures;


public class AccueilClient extends Fragment {

    ModificationCompte fragModifCompte;
    Liste_MesVoitures fragListeMesVoitures;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    Button btnProfil, btnVoiture, btnLocation;


    public AccueilClient() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accueil_client, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        fragModifCompte = new ModificationCompte();
        fragListeMesVoitures = new Liste_MesVoitures();

        btnProfil = view.findViewById(R.id.btnMonProfil);
        btnVoiture = view.findViewById(R.id.btnMesVoitures);
        btnLocation = view.findViewById(R.id.btnLouerVoiture);


        btnVoiture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activite_GestVoit_ListeMesVoit(view);
            }
        });


        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestClient, fragModifCompte);
                fragmentTransaction.commit();

            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //TODO ==> Gestion Location
            }
        });



    }


        @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void Activite_GestVoit_ListeMesVoit(View view){
        Intent intent = new Intent(view.getContext(), GestionVoitures.class);
        startActivity(intent);
    }
}
