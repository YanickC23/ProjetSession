package com.example.projetsession.Voitures;

import android.content.Context;
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

import com.example.projetsession.R;


public class AjoutVoiture extends Fragment {

    InterfaceAjoutVoiture  interfaceAjoutVoiture;

    EditText edxMarque, edxModele, edxAnnee, edxCategorie,
                edxDescription, edxTarif, edxValeur;

    Button btnEnr;

    public AjoutVoiture() {
        // Required empty public constructor
    }


    public interface InterfaceAjoutVoiture{

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

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }



}
