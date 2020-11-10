package com.example.projetsession.Objets;

import java.util.Date;
import java.util.Objects;

public class Location {

    int id_client;
    int id_voiture;
    Date date_debut;
    Date date_fin;
    //TODO ==> Lieu collecte véhicule.


    public Location(){

    }

        public Location(int _Id_Client, int _Id_Voiture, Date _Date_Debut, Date _Date_Fin){
            this.id_client = _Id_Client;
            this.id_voiture =_Id_Voiture;
            this.date_debut = _Date_Debut;
            this.date_fin = _Date_Fin;
        }


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id_client == location.id_client &&
                id_voiture == location.id_voiture &&
                Objects.equals(date_debut, location.date_debut) &&
                Objects.equals(date_fin, location.date_fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_client, id_voiture, date_debut, date_fin);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id_client=" + id_client +
                ", id_voiture=" + id_voiture +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }
}
