package com.example.projetsession.Clients;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetsession.R;


public class ModificationCompte extends Fragment {

    TextView txtTitre;

    public ModificationCompte() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_creation_compte, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        txtTitre = view.findViewById(R.id.txtTitreModifCompte);

        txtTitre.setText("Modifier mon Profil");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}