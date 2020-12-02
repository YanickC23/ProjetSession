package com.example.projetsession.ROOM;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetsession.Objets.Voiture;

import java.util.List;

@Dao
public interface VoitureDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public long ajouterVoiture(Voiture u);

    @Update
    public void miseAJourVoiture(Voiture u);

    @Delete
    public void supprimerVoiture(Voiture uc);

    @Query("DELETE FROM Table_Voiture")
    public void suprimerTous_Voiture();

    @Query("SELECT * FROM Table_Voiture where id_voiture like :id_voiture")
    public Voiture[] getVoiture(int id_voiture);

    /*@Query("SELECT * FROM Table_Voiture where proprio")
    public List<Voiture> getProprioVoiture(int id);*/

    @Query("SELECT * FROM Table_Voiture where id_voiture like :id_voiture")
    public List<Voiture> get_Voiture(String id_voiture);

    @Query("SELECT * FROM Table_Voiture")
    public List<Voiture> getListe_Voiture();

    @Query("SELECT * FROM Table_Voiture")
    public Voiture[] getTous_Voiture();

}
