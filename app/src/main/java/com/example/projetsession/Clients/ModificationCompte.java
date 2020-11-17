package com.example.projetsession.Clients;

import android.content.Context;
import android.content.SharedPreferences;
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

import com.example.projetsession.R;
import com.example.projetsession.Singleton;


public class ModificationCompte extends Fragment {

    TextView txtTitre;

    InterfaceModifierCompte interfaceModifierCompte;

    EditText edxNom, edxPrenom, edxNoTel, edxEmail,
            edxMotDePasse, edxNoPermis, edxCarteCredit;

    String nom, prenom, noTel, email,
            motDePasse, noPermis, carteCredit;
    int positLstClient;
    Button btnEnr;

    public ModificationCompte() {
        // Required empty public constructor
    }

    public interface InterfaceModifierCompte{
       void ModifierCompteClient(int index ,String _Nom, String _Prenom, String _NoTel, String _Email,
                             String _MotDePasse, String _NoPermis, String _Carte_Credit);
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


        edxNom = view.findViewById(R.id.edxNom);
        edxPrenom = view.findViewById(R.id.edxPrenom);
        edxNoTel = view.findViewById(R.id.edxNotel);
        edxEmail = view.findViewById(R.id.edxEmail);
        edxMotDePasse = view.findViewById(R.id.edxMotdepasse_1);
        edxNoPermis = view.findViewById(R.id.edxPermis);
        edxCarteCredit = view.findViewById(R.id.edxCredit);
        btnEnr = view.findViewById(R.id.btnEnrClient);

        SharedPreferences pref = this.getActivity().getSharedPreferences("PositLstClients", Context.MODE_PRIVATE);
        positLstClient = pref.getInt("PositLstClients", 0);

        edxNom.setText(Singleton.getInstance().Obt_NomClient(positLstClient));
        edxPrenom.setText(Singleton.getInstance().Obt_PrenomClient(positLstClient));
        edxNoTel.setText(Singleton.getInstance().Obt_NoTelClient(positLstClient));
        edxEmail.setText(Singleton.getInstance().Obt_CourrielClient(positLstClient));
        edxMotDePasse.setText(Singleton.getInstance().Obt_MotDePasseClient(positLstClient));
        edxNoPermis.setText(Singleton.getInstance().Obt_NoPermis(positLstClient));
        edxCarteCredit.setText(Singleton.getInstance().Obt_CarteCredit(positLstClient));

        btnEnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                nom = edxNom.getText().toString();
                prenom = edxPrenom.getText().toString();
                noTel = edxNoTel.getText().toString();
                email = edxEmail.getText().toString();
                motDePasse = edxMotDePasse.getText().toString();
                noPermis = edxNoPermis.getText().toString();
                carteCredit = edxCarteCredit.getText().toString();

                interfaceModifierCompte.ModifierCompteClient(positLstClient, nom, prenom, noTel, email, motDePasse, noPermis, carteCredit);


            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceModifierCompte = (InterfaceModifierCompte) context;

    }


}
