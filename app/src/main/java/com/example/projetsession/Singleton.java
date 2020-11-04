package com.example.projetsession;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;

import java.util.ArrayList;
import java.util.List;

public class Singleton {


    private static Singleton Singlt;
    private List<Voiture> listeVoitures = new ArrayList<Voiture>();
    private List<Voiture> listeMesVoiture = new ArrayList<Voiture>();
    private List<Client> listeClients = new ArrayList<Client>();


    private Singleton(){

    }

    public static Singleton getInstance() {
        if (Singlt == null) {
            Singlt = new Singleton();

        }
        return Singlt;
    }


    public static com.example.projetsession.Singleton getSinglt() {
        return Singlt;
    }

    public static void setSinglt(Singleton singlt){
        Singlt = singlt;
    }


    public List<Voiture> getListeVoitures() {
        return listeVoitures;
    }

    public List<Voiture> getListeMesVoiture() {
        return listeMesVoiture;
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    public void setListeVoitures(List<Voiture> listeVoitures) {
        this.listeVoitures = listeVoitures;
    }

    public void setListeMesVoiture(List<Voiture> listeMesVoiture) {
        this.listeMesVoiture = listeMesVoiture;
    }

    public void setListeClients(List<Client> listeClients) {
        this.listeClients = listeClients;
    }

    @NonNull
    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object){
        return super.equals(object);
    }


    public void AjoutVoiture_ListeVoitures(Voiture voiture){
        listeVoitures.add(voiture);
    }

    public void Modifier_ListeVoitures(int index ,String _Marque, String _Modele, Integer _Annee,
                                     Double _Prix, boolean _StatutDispo, String _Description,
                                     Double _TarifJournalier, String _Categorie){

        listeVoitures.get(index).setMarque(_Marque);
        listeVoitures.get(index).setModele(_Modele);
        listeVoitures.get(index).setAnnee(_Annee);
        listeVoitures.get(index).setPrix(_Prix);
        listeVoitures.get(index).setStatutDisponible(_StatutDispo);
        listeVoitures.get(index).setDescription(_Description);
        listeVoitures.get(index).setTarifJourn(_TarifJournalier);
        listeVoitures.get(index).setCategorie(_Categorie);

    }


    public String Obt_MarqueVoiture(int index){
        return listeVoitures.get(index).getMarque();
    }
    public String Obt_ModeleVoiture(int index){
        return listeVoitures.get(index).getMarque();
    }
    public int Obt_AnneeVoiture(int index){
        return listeVoitures.get(index).getAnnee();
    }
    public double Obt_PrixVoiture(int index){
        return listeVoitures.get(index).getPrix();
    }
    public String Obt_DescriptionVoiture(int index){
        return listeVoitures.get(index).getDescription();
    }
    public double Obt_TarifJournVoiture(int index){
        return listeVoitures.get(index).getTarifJourn();
    }
    public String Obt_CategorieVoiture(int index){
        return listeVoitures.get(index).getCategorie();
    }





}
