package com.example.projetsession.Location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetsession.Objets.Location;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Location extends RecyclerView.Adapter<Adapter_Location.Holder>{

    private List<Location> location_list;

    public Adapter_Location(){
        location_list = new ArrayList<>();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //View row = inflater.inflate(?,parent,false);
        return null;//new Holder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return location_list.size();
    }

    public void ajouter_location(){

    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
