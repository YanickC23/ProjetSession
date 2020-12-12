package com.example.projetsession.Accueil;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.projetsession.Clients.GestionClients;
import com.example.projetsession.Location.GestionLocation;
import com.example.projetsession.R;
import com.example.projetsession.Validations;


public class Login extends Fragment {

    InterfaceLogin interfaceLogin;
    EditText edxIdentifiant, edxMotDePasse;
    String identifiant, motDePasse;
    Button btnConnection, btnCreationCompte;

    String connect;
    Validations validations;
    public Login() {
        // Required empty public constructor
    }

    public interface InterfaceLogin{
        String ValiderConnexion(String identifiant, String motDePasse);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceLogin = (InterfaceLogin) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        btnConnection = view.findViewById(R.id.btnLogin_Connexion);
        btnCreationCompte = view.findViewById(R.id.btnCreerCompte);
        edxIdentifiant = view.findViewById(R.id.txtLogin_Email);
        edxMotDePasse = view.findViewById(R.id.txtLogin_MotDePasse);


        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean valideIdentifiant=true;
                boolean valideMDP=true;

                validations = new Validations();

                valideIdentifiant = validations.Validation_Email(edxIdentifiant);
                valideMDP = validations.Validation_AlphaNumerique(edxMotDePasse);


                if((valideIdentifiant==true)&&(valideMDP==true)){
                    identifiant = edxIdentifiant.getText().toString();
                    motDePasse = edxMotDePasse.getText().toString();
                    connect =  interfaceLogin.ValiderConnexion(identifiant, motDePasse);



                    if(connect.equals("Valide")== true){
                        Intent intent = new Intent(view.getContext(), GestionClients.class);
                        intent.putExtra("FragmentDemande", "AccueilClient");
                        startActivity(intent);
                    }else {
                        Toast.makeText(view.getContext(), "Le Mot de Passe n'est pas Valide.\n Accès Refusé. ", Toast.LENGTH_LONG).show();
                    }

                    edxIdentifiant.setText("");
                    edxMotDePasse.setText("");

                    Toast.makeText(view.getContext(), identifiant, Toast.LENGTH_LONG).show();
                }
                    else{
                Toast.makeText(view.getContext(), "Certains champs ne sont pas valides. ", Toast.LENGTH_LONG).show();

            }



            }

        });

        btnCreationCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GestionClients.class);
                intent.putExtra("FragmentDemande", "CreationCompte");
                startActivity(intent);
            }
        });




    }

}
