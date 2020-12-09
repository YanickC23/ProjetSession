package com.example.projetsession.Voitures;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Validations;

import java.util.ArrayList;


public class AjoutVoiture extends Fragment {

    InterfaceAjoutVoiture  interfaceAjoutVoiture;

    EditText edxMarque, edxModele, edxAnnee,
                edxDescription, edxTarif, edxValeur;

    Spinner spnCategorie;
    String marque, modele,categorie,description;
    Integer annee;
    Double valeur, tarif;
    Boolean statutDispo;

    Button btnEnr;
    Validations validations;
    ArrayList<String> listeCategorie = new ArrayList<>();

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
            btnEnr = view.findViewById(R.id.btnEnrVoiture);
            validations = new Validations();
            spnCategorie = view.findViewById(R.id.spnCategorie);

            listeCategorie.add("Compacte");
            listeCategorie.add("Berline");
            listeCategorie.add("Minifourgonnette");
            listeCategorie.add("Pickup");
            listeCategorie.add("VUS");
            listeCategorie.add("4x4");
            listeCategorie.add("Multisegment");
            listeCategorie.add("Sport");
            listeCategorie.add("Décapotable");
            listeCategorie.add("Électrique");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, listeCategorie);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategorie.setAdapter(adapter);

        spnCategorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                categorie = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnEnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean valideMarque=true;
                boolean valideModele=true;
                boolean valideAnnee=true;
                boolean valideDescription=true;
                boolean valideTarif=true;
                boolean valideValeur=true;

                valideMarque = validations.Validation_AlphaNumerique(edxMarque);
                valideModele = validations.Validation_AlphaNumerique(edxModele);
                valideAnnee = validations.Validation_Numerique_Int(edxAnnee);
                valideDescription = validations.Validation_AlphaNumerique(edxDescription);
                valideTarif = validations.Validation_Numerique_Decimal(edxTarif);
                valideValeur = validations.Validation_Numerique_Decimal(edxValeur);

                if((valideMarque==true)&&(valideModele==true)&&(valideAnnee==true)
                        &&(valideDescription==true)&&(valideTarif==true) &&(valideValeur==true)){


                marque = edxMarque.getText().toString();
                modele = edxModele.getText().toString();
                annee = Integer.parseInt(edxAnnee .getText().toString());
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


            }
                    else{
                Toast.makeText(view.getContext(), "Certains champs ne sont pas valides. ", Toast.LENGTH_LONG).show();

            }

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
        voiture.setDescript(description);
        voiture.setStatutDisponible(statutDispo);
        voiture.setTarif(tarifJournalier);

        return voiture;

    }

}



















