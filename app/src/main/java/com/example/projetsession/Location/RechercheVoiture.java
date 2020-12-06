package com.example.projetsession.Location;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.projetsession.R;

import java.util.ArrayList;


public class RechercheVoiture extends Fragment {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    InterfaceRechercheVoiture interfaceRechercheVoiture;

    Spinner spinner;

    String categorie, marque, modele, dateDebut, dateFin;
    Double tarifMin, tarifMax;
    Button btnRech;

    EditText edxmarque, edxmodele,
            edxdateDebut, edxdateFin, edxtarifMin,
            edxtarifMax;

    ArrayList<String> listeCategorie = new ArrayList<>();

    public RechercheVoiture() {
        // Required empty public constructor
    }

    public interface InterfaceRechercheVoiture{
        void ChoixDateInf();
        void ChoixDateSup();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recherche_voiture, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        spinner = view.findViewById(R.id.spnRechVoiture);
        btnRech = view.findViewById(R.id.btnRechVoitLocation);

        edxmarque = view.findViewById(R.id.edxRechMarque);
        edxmodele = view.findViewById(R.id.edxRechModele);
        edxdateDebut = view.findViewById(R.id.edxRechDateInf);
        edxdateFin = view.findViewById(R.id.edxRechDateSup);
        edxtarifMin = view.findViewById(R.id.edxRechTarifInf);
        edxtarifMax = view.findViewById(R.id.edxRechTarifSup);

        listeCategorie.add("Recherche par Catégorie");
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
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                categorie = adapterView.getItemAtPosition(position).toString();
                listeCategorie.remove("Recherche par Catégorie");

                if(categorie.equals("Recherche par Catégorie")){
                    categorie = "null";
                }

                //Toast.makeText(view.getContext(), categorie, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        edxdateDebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceRechercheVoiture.ChoixDateInf();
            }
        });

        edxdateFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceRechercheVoiture.ChoixDateSup();
            }
        });

        btnRech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                marque = edxmarque.getText().toString();
                modele = edxmodele.getText().toString();
                dateDebut = edxdateDebut.getText().toString();
                dateFin = edxdateFin.getText().toString();
                tarifMin = Double.parseDouble(edxtarifMin.getText().toString());
                tarifMax = Double.parseDouble(edxtarifMax.getText().toString());
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceRechercheVoiture = (InterfaceRechercheVoiture) context;
    }


}
