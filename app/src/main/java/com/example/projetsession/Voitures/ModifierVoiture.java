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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.Validations;

import java.util.ArrayList;


public class ModifierVoiture extends Fragment {

    InterfaceModifierVoiture interfaceModifierVoiture;

    EditText edxMarque, edxModele, edxAnnee,
            edxDescription, edxTarif, edxValeur;
    Spinner spnCategorie;
    String marque, modele,categorie,description;
    Integer annee, position;
    Double valeur, tarif;
    Boolean statutDispo;
    int positLstMVoit;
    Button btnEnr;
    Validations validations;
    ArrayList<String> listeCategorie = new ArrayList<>();


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
        btnEnr = view.findViewById(R.id.btnEnrVoiture);
        spnCategorie = view.findViewById(R.id.spnCategorie);
        validations = new Validations();

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


        SharedPreferences pref = this.getActivity().getSharedPreferences("PositLstMVoit", Context.MODE_PRIVATE);
        positLstMVoit = pref.getInt("PositLstMVoit", 0);

        edxMarque.setText(Singleton.getInstance().Obt_MarqueVoiture(positLstMVoit));
        edxModele.setText(Singleton.getInstance().Obt_ModeleVoiture(positLstMVoit));
        edxAnnee.setText(Integer.toString(Singleton.getInstance().Obt_AnneeVoiture(positLstMVoit)));
        edxDescription.setText(Singleton.getInstance().Obt_DescriptionVoiture(positLstMVoit));
        edxTarif.setText(Double.toString(Singleton.getInstance().Obt_TarifJournVoiture(positLstMVoit)));
        edxValeur.setText(Double.toString(Singleton.getInstance().Obt_PrixVoiture(positLstMVoit)));


        String textSpinner;
        textSpinner = Singleton.getInstance().Obt_CategorieVoiture(positLstMVoit);

        switch (textSpinner){

            case "Compacte": spnCategorie.setSelection(0);
            case "Berline":  spnCategorie.setSelection(0);
            case "Minifourgonnette":  spnCategorie.setSelection(0);
            case "Pickup":  spnCategorie.setSelection(0);
            case "VUS":  spnCategorie.setSelection(0);
            case "4x4":  spnCategorie.setSelection(0);
            case "Multisegment":  spnCategorie.setSelection(0);
            case "Sport":  spnCategorie.setSelection(0);
            case "Décapotable":  spnCategorie.setSelection(0);
            case "Électrique":  spnCategorie.setSelection(0);

        }


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

                interfaceModifierVoiture.ModifierVoitureListe(positLstMVoit, marque, modele, annee, valeur, statutDispo, description, tarif, categorie);

                }
                else{
                    Toast.makeText(view.getContext(), "Certains champs ne sont pas valides. ", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceModifierVoiture = (InterfaceModifierVoiture)context;
    }


}
