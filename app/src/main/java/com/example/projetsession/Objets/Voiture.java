package com.example.projetsession.Objets;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "Table_voiture",
        indices = {@Index("id_voiture"), @Index("proprio")},
        foreignKeys = {@ForeignKey(entity = Client.class,
                        parentColumns = "id_client",
                        childColumns = "proprio",
                        onDelete = CASCADE)})

public class Voiture {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_voiture")
    @SerializedName("id_voiture")
    public int id_voiture;

    @SerializedName("marque")
    String marque;
    @SerializedName("modele")
    String modele;
    @SerializedName("annee")
    Integer annee;
    @SerializedName("prix")
    Double prix;
    @SerializedName("categorie")
    String categorie;
    @SerializedName("statutDisponible")
    boolean statutDisponible;
    @SerializedName("descript")
    String descript;
    @SerializedName("tarifJourn")
    Double tarifJourn;
    @SerializedName("proprio")
    Integer proprio;

    public Voiture(int _Id_voiture, String _Marque, String _Modele, Integer _Annee,
                   Double _Prix, boolean _StatutDispo, String _Description,
                        Double _TarifJournalier, String _Categorie, Integer _Proprio) {

        this.id_voiture = _Id_voiture;
        this.marque = _Marque;
        this.modele = _Modele;
        this.annee = _Annee;
        this.prix = _Prix;
        this.statutDisponible = _StatutDispo;
        this.descript = _Description;
        this.tarifJourn = _TarifJournalier;
        this.categorie = _Categorie;
        this.proprio = _Proprio;
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

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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


    public Integer getProprio() {
        return proprio;
    }

    public void setProprio(Integer proprio) {
        this.proprio = proprio;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id_voiture=" + id_voiture +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", prix=" + prix +
                ", categorie='" + categorie + '\'' +
                ", statutDisponible=" + statutDisponible +
                ", descript='" + descript + '\'' +
                ", tarifJourn=" + tarifJourn +
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
                prix.equals(voiture.prix) &&
                categorie.equals(voiture.categorie) &&
                descript.equals(voiture.descript) &&
                tarifJourn.equals(voiture.tarifJourn) &&
                Objects.equals(proprio, voiture.proprio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_voiture, marque, modele, annee, prix, categorie, statutDisponible, descript, tarifJourn, proprio);
    }

}
