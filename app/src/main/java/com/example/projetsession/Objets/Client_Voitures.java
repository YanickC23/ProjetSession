package com.example.projetsession.Objets;


import androidx.room.Embedded;
import androidx.room.Relation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Client_Voitures {

    @SerializedName("client")
    @Embedded  Client client;

    @Relation(parentColumn = "id_client",
                entityColumn = "proprio")

    @SerializedName("listeVoituresDuClient")
    List<Voiture> lstVoitures;


}
