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
        extends RecyclerView.Adapter<Adapter_Toute_Voiture.Holder>
implements Filterable {

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

    @Override
    public Filter getFilter() {
        return voiturefilter;
    }

    private Filter voiturefilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
           List<Voiture> listfiltre = new ArrayList<Voiture>();

          if(constraint == null || constraint.length() == 0){
              listfiltre.addAll(voitureListFull);
          }else {
              String filterPattern = constraint.toString().toLowerCase().trim();
              for(Voiture voiture : voitureListFull){
                  if(voiture.getMarqueModele().toLowerCase().contains(filterPattern)){
                      listfiltre.add(voiture);
                  }
              }
          }
          FilterResults results = new FilterResults();
          results.values = listfiltre;

          return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            voitureList.clear();
            voitureList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

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
