package com.example.projetsession;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;

import java.util.ArrayList;
import java.util.List;

public class Singleton {


    private static Singleton Singlt;
    private List<Voiture> listeVoiture = new ArrayList<Voiture>();
    private List<Voiture> listeMesVoiture = new ArrayList<Voiture>();
    private List<Client> listeClients = new ArrayList<Client>();


    private Singleton(){

    }

    public static Singleton getInstance() {
        if (Singlt == null) {
            Singlt = new Singleton();

        }
        return Singlt;
    }




}
