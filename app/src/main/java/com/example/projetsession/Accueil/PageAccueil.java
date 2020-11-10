package com.example.projetsession.Accueil;

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

import com.example.projetsession.Clients.CreationCompte;
import com.example.projetsession.Clients.GestionClients;
import com.example.projetsession.R;
import com.example.projetsession.Voitures.FicheVoiture;

public class PageAccueil extends Fragment {

    Button btnCompte;



    public PageAccueil() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_page_accueil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        btnCompte = view.findViewById(R.id.btnCompte);

        btnCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), GestionClients.class);
                intent.putExtra("FragmentDemande", "CreationCompte");
                startActivity(intent);



            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
