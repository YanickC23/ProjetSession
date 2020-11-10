package com.example.projetsession.Objets;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity(tableName = "Table_client")
public class Client {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    @SerializedName("id")
    public int id;

    @SerializedName("nom")
    String nom;
    @SerializedName("Prenom")
    String Prenom;
    @SerializedName("NoTel")
    String NoTel;
    @SerializedName("email")
    String email;
    @SerializedName("motDePasse")
    String motDePasse;
    //TODO ===> Ajout d'info NoPermisConduire, carte de crédit.

   public Client(){
    }


    public Client(String _Nom, String _Prenom, String _NoTel, String _Email, String _MotDePasse){
       this.nom = _Nom;
       this.Prenom = _Prenom;
       this.NoTel = _NoTel;
       this.email = _Email;
       this.motDePasse = _MotDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNoTel() {
        return NoTel;
    }

    public void setNoTel(String noTel) {
        NoTel = noTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nom, client.nom) &&
                Objects.equals(Prenom, client.Prenom) &&
                Objects.equals(NoTel, client.NoTel) &&
                Objects.equals(email, client.email) &&
                Objects.equals(motDePasse, client.motDePasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, Prenom, NoTel, email, motDePasse);
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", NoTel='" + NoTel + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }


}

