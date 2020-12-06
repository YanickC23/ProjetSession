package com.example.projetsession.Location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetsession.Objets.Image;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Toute_Voiture extends RecyclerView.Adapter<Adapter_Toute_Voiture.Holder> {

    private List<Voiture> voitureList;
    public Adapter_Toute_Voiture(){
        voitureList = new ArrayList<>();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.liste_voiture_item,parent,false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
       Voiture voiture = voitureList.get(position);
       holder.tvmodeteetmarque.setText(voiture.getMarqueModele());
       holder.tvannee.setText(Integer.toString(voiture.getAnnee()));
       holder.tvtafifs.setText(Double.toString(voiture.getTarif()) + "$");
       Picasso.get()
                .load(RetrofitInstance.BASE_URL + voiture.getPath()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return voitureList.size();
    }

    public void ajouterVoiture(Voiture v){
        voitureList.add(v);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private ImageView photo;
        private TextView tvmodeteetmarque,tvannee,tvtafifs;

        public Holder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.imageDesVoiture);
            tvmodeteetmarque = itemView.findViewById(R.id.tv_toutlesvoituresMarqueetModele);
            tvannee = itemView.findViewById(R.id.tv_toutlesvoitureAnnee);
            tvtafifs = itemView.findViewById(R.id.tv_toutlesvoituresTafifs);
        }
    }
}
