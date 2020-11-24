package com.example.projetsession.ROOM;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetsession.Objets.Client;

import java.util.List;

@Dao
public interface ClientDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public long ajouterClient(Client u);

    @Update
    public void miseAJourClient(Client u);

    @Delete
    public void supprimerClient(Client u);

    @Query("DELETE FROM Table_Client")
    public void suprimerToutClients();

    @Query("SELECT * FROM Table_Client")
    public Client[] getClients_Tous();

    @Query("SELECT * FROM Table_Client WHERE id LIKE :id")
    public Client[] getClients(int id);

    @Query("SELECT * FROM Table_Client")
    public List<Client> get_ListeClients();


    @Query("SELECT * FROM Table_Client WHERE email LIKE :email")
    public Client[] get_MDP_Client(String email);



   /* @Query("SELECT * FROM table_user where email LIKE '%' ||  || '%'")
    public Client[] getuser();*/

    /*@Query("SELECT email,password FROM table_user WHERE (email LIKE :email AND password LIKE :password)")
    public abstract List<Client> login(String email, String password);*/

}
