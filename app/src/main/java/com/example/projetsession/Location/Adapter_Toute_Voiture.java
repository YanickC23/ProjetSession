package com.example.projetsession.Location;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetsession.Accueil.Accueil;
import com.example.projetsession.Objets.Image;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.RetrofitInstance;
import com.squareup.picasso.Picasso;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class Adapter_Toute_Voiture
        extends RecyclerView.Adapter<Adapter_Toute_Voiture.Holder>{

    String marque,modele,description,categorie,path;
    Integer annee,proprio;
    Double valeur,tarif;
    boolean Statut;

    Context context;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LouerVoiture fragListeVoitures;


    private List<Voiture> voitureList;
    private List<Voiture> voitureListFull;
    public Adapter_Toute_Voiture(){
        voitureList = new ArrayList<>();
        voitureListFull = new ArrayList<>(voitureList);
    }

    public Adapter_Toute_Voiture(List<Voiture> voitureList){
        this.voitureList = voitureList;
        voitureListFull = new ArrayList<>(voitureList);
        fragListeVoitures = new LouerVoiture();
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

                    //GestionLocation.AfficherVoitureinfolocation.afficherVoitureinfolocation();
                    //Intent intent = new Intent(itemView.getContext(), RecyclerView.Adapter.class);
                  /*  fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragListeVoitures);
                    fragmentTransaction.commit();*/
                    Intent intent = new Intent(itemView.getContext(),LouerVoiture.class);
                    intent.putExtra("index",index + ""); // j'ai du faire cela pour que l'integer ne soit pas null
                    intent.putExtra("marque",marque);
                    intent.putExtra("modele",modele);
                    intent.putExtra("annee", annee+"");
                    intent.putExtra("valeur",valeur+"");
                    intent.putExtra("Statut",Statut);
                    intent.putExtra("description",description);
                    intent.putExtra("tarif",tarif+"");
                    intent.putExtra("categorie",categorie);
                    intent.putExtra("proprio",proprio + "");
                    intent.putExtra("path",path);
                    ((GestionLocation) itemView.getContext()).startActivityForResult(intent,9952);





                }
            });
        }
    }

    public void updateList(List<Voiture> newList){
    voitureList = new ArrayList<>();
    voitureList.addAll(newList);
    notifyDataSetChanged();
    }


/*
    public interface OnTextClickListener {
        void onTextClick(Voiture data);
    }*/

}
