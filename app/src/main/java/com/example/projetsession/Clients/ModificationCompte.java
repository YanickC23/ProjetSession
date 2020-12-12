package com.example.projetsession.Clients;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.projetsession.Location.GestionLocation;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.example.projetsession.retrofit.ServerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class ModificationCompte extends Fragment {

    TextView txtTitre;

    InterfaceModifierCompte interfaceModifierCompte;

    EditText edxNom, edxPrenom, edxNoTel, edxEmail,
            edxMotDePasse,edxMotDePasse2, edxNoPermis, edxCarteCredit;

    String nom, prenom, noTel, email,
            motDePasse, noPermis, carte_Credit;
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
        edxMotDePasse2 = view.findViewById(R.id.edxMotdepasse_2);
        edxNoPermis = view.findViewById(R.id.edxPermis);
        edxCarteCredit = view.findViewById(R.id.edxCredit);
        btnEnr = view.findViewById(R.id.btnEnrClient);
        btnEnr.setText("Enregistrer les modifications");

        SharedPreferences pref = this.getActivity().getSharedPreferences("PositLstClients", MODE_PRIVATE);
        positLstClient = pref.getInt("PositLstClients", 0);

        SharedPreferences user_info = this.getActivity().getSharedPreferences("user_info", MODE_PRIVATE);
        int id_client = user_info.getInt("id", 0); //0 is the default value.
        String user_nom = user_info.getString("nom", "No name defined");//"No name defined" is the default value.
        String user_prenom = user_info.getString("prenom", "No name defined");//"No name defined" is the default value.
        String user_telephone = user_info.getString("telephone", "No name defined");//"No name defined" is the default value.
        String user_email = user_info.getString("email", "No name defined");//"No name defined" is the default value.
        String user_motdepasse = user_info.getString("motdepasse", "No name defined");//"No name defined" is the default value.
        String user_nopermis = user_info.getString("nopermis", "No name defined");//"No name defined" is the default value.
        String user_carte_credit = user_info.getString("carte_credit", "No name defined");//"No name defined" is the default value.

          //!!
       /* Toast.makeText(getContext(),id_client + " " + user_nom + " " + user_prenom + " "
                + user_telephone + " " + user_email + " " + user_motdepasse + " " + user_nopermis + " "
                + user_carte_credit,Toast.LENGTH_LONG).show();*/

        edxNom.setText(user_nom);
        edxPrenom.setText(user_prenom);
        edxNoTel.setText(user_telephone);
        edxEmail.setText(user_email);
        edxMotDePasse.setText(user_motdepasse);
        edxMotDePasse2.setText(user_motdepasse);
        edxNoPermis.setText(user_nopermis);
        edxCarteCredit.setText(user_carte_credit);

 /*        edxNom.setText(Singleton.getInstance().Obt_NomClient(positLstClient));
        edxPrenom.setText(Singleton.getInstance().Obt_PrenomClient(positLstClient));
        edxNoTel.setText(Singleton.getInstance().Obt_NoTelClient(positLstClient));
        edxEmail.setText(Singleton.getInstance().Obt_CourrielClient(positLstClient));
        edxMotDePasse.setText(Singleton.getInstance().Obt_MotDePasseClient(positLstClient));
        edxNoPermis.setText(Singleton.getInstance().Obt_NoPermis(positLstClient));
        edxCarteCredit.setText(Singleton.getInstance().Obt_CarteCredit(positLstClient));*/

        btnEnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                nom = edxNom.getText().toString();
                prenom = edxPrenom.getText().toString();
                noTel = edxNoTel.getText().toString();
                email = edxEmail.getText().toString();
                motDePasse = edxMotDePasse.getText().toString();
                noPermis = edxNoPermis.getText().toString();
                carte_Credit = edxCarteCredit.getText().toString();

                modifiercation_du_compte_utilisateur(id_client,nom,prenom,noTel,email,motDePasse,noPermis,carte_Credit);

                //
                //interfaceModifierCompte.ModifierCompteClient(positLstClient, nom, prenom, noTel, email, motDePasse, noPermis, carte_Credit);


            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceModifierCompte = (InterfaceModifierCompte) context;

    }

    public void modifiercation_du_compte_utilisateur(int id,String nom, String prenom, String noTel, String email,
                                   String motDePasse, String noPermis, String carte_Credit){

        InterfaceServeur interfaceServeur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<ServerResponse> call = interfaceServeur.changeProfil(id,nom,prenom,noTel,email,motDePasse,noPermis,carte_Credit);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                if (response.body() != null) {
                    String message = response.body().getResponse();
                    if(response.isSuccessful()){
                        if(message.equals("réussit...")) {
                            Toast.makeText(getContext(), "La modification du compte a été " + message,Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getContext(), GestionLocation.class);
                            intent.putExtra("FragmentDemande", "AccueilClient");
                            startActivity(intent);
                        }else{
                            Toast.makeText(getContext(),"La modification du compte a rencontré une erreur et a " +  message,Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getContext(),"Une erreur est survenue lors de la modification du compte.",Toast.LENGTH_LONG).show();
                    }


                }else{
                    Toast.makeText(getContext(),"Une erreur est survenue lors de la modification du compte.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Une erreur est survenue lors de la modification du compte.", Toast.LENGTH_LONG).show();
            }
        });

    }


}
