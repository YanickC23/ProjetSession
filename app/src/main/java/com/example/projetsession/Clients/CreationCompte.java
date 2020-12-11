package com.example.projetsession.Clients;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetsession.Location.Adapter_Toute_Voiture;
import com.example.projetsession.Location.GestionLocation;
import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.example.projetsession.retrofit.ServerResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class CreationCompte extends Fragment {

    InterfaceCreationCompte interfaceCreationCompte;

    EditText edxNom, edxPrenom, edxNoTel, edxEmail,
            edxMotDePasse, edxNoPermis, edxCarteCredit;

    String nom, prenom, noTel, email,
            motDePasse, noPermis, carteCredit;

    Client client;
    Button btnEnr;

    public CreationCompte() {
        // Required empty public constructor
    }

    public interface InterfaceCreationCompte{
        void CreerCompteClient(Client client);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new Client();
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

                    //interfaceCreationCompte.CreerCompteClient(CreationCompte(nom, prenom, noTel, email, motDePasse, noPermis, carteCredit));

                    connection_serveur(nom,prenom,noTel,email,motDePasse,noPermis,carteCredit);

                    edxNom.setText("");
                    edxPrenom.setText("");
                    edxNoTel.setText("");
                    edxEmail.setText("");
                    edxMotDePasse.setText("");
                    edxNoPermis.setText("");
                    edxCarteCredit.setText("");
                }
            });


        }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceCreationCompte = (InterfaceCreationCompte) context;
    }

   /* public Client CreationCompte(String nom, String prenom, String noTel, String email,
                                 String motDePasse, String noPermis, String carte_Credit){

        Client client = new Client();

        client.setPrenom(prenom);
        client.setNom(nom);
        client.setTelephone(noTel);
        client.setCourriel(email);
        client.setMotdepasse(motDePasse);
        client.setNopermis(noPermis);
        client.setCarte_credit(carte_Credit);

        return client;

    }*/
   public void connection_serveur(String nom, String prenom, String noTel, String email,
                                   String motDePasse, String noPermis, String carte_Credit){

        InterfaceServeur interfaceServeur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<ServerResponse> call = interfaceServeur.créateAccount(nom,prenom,noTel,email,motDePasse,noPermis,carte_Credit);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse>response) {

                if (response.body() != null) {
                    String test = response.body().getResponse();
                    if(response.isSuccessful()){
                        Toast.makeText(getContext(), test,Toast.LENGTH_LONG).show();
                          if(test.equals("réussit...")) {
                              Toast.makeText(getContext(), "sa marche? oui", Toast.LENGTH_LONG).show();
                            /*Intent intent = new Intent(getContext(), GestionLocation.class);
                            intent.putExtra("FragmentDemande", "AccueilClient");
                            startActivity(intent);*/
                          }
                        }else{
                            Toast.makeText(getContext(),"non",Toast.LENGTH_LONG).show();
                        }


                }else{
                    Toast.makeText(getContext(),"",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Une erreur est survenue lors de l'inscription.", Toast.LENGTH_LONG).show();
            }
        });

    }

}
