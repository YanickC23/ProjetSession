package com.example.projetsession.ROOM;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;

@Database(entities = {Client.class, Voiture.class}, version = 2, exportSchema = false)
public abstract class LocationDB extends RoomDatabase {

    public abstract ClientDAO cdao();
    public abstract VoitureDAO vdao();
    public abstract LocationDAO ldao();


}
