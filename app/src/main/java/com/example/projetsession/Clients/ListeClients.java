package com.example.projetsession.Clients;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Voitures.Adapter_Voitures;

import java.util.List;


public class ListeClients extends Fragment {

    InterfaceListe_Clients interfaceListeClients;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Client> listeClients;

    public ListeClients() {
        // Required empty public constructor
    }


    public interface InterfaceListe_Clients{
        List<Client> CreerListeClients();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_gestion_client, container, false);
        recyclerView = view.findViewById(R.id.rvClients);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter_Clients(interfaceListeClients.CreerListeClients());
        recyclerView.setAdapter(adapter);

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceListeClients = (InterfaceListe_Clients) context;
    }


}
