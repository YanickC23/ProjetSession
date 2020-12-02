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


@Entity(tableName = "Table_voiture_location",
        indices = {@Index("id_location"), @Index("id_voiture")},
        foreignKeys = {@ForeignKey(entity = Voiture.class,
                                            parentColumns = "id_voiture",
                                            childColumns = "id_voiture"),
                        @ForeignKey(entity = Location.class,
                                             parentColumns = "id_location",
                                             childColumns = "id_location")}
)

public class Voiture_Location {


    @SerializedName("id_voiture")
    int id_voiture;
    @SerializedName("id_location")
    int id_location;


    Voiture_Location(){

    }

    Voiture_Location(int _Id_voiture, int _Id_location){
        this.id_voiture = _Id_voiture;
        this.id_location = _Id_location;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture_Location that = (Voiture_Location) o;
        return id_voiture == that.id_voiture &&
                id_location == that.id_location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_voiture, id_location);
    }

    @Override
    public String toString() {
        return "Voiture_Location{" +
                "id_voiture=" + id_voiture +
                ", id_location=" + id_location +
                '}';
    }
}
