package com.example.projetsession.ROOM;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.projetsession.Objets.Client_Voiture;

import java.util.List;


@Dao
public interface client_voitureDAO {

    @Transaction
    @Query("SELECT * FROM Table_client")
    public List<Client_Voiture> getClientVoiture();


}
