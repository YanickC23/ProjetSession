package com.example.projetsession.Accueil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class Login extends Fragment {

    InterfaceLogin interfaceLogin;
    EditText edxIdentifiant, edxMotDePasse;
    String identifiant, motDePasse;
    Button btnConnection, btnCreationCompte;

    String connect;
    Client client;

    public Login() {
        // Required empty public constructor
    }

    public interface InterfaceLogin{
        String ValiderConnexion(String identifiant, String motDePasse);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new Client();
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

        edxIdentifiant = view.findViewById(R.id.txtLogin_Email);
        edxMotDePasse = view.findViewById(R.id.txtLogin_MotDePasse);
        btnConnection = view.findViewById(R.id.btnLogin_Connexion);
        btnCreationCompte = view.findViewById(R.id.btnCreerCompte);


        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identifiant = edxIdentifiant.getText().toString();
                motDePasse = edxMotDePasse.getText().toString();

                connect = interfaceLogin.ValiderConnexion(identifiant, motDePasse);
                connection_serveur(identifiant,motDePasse);

                if(connect.equals("Valide")== true){
                    Intent intent = new Intent(view.getContext(), GestionClients.class);
                    intent.putExtra("FragmentDemande", "AccueilClient");
                    startActivity(intent);
                    SharedPreferences user_info = view.getContext().getSharedPreferences("PositLstClients",MODE_PRIVATE);
                    SharedPreferences.Editor editor = user_info.edit();
                    editor.putInt("id", client.getId_client());
                    editor.putString("nom", client.getNom());
                    editor.putString("prenom", client.getPrenom());
                    editor.putString("email", client.getEmail());
                    editor.putString("motdepasse", client.getMotDePasse());
                    editor.putString("nopermis", client.getNoPermis());
                    editor.putString("carte_credit", client.getCarte_credit());
                    editor.commit();

                    /*
                    SharedPreferences user_info = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
String name = user_info.getString("name", "No name defined");//"No name defined" is the default value.
int idName = user_info.getInt("idName", 0); //0 is the default value.
                     */
                }else {
                    Toast.makeText(view.getContext(), "Le Mot de Passe n'est pas Valide.\n Accès Refusé. ", Toast.LENGTH_LONG).show();
                }

                edxIdentifiant.setText("");
                edxMotDePasse.setText("");
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
    public void connection_serveur(String indentifiant, String motdepasse){
        InterfaceServeur interfaceServeur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<Client> call = interfaceServeur.getConnectionInfo(indentifiant,motdepasse);

        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {

                if (response.isSuccessful()) {
                    client = response.body();
                        Toast.makeText(getContext(),"" + client.toString(),Toast.LENGTH_LONG).show();

                    }else{
                    Toast.makeText(getContext(),"Compte invalide",Toast.LENGTH_LONG).show();
                }
                }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
