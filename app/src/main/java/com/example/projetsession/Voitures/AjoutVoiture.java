package com.example.projetsession.Voitures;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;


public class AjoutVoiture extends Fragment {

    InterfaceAjoutVoiture  interfaceAjoutVoiture;

    EditText edxMarque, edxModele, edxAnnee, edxCategorie,
                edxDescription, edxTarif, edxValeur;

    String marque, modele,categorie,description;
    Integer annee;
    Double valeur, tarif;
    Boolean statutDispo;

    Button btnEnr;

    public AjoutVoiture() {
        // Required empty public constructor
    }


    public interface InterfaceAjoutVoiture{
        void AjouterVoitureListe(Voiture voiture);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_ajout_voiture, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceAjoutVoiture = (InterfaceAjoutVoiture)context;

    }

    @Override
    public void onDetach() {
        super.onDetach();

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

                interfaceAjoutVoiture.AjouterVoitureListe(CreationVoiture(marque, modele, annee, valeur, statutDispo, description, tarif, categorie));


                edxMarque.setText("");
                edxModele.setText("");
                edxAnnee.setText("");
                edxDescription.setText("");
                edxTarif.setText("");
                edxValeur.setText("");
                edxCategorie.setText("");

            }
        });



    }





    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }


    public Voiture CreationVoiture(String marque, String modele, Integer annee,
                                   Double prix, boolean statutDispo, String description,
                                   Double tarifJournalier, String categorie){

        Voiture voiture = new Voiture();

        voiture.setMarque(marque);
        voiture.setModele(modele);
        voiture.setCategorie(categorie);
        voiture.setAnnee(annee);
        voiture.setValeur(prix);
        voiture.setDescription(description);
        voiture.setStatutDisponible(statutDispo);
        voiture.setTarif(tarifJournalier);

        return voiture;

    }

}



















