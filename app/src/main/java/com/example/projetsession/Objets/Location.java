package com.example.projetsession.Objets;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "Table_location",
        indices = {@Index("id_location"), @Index("id_client")},
        foreignKeys = {@ForeignKey(entity = Client.class,
                                            parentColumns = "id_client",
                                            childColumns = "proprio",
                                            onDelete = CASCADE)})

public class Location {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_location")
    @SerializedName("id_location")
    public int id_location;


    @SerializedName("id_client")
    int id_client;
    @SerializedName("date_debut")
    Date date_debut;
    @SerializedName("date_fin")
    Date date_fin;
    //TODO ==> Lieu collecte véhicule.


    public Location(){

    }

        public Location(int _Id_location, int _Id_Client, Date _Date_Debut, Date _Date_Fin){
            this.id_location = _Id_location;
            this.id_client = _Id_Client;
            this.date_debut = _Date_Debut;
            this.date_fin = _Date_Fin;
        }

    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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

    @Override
    public String toString() {
        return "Location{" +
                "id_location=" + id_location +
                ", id_client=" + id_client +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id_location == location.id_location &&
                id_client == location.id_client &&
                date_debut.equals(location.date_debut) &&
                date_fin.equals(location.date_fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_location, id_client, date_debut, date_fin);
    }

}
