package com.example.projetsession.ROOM;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;

@Database(entities = {Client.class, Voiture.class}, version = 1)
public abstract class LocationDB extends RoomDatabase {

    public abstract ClientDAO cdao();
    public abstract VoitureDAO vdao();
}
