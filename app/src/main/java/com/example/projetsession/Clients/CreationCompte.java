package com.example.projetsession.Clients;

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
import android.widget.Toast;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.R;
import com.example.projetsession.Validations;


public class CreationCompte extends Fragment {

    InterfaceCreationCompte interfaceCreationCompte;

    EditText edxNom, edxPrenom, edxNoTel, edxEmail,
            edxMotDePasse, edxNoPermis, edxCarteCredit;

    String nom, prenom, noTel, email,
            motDePasse, noPermis, carteCredit;

    Button btnEnr;
    Validations validations;

    public CreationCompte() {
        // Required empty public constructor
    }

    public interface InterfaceCreationCompte{
        void CreerCompteClient(Client client);
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
        edxNom = view.findViewById(R.id.edxNom);
        edxPrenom = view.findViewById(R.id.edxPrenom);
        edxNoTel = view.findViewById(R.id.edxNotel);
        edxEmail = view.findViewById(R.id.edxEmail);
        edxMotDePasse = view.findViewById(R.id.edxMotdepasse_1);
        edxNoPermis = view.findViewById(R.id.edxPermis);
        edxCarteCredit = view.findViewById(R.id.edxCredit);
        btnEnr = view.findViewById(R.id.btnEnrClient);

        validations = new Validations();

            btnEnr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean valideNom=true;
                    boolean validePrenom=true;
                    boolean valideTel=true;
                    boolean valideEmail=true;
                    boolean valideMDP=true;
                    boolean validePermis=true;
                    boolean valideCarteCredit=true;

                    valideNom = validations.Validation_String(edxNom);
                    validePrenom = validations.Validation_String(edxPrenom);
                    valideTel = validations.Validation_Telephone(edxNoTel);
                    valideEmail = validations.Validation_Email(edxEmail);
                    valideMDP = validations.Validation_MotDePasse(edxMotDePasse);
                    validePermis = validations.Validation_AlphaNumerique(edxNoPermis);
                    valideCarteCredit = validations.Validation_AlphaNumerique(edxCarteCredit);

                    if((valideNom==true)&&(validePrenom==true)&&(valideTel==true)
                            &&(valideEmail==true)&&(valideMDP==true)&&(validePermis==true) &&(valideCarteCredit==true)){

                    nom = edxNom.getText().toString();
                    prenom = edxPrenom.getText().toString();
                    noTel = edxNoTel.getText().toString();
                    email = edxEmail.getText().toString();
                    motDePasse = edxMotDePasse.getText().toString();
                    noPermis = edxNoPermis.getText().toString();
                    carteCredit = edxCarteCredit.getText().toString();


                   interfaceCreationCompte.CreerCompteClient(CreationCompte(nom, prenom, noTel, email, motDePasse, noPermis, carteCredit));

                    edxNom.setText("");
                    edxPrenom.setText("");
                    edxNoTel.setText("");
                    edxEmail.setText("");
                    edxMotDePasse.setText("");
                    edxNoPermis.setText("");
                    edxCarteCredit.setText("");
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
        interfaceCreationCompte = (InterfaceCreationCompte) context;
    }

    public Client CreationCompte(String nom, String prenom, String noTel, String email,
                                 String motDePasse, String noPermis, String carte_Credit){

        Client client = new Client();

        client.setPrenom(prenom);
        client.setNom(nom);
        client.setNoTel(noTel);
        client.setEmail(email);
        client.setMotDePasse(motDePasse);
        client.setNoPermis(noPermis);
        client.setCarte_credit(carte_Credit);

        return client;

    }

}
