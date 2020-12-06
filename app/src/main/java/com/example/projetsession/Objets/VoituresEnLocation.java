package com.example.projetsession.Objets;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VoituresEnLocation {

    @Embedded
    @SerializedName("id_location")
    int id_location;
    @Relation(parentColumn = "id_location",
            entityColumn = "id_location",
            associateBy = @Junction(Voiture_Location.class))


    @SerializedName("id_voiture")
    List<Voiture> voitures;

}
