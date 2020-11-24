package com.example.projetsession.Voitures;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetsession.R;
import com.example.projetsession.Singleton;


public class FicheVoiture extends Fragment {

    ModifierVoiture fragModifierVoiture;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    TextView txtMarqueModele, txtModele, txtAnnee, txtCategorie,
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

            txtMarqueModele = view.findViewById(R.id.txtFich_MarqueModele);
            txtAnnee = view.findViewById(R.id.txtFich_Anne);
            txtCategorie = view.findViewById(R.id.txtFich_Categorie);
            txtTarif = view.findViewById(R.id.txtFich_Tarif);
            txtValeur = view.findViewById(R.id.txtFich_Valeur);
            txtDispo = view.findViewById(R.id.txtFich_Dispo);
            btnModif = view.findViewById(R.id.btnModifVoiture);
            fragModifierVoiture = new ModifierVoiture();

            SharedPreferences pref = this.getActivity().getSharedPreferences("PositLstMVoit", Context.MODE_PRIVATE);
            int positLstMVoit = pref.getInt("PositLstMVoit", 0);

            txtMarqueModele.setText(Singleton.getInstance().Obt_MarqueModele(positLstMVoit));
            txtAnnee.setText(Integer.toString(Singleton.getInstance().Obt_AnneeVoiture(positLstMVoit)));
            txtCategorie.setText(Singleton.getInstance().Obt_CategorieVoiture(positLstMVoit));
            txtTarif.setText(Double.toString(Singleton.getInstance().Obt_TarifJournVoiture(positLstMVoit)));
            txtValeur.setText(Double.toString(Singleton.getInstance().Obt_PrixVoiture(positLstMVoit)));
            txtDispo.setText(Singleton.getInstance().Obt_Statut(positLstMVoit));


        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
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
