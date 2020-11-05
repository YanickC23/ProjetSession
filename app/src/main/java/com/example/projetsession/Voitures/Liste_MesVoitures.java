package com.example.projetsession.Voitures;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;

import java.util.List;


public class Liste_MesVoitures extends Fragment {


    InterfaceListe_MesVoiture interfaceListeMesVoiture;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Voiture> listeVoitures;



    public Liste_MesVoitures() {
        // Required empty public constructor
    }

    public interface InterfaceListe_MesVoiture{
            List<Voiture> CreerListeMesVoitures();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_gestion_voitures, container, false);

        recyclerView = view.findViewById(R.id.rvMesVoitures);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter_Voitures(interfaceListeMesVoiture.CreerListeMesVoitures());
        recyclerView.setAdapter(adapter);

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceListeMesVoiture = (InterfaceListe_MesVoiture)context;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


    }




}
