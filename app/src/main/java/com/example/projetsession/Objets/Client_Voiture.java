package com.example.projetsession.Objets;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import java.util.List;

/*
@Entity(tableName = "Table_client_voiture",
        indices = {@Index("id_voiture"), @Index("id_client")},
        primaryKeys = {"id_voiture", "id_client"},
        foreignKeys = {@ForeignKey(entity = Voiture.class,
                                    parentColumns = "id_voiture",
                                    childColumns = "id_voiture"),
                                    @ForeignKey(entity = Client.class,
                                            parentColumns = "id_client",
                                            childColumns = "id_client")}
)*/



public class Client_Voiture {


    @Embedded
    @SerializedName("id_client")
    int id_client;
    @Relation(parentColumn = "id_client",
              entityColumn = "proprio")


    @SerializedName("liste_voituresClient")
     List<Voiture> voitures;



/*
    Client_Voiture(){

    }

    Client_Voiture(int _Id_voiture, int _Id_client){
        this.id_voiture = _Id_voiture;
        this.id_client = _Id_client;
    }


    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client_Voiture that = (Client_Voiture) o;
        return id_voiture == that.id_voiture &&
                id_client == that.id_client;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_voiture, id_client);
    }

    @Override
    public String toString() {
        return "Client_Voiture{" +
                "id_voiture=" + id_voiture +
                ", id_client=" + id_client +
                '}';
    }


 */
}
