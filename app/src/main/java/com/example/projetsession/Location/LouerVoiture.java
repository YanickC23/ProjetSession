package com.example.projetsession.Location;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.squareup.picasso.Picasso;

public class LouerVoiture extends AppCompatActivity {

    ImageView imgholderLocation;
    TextView tvmarquemodelelocationvoiture, tvannelocation,
            tvvoituretypelocation ,tvprixlocation;
    Button btnlouervoiture2;
    Voiture voiture;
    String index;
    String marque;
    String modele;
    String annee;
    String valeur;
    String statut;
    String description;
    String tarif;
    String categorie;
    String proprio;
    String path;
    /*int index2 = 0,annee2 = 0,proprio2 = 0;
    Double valeur2 = 0.0,tarif2= 0.0;
    Boolean statut2 = true;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_louer_voiture);

        imgholderLocation = findViewById(R.id.imgholderLocation);
        tvmarquemodelelocationvoiture = findViewById(R.id.tvmarquemodelelocationvoiture);
        tvannelocation = findViewById(R.id.tvannelocation);
        tvvoituretypelocation = findViewById(R.id.tvvoituretypelocation);
        tvprixlocation = findViewById(R.id.tvprixlocation);
        btnlouervoiture2 = findViewById(R.id.btnlouervoiture2);

        Intent intent = getIntent();
        if (intent.hasExtra("index")) {
            if(intent.getStringExtra("index") != null) {
                index = intent.getStringExtra("index");
            }
            //index2 = Integer.parseInt(index);
        }
        if (intent.hasExtra("marque")) {
            if(intent.getStringExtra("marque") != null) {
            marque = intent.getStringExtra("marque");
            //etNom.setText(nom);
            }
        }
        if (intent.hasExtra("modele")) {
            if(intent.getStringExtra("modele") != null) {
                modele = intent.getStringExtra("modele");
            }

        }
        if (intent.hasExtra("annee")) {
            if(intent.getStringExtra("annee") != null) {
                annee = intent.getStringExtra("annee");
            }
            //annee2 = Integer.parseInt(annee);
        }
        if (intent.hasExtra("valeur")) {
            if(intent.getStringExtra("valeur") != null) {
                valeur = intent.getStringExtra("valeur");
            }

        }
        if (intent.hasExtra("Statut")) {
            if(intent.getStringExtra("Statut") != null) {
                statut = intent.getStringExtra("Statut");
            }

        }
        if (intent.hasExtra("description")) {
            if(intent.getStringExtra("description") != null) {
                description = intent.getStringExtra("description");
            }

        }

        if (intent.hasExtra("tarif")) {
            if(intent.getStringExtra("tarif") != null) {
                tarif = intent.getStringExtra("tarif");
            }

        }

        if (intent.hasExtra("categorie")) {
            if(intent.getStringExtra("categorie") != null) {
                categorie = intent.getStringExtra("categorie");
            }

        }

        if (intent.hasExtra("proprio")) {
            if(intent.getStringExtra("proprio") != null) {
                proprio = intent.getStringExtra("proprio");
            }

        }

        if (intent.hasExtra("path")) {
            if(intent.getStringExtra("path") != null) {
                path = intent.getStringExtra("path");
            }

        }
       /* index2 = Integer.parseInt(index);
        valeur2 = Double.parseDouble(valeur);
        proprio2 = Integer.parseInt(proprio);
        tarif2 = Double.parseDouble(tarif);
        statut2 =  Boolean.parseBoolean(Statut);*/


        voiture = new Voiture(Integer.parseInt(index),marque,modele,Integer.parseInt(annee),Double.parseDouble(valeur) ,
                Boolean.parseBoolean(statut),description,Double.parseDouble(tarif), categorie, Integer.parseInt(proprio),path);

      /*  int _Id_voiture, String _Marque, String _Modele, Integer _Annee,
                Double _Prix, boolean _StatutDispo, String _Description,
                Double _TarifJournalier, String _Categorie, Integer _Proprio, String path*/
        tvmarquemodelelocationvoiture.setText(voiture.getMarqueModele());
        tvannelocation.setText(voiture.getAnnee().toString());
        tvvoituretypelocation.setText(voiture.getCategorie());
        tvprixlocation.setText(voiture.getTarif().toString());

        Picasso.get()
                .load(RetrofitInstance.BASE_URL_IMAGE + "images/" + voiture.getPath()).fit().into(imgholderLocation);

        btnlouervoiture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                Intent intentretour = new Intent(getApplicationContext(), GestionLocation.class);
                                intentretour.putExtra("index", index);
                                setResult(RESULT_OK, intentretour);
                                finish();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                Intent intentretour2 = new Intent(getApplicationContext(), GestionLocation.class);
                                setResult(RESULT_CANCELED, intentretour2);
                                finish();
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext()); // le non est avant le oui...
                builder.setMessage("Êtes-vous sur de vouloir louer cette voiture?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();

            }
        });

    }

}
