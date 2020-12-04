package com.example.projetsession.ROOM;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.projetsession.Objets.Client_Voiture;
import com.example.projetsession.Objets.Location;
import com.example.projetsession.Objets.Voiture_Location;

import java.util.List;

@Dao
public interface Voiture_LocationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public long ajouterVoiture_Location(Location location);

    @Update
    public void miseAJourVoiture_Location(Location location);

    @Delete
    public void supprimerVoiture_Location(Location location);

    @Transaction
    @Query("SELECT * FROM Table_voiture")
    public List<Voiture_Location> getListeVoitureEnLocation();

    @Transaction
    @Query("SELECT * FROM Table_location")
    public List<Voiture_Location> getListeLocationsPourUneVoiture();


}
