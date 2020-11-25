package com.example.projetsession.Objets;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "Table_voiture")
public class Voiture {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    public int id_voiture;

    String marque;
    String modele;
    Integer annee;
    Double prix;
    String categorie;
    boolean statutDisponible;
    String description;
    Double tarifJourn;


    public Voiture(String _Marque, String _Modele, Integer _Annee,
                   Double _Prix, boolean _StatutDispo, String _Description,
                        Double _TarifJournalier, String _Categorie) {
        this.marque = _Marque;
        this.modele = _Modele;
        this.annee = _Annee;
        this.prix = _Prix;
        this.statutDisponible = _StatutDispo;
        this.description = _Description;
        this.tarifJourn = _TarifJournalier;
        this.categorie = _Categorie;
    }


        public Voiture(){

        }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public boolean isStatutDisponible() {
        return statutDisponible;
    }

    public String getStatutLocation(){

        if (isStatutDisponible()== true){
            return "Disponible";
        }
        else{
            return "Louée";
        }
    }


    public void setStatutDisponible(boolean statutDisponible) {
        this.statutDisponible = statutDisponible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTarifJourn() {
        return tarifJourn;
    }

    public void setTarifJourn(Double tarifJourn) {
        this.tarifJourn = tarifJourn;
    }


    public String getMarqueModele(){
        return marque + " " + modele;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return statutDisponible == voiture.statutDisponible &&
                Objects.equals(marque, voiture.marque) &&
                Objects.equals(modele, voiture.modele) &&
                Objects.equals(annee, voiture.annee) &&
                Objects.equals(prix, voiture.prix) &&
                Objects.equals(description, voiture.description)&&
                Objects.equals(categorie, voiture.categorie)&&
                Objects.equals(tarifJourn, voiture.tarifJourn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque, modele, annee, prix, statutDisponible, description, tarifJourn, categorie);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", prix=" + prix +
                ", statutDisponible=" + statutDisponible +
                ", categorie='" + categorie + '\'' +
                ", description='" + description + '\'' +
                ", TarifJournalier='" + tarifJourn  +
                '}';
    }
}
