package com.example.projetsession.ROOM;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Location;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.Objets.Voiture_Location;

@Database(entities = {Client.class, Voiture.class, Location.class, Voiture_Location.class}, version = 3, exportSchema = false)
public abstract class LocationDB extends RoomDatabase {

    public abstract ClientDAO cdao();
    public abstract VoitureDAO vdao();
    public abstract LocationDAO ldao();
    public abstract Voiture_LocationDAO vldao();

}
