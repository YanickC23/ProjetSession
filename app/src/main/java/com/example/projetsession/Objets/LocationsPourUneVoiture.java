package com.example.projetsession.Objets;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationsPourUneVoiture {

    @Embedded
    @SerializedName("id_Voitures")
    int id_Voitures;
    @Relation(parentColumn = "id_Voitures",
            entityColumn = "id_voiture",
            associateBy = @Junction(Voiture_Location.class))


    @SerializedName("liste_locationUneVoiture")
    List<Location> locations;

}
