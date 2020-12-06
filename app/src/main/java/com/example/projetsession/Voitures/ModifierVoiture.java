package com.example.projetsession.Voitures;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;


public class ModifierVoiture extends Fragment {

    InterfaceModifierVoiture interfaceModifierVoiture;

    EditText edxMarque, edxModele, edxAnnee, edxCategorie,
            edxDescription, edxTarif, edxValeur;

    String marque, modele,categorie,description;
    Integer annee, position;
    Double valeur, tarif;
    Boolean statutDispo;
    int positLstMVoit;
    Button btnEnr;

    public ModifierVoiture() {
        // Required empty public constructor
    }

    public interface InterfaceModifierVoiture{
        void ModifierVoitureListe(int index ,String _Marque, String _Modele, Integer _Annee,
                                  Double _Prix, boolean _StatutDispo, String _Description,
                                  Double _TarifJournalier, String _Categorie);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ajout_voiture, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        edxMarque = view.findViewById(R.id.edxMarque);
        edxModele = view.findViewById(R.id.edxModele);
        edxAnnee = view.findViewById(R.id.edxAnnee);
        edxDescription = view.findViewById(R.id.edxDescription);
        edxTarif = view.findViewById(R.id.edxTarif);
        edxValeur = view.findViewById(R.id.edxValeur);
        edxCategorie = view.findViewById(R.id.edxCategorie);
        btnEnr = view.findViewById(R.id.btnEnrVoiture);

        SharedPreferences pref = this.getActivity().getSharedPreferences("PositLstMVoit", Context.MODE_PRIVATE);
        positLstMVoit = pref.getInt("PositLstMVoit", 0);

        edxMarque.setText(Singleton.getInstance().Obt_MarqueVoiture(positLstMVoit));
        edxModele.setText(Singleton.getInstance().Obt_ModeleVoiture(positLstMVoit));
        edxAnnee.setText(Integer.toString(Singleton.getInstance().Obt_AnneeVoiture(positLstMVoit)));
        edxDescription.setText(Singleton.getInstance().Obt_DescriptionVoiture(positLstMVoit));
        edxTarif.setText(Double.toString(Singleton.getInstance().Obt_TarifJournVoiture(positLstMVoit)));
        edxValeur.setText(Double.toString(Singleton.getInstance().Obt_PrixVoiture(positLstMVoit)));
        edxCategorie.setText(Singleton.getInstance().Obt_CategorieVoiture(positLstMVoit));

        btnEnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                marque = edxMarque.getText().toString();
                modele = edxModele.getText().toString();
                annee = Integer.parseInt(edxAnnee .getText().toString());
                categorie = edxCategorie.getText().toString();
                description = edxDescription.getText().toString();
                tarif = Double.parseDouble(edxTarif.getText().toString());
                valeur = Double.parseDouble(edxValeur.getText().toString());
                statutDispo = true;

                interfaceModifierVoiture.ModifierVoitureListe(positLstMVoit, marque, modele, annee, valeur, statutDispo, description, tarif, categorie);



            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceModifierVoiture = (InterfaceModifierVoiture)context;
    }


}
