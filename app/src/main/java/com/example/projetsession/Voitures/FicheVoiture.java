package com.example.projetsession.Voitures;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetsession.R;


public class FicheVoiture extends Fragment {

    ModifierVoiture fragModifierVoiture;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    TextView txtMarque, txtModele, txtAnnee, txtCategorie,
            txtDescription, txtTarif, txtValeur, txtDispo;


    Button btnModif;

    public FicheVoiture() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fiche_voiture, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

            txtMarque = view.findViewById(R.id.txtFich_Marque);
            txtModele = view.findViewById(R.id.txtFich_Modele);
            txtAnnee = view.findViewById(R.id.txtFich_Anne);
            txtCategorie = view.findViewById(R.id.txtFich_Categorie);
            txtTarif = view.findViewById(R.id.txtFich_Tarif);
            txtValeur = view.findViewById(R.id.txtFich_Valeur);
            txtDispo = view.findViewById(R.id.txtFich_Dispo);
            btnModif = view.findViewById(R.id.btnModifVoiture);
            fragModifierVoiture = new ModifierVoiture();

        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragModifierVoiture);
                fragmentTransaction.commit();
            }
        });


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
