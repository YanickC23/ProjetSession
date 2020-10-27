package com.example.projetsession.Voitures;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;

import java.util.List;

public class Adapter_Voitures extends RecyclerView.Adapter<Adapter_Voitures.MonViewHolder> {


    private List<Voiture> listeVoitures;


    public Adapter_Voitures(List<Voiture>list){
        this.listeVoitures = list;
    }


    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_liste__mes_voitures, parent, false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position){

    }


    @Override
    public int getItemCount(){
        return listeVoitures.size();
    }






    public class MonViewHolder extends RecyclerView.ViewHolder{



        public MonViewHolder(View view){
            super(view);

        }
    }


}
