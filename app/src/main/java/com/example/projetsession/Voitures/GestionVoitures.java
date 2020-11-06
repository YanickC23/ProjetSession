package com.example.projetsession.Voitures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;

import java.util.ArrayList;
import java.util.List;

public class GestionVoitures extends AppCompatActivity implements AjoutVoiture.InterfaceAjoutVoiture,
                                                                    Liste_MesVoitures.InterfaceListe_MesVoiture,
                                                                        ModifierVoiture.InterfaceModifierVoiture{



    AjoutVoiture fragAjoutVoiture;
    Liste_MesVoitures fragListeMesVoitures;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    List<Voiture> listeVoiture =  new ArrayList<Voiture>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_voitures);


        fragAjoutVoiture = new AjoutVoiture();
        fragListeMesVoitures = new Liste_MesVoitures();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flFrag_GestVoiture, fragListeMesVoitures);
        fragmentTransaction.commit();



        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_gestvoiture, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.findItem(R.id.mnAjoutVoiture).setVisible(true);
        menu.findItem(R.id.mnListeVoiture).setVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch (menuItem.getItemId()){


            case R.id.mnAjoutVoiture:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragAjoutVoiture);
                fragmentTransaction.commit();
                return true;

            case R.id.mnListeVoiture:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragListeMesVoitures);
                fragmentTransaction.commit();
                return true;



                default:
                    return super.onOptionsItemSelected(menuItem);
        }
    }



    public List<Voiture> CreerListeMesVoitures(){

        return Singleton.getInstance().getListeVoitures();
    }


    public void AjouterVoitureListe(Voiture voiture){
        Singleton.getInstance().AjoutVoiture_ListeVoitures(voiture);
    }


    public void ModifierVoitureListe(int index ,String _Marque, String _Modele, Integer _Annee,
                                    Double _Prix, boolean _StatutDispo, String _Description,
                                        Double _TarifJournalier, String _Categorie){

        Singleton.getInstance().Modifier_ListeVoitures( index , _Marque, _Modele,
                                                        _Annee, _Prix, _StatutDispo,
                                                            _Description, _TarifJournalier, _Categorie);
    }




}
