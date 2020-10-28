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
    int id;

    String marque;
    String modele;
    Integer annee;
    Double prix;
    String categorie;
    boolean statut;
    String description;
    Double tarifJourn;


    public Voiture(String _Marque, String _Modele, Integer _Annee,
                   Double _Prix, boolean _Statut, String _Description,
                        Double _TarifJournalier, String _Categorie) {
        this.marque = _Marque;
        this.modele = _Modele;
        this.annee = _Annee;
        this.prix = _Prix;
        this.statut = _Statut;
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

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return statut == voiture.statut &&
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
        return Objects.hash(marque, modele, annee, prix, statut, description, tarifJourn, categorie);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", prix=" + prix +
                ", statut=" + statut +
                ", categorie='" + categorie + '\'' +
                ", description='" + description + '\'' +
                ", TarifJournalier='" + tarifJourn  +
                '}';
    }
}
