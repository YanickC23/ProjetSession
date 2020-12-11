package com.example.projetsession.Objets;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "Table_client",
        indices = {@Index("id_client")})

public class Client implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_client")
    @Expose
    @SerializedName("id_client")
    public int id_client;

    @Expose
    @SerializedName("nom")
    String nom;
    @Expose
    @SerializedName("prenom")
    String prenom;
    @Expose
    @SerializedName("telephone")
    String telephone;
    @Expose
    @SerializedName("courriel")
    String courriel;
    @Expose
    @SerializedName("motdepasse")
    String motdepasse;
    @Expose
    @SerializedName("nopermis")
    String nopermis;
    @Expose
    @SerializedName("carte_credit")
    String carte_credit;

    @Expose
    @SerializedName("success")
    public String success;

    @Expose
    @SerializedName("message")
    public String message;


    public Client(){
    }


    public Client(String success,String mess,int _Id_client, String _Nom, String _Prenom, String _NoTel,
                    String _Email, String _MotDePasse, String _NoPermis,
                        String _Carte_credit){

       this.success = success;
       this.message = mess;
       this.id_client = _Id_client;
       this.nom = _Nom;
       this.prenom = _Prenom;
       this.telephone = _NoTel;
       this.courriel = _Email;
       this.motdepasse = _MotDePasse;
       this.nopermis = _NoPermis;
       this.carte_credit = _Carte_credit;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNopermis() {
        return nopermis;
    }

    public void setNopermis(String nopermis) {
        this.nopermis = nopermis;
    }

    public String getCarte_credit() {
        return carte_credit;
    }

    public void setCarte_credit(String carte_credit) {
        this.carte_credit = carte_credit;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id_client == client.id_client &&
                nom.equals(client.nom) &&
                prenom.equals(client.prenom) &&
                telephone.equals(client.telephone) &&
                Objects.equals(courriel, client.courriel) &&
                Objects.equals(motdepasse, client.motdepasse) &&
                nopermis.equals(client.nopermis) &&
                carte_credit.equals(client.carte_credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_client, nom, prenom, telephone, courriel, motdepasse, nopermis, carte_credit);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", nom='" + nom + '\'' +
                ", Prenom='" + prenom + '\'' +
                ", NoTel='" + telephone + '\'' +
                ", email='" + courriel + '\'' +
                ", motDePasse='" + motdepasse + '\'' +
                ", noPermis='" + nopermis + '\'' +
                ", carte_credit='" + carte_credit + '\'' +
                '}';
    }


}

