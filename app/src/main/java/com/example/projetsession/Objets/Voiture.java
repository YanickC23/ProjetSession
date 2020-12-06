package com.example.projetsession.Objets;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "Table_voiture",
        indices = {@Index("id_voiture"), @Index("proprio")},
        foreignKeys = {@ForeignKey(entity = Client.class,
                        parentColumns = "id_client",
                        childColumns = "proprio",
                        onDelete = CASCADE)})

public class Voiture implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_voiture")
    @Expose
    @SerializedName("id_voiture")
    public int id_voiture;

    @Expose
    @SerializedName("marque")
    String marque;
    @Expose
    @SerializedName("modele")
    String modele;
    @Expose
    @SerializedName("annee")
    Integer annee;
    @Expose
    @SerializedName("valeur")
    Double valeur;
    @Expose
    @SerializedName("categorie")
    String categorie;
    @Expose
    @SerializedName("statutDisponible")
    boolean statutDisponible;
    @Expose
    @SerializedName("description")
    String description;
    @Expose
    @SerializedName("tarif")
    Double tarif;
    @Expose
    @SerializedName("proprio")
    Integer proprio;
    @Expose
    @SerializedName("path")
    public String path;

    public Voiture(int _Id_voiture, String _Marque, String _Modele, Integer _Annee,
                   Double _Prix, boolean _StatutDispo, String _Description,
                        Double _TarifJournalier, String _Categorie, Integer _Proprio, String path) {

        this.id_voiture = _Id_voiture;
        this.marque = _Marque;
        this.modele = _Modele;
        this.annee = _Annee;
        this.valeur = _Prix;
        this.statutDisponible = _StatutDispo;
        this.description = _Description;
        this.tarif = _TarifJournalier;
        this.categorie = _Categorie;
        this.proprio = _Proprio;
        this.path = path;
    }


        public Voiture(){

        }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
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

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
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

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }


    public String getMarqueModele(){
        return marque + " " + modele;
    }


    public Integer getProprio() {
        return proprio;
    }

    public void setProprio(Integer proprio) {
        this.proprio = proprio;
    }

    //pour les photos
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id_voiture=" + id_voiture +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", prix=" + valeur +
                ", categorie='" + categorie + '\'' +
                ", statutDisponible=" + statutDisponible +
                ", description='" + description + '\'' +
                ", tarifJourn=" + tarif +
                ", proprio=" + proprio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return id_voiture == voiture.id_voiture &&
                statutDisponible == voiture.statutDisponible &&
                marque.equals(voiture.marque) &&
                modele.equals(voiture.modele) &&
                annee.equals(voiture.annee) &&
                valeur.equals(voiture.valeur) &&
                categorie.equals(voiture.categorie) &&
                description.equals(voiture.description) &&
                tarif.equals(voiture.tarif) &&
                Objects.equals(proprio, voiture.proprio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_voiture, marque, modele, annee, valeur, categorie, statutDisponible, description, tarif, proprio);
    }

}
