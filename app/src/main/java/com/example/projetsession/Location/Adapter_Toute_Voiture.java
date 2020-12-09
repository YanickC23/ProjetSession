package com.example.projetsession.Location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetsession.Objets.Image;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.squareup.picasso.Picasso;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Adapter_Toute_Voiture
        extends RecyclerView.Adapter<Adapter_Toute_Voiture.Holder>{

    String marque,modele,description,categorie,path;
    Integer annee,proprio;
    Double valeur,tarif;
    boolean Statut;


    private List<Voiture> voitureList;
    private List<Voiture> voitureListFull;
    public Adapter_Toute_Voiture(){
        voitureList = new ArrayList<>();
        voitureListFull = new ArrayList<>(voitureList);
    }

    public Adapter_Toute_Voiture(List<Voiture> voitureList){
        this.voitureList = voitureList;
        voitureListFull = new ArrayList<>(voitureList);
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

           holder.itemView.setVisibility(View.VISIBLE);
           holder.tvmodeteetmarque.setText(voiture.getMarqueModele());
           holder.tvannee.setText(Integer.toString(voiture.getAnnee()));
           holder.tvtafifs.setText(Double.toString(voiture.getTarif()) + "$");
           Picasso.get()
                   .load(RetrofitInstance.BASE_URL_IMAGE + "images/" + voiture.getPath()).fit().into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return voitureList.size();
    }

    public void ajouterVoiture(Voiture v){
        voitureList.add(v);
        notifyDataSetChanged();
    }

    public void modifierVoiture(int index,String marque,String modele,Integer annee,Double valeur,boolean Statut,
            String description, Double tarif, String categorie, Integer proprio, String path){
        voitureList.get(index).setMarque(marque);
        voitureList.get(index).setModele(modele);
        voitureList.get(index).setAnnee(annee);
        voitureList.get(index).setValeur(valeur);
        voitureList.get(index).setStatutDisponible(Statut);
        voitureList.get(index).setDescription(description);
        voitureList.get(index).setTarif(tarif);
        voitureList.get(index).setCategorie(categorie);
        voitureList.get(index).setProprio(proprio);
        voitureList.get(index).setPath(path);
        notifyItemChanged(index);
    }

    public void supprimerVoiture(int index){
        voitureList.remove(index);
        notifyItemRemoved(index);
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


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getLayoutPosition();
                    if(voitureList != voitureListFull) {
                        marque = voitureList.get(index).getMarque();
                        modele = voitureList.get(index).getModele();
                        annee = voitureList.get(index).getAnnee();
                        valeur = voitureList.get(index).getValeur();
                        Statut = voitureList.get(index).isStatutDisponible();
                        description = voitureList.get(index).getDescription();
                        tarif = voitureList.get(index).getTarif();
                        categorie = voitureList.get(index).getCategorie();
                        proprio = voitureList.get(index).getProprio();
                        path = voitureList.get(index).getPath();
                    }else{
                        marque = voitureListFull.get(index).getMarque();
                        modele = voitureListFull.get(index).getModele();
                        annee = voitureListFull.get(index).getAnnee();
                        valeur = voitureListFull.get(index).getValeur();
                        Statut = voitureListFull.get(index).isStatutDisponible();
                        description = voitureListFull.get(index).getDescription();
                        tarif = voitureListFull.get(index).getTarif();
                        categorie = voitureListFull.get(index).getCategorie();
                        proprio = voitureListFull.get(index).getProprio();
                        path = voitureListFull.get(index).getPath();
                    }

                }
            });
        }
    }

    public void updateList(List<Voiture> newList){
    voitureList = new ArrayList<>();
    voitureList.addAll(newList);
    notifyDataSetChanged();
    }
}
