package com.example.projetsession.Location;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Voitures.Adapter_Voitures;

import java.util.Date;
import java.util.List;


public class ListeVoitures extends Fragment {

    InterfaceListe_LocationVoiture interfaceListe_locationVoiture;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Voiture> listeVoitures;




    public ListeVoitures() {
        // Required empty public constructor
    }

    public interface InterfaceListe_LocationVoiture{
        List<Voiture> CreerListeLocationVoitures();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_liste_voitures, container, false);

      /*  recyclerView = view.findViewById(R.id.rvLocation);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter_Voitures(interfaceListe_locationVoiture.CreerListeLocationVoitures());
        recyclerView.setAdapter(adapter);*/

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
