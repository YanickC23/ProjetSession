package com.example.projetsession.ROOM;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetsession.Objets.Location;
import com.example.projetsession.Objets.Voiture;

import java.util.List;

@Dao
public interface LocationDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public long ajouterLocation(Location u);

    @Update
    public void miseAJourLocation(Location u);

    @Delete
    public void supprimerLocation(Location uc);

    @Query("DELETE FROM Table_location")
    public void suprimerTous_Location();

    @Query("SELECT * FROM Table_location where id_location like :id_location")
    public Location[] getLocation(int id_location);





}
