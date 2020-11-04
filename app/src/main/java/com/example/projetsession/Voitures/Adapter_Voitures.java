package com.example.projetsession.Voitures;


import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;

import java.util.List;

public class Adapter_Voitures extends RecyclerView.Adapter<Adapter_Voitures.MonViewHolder> {

    FicheVoiture fragFicheVoiture;
    private List<Voiture> listeVoitures;
    AlertDialog.Builder builder;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    private Interface_AdapterVoiture interface_adapterVoiture;

    public Adapter_Voitures(List<Voiture>list){

        this.listeVoitures = list;
    }




    public interface Interface_AdapterVoiture{
        int positVoiture_a_FicheVoiture(int position);
    }

    public void lstVoit_Listener(Interface_AdapterVoiture interface_adapterVoiture){
        this.interface_adapterVoiture = interface_adapterVoiture;
    }




    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_liste__mes_voitures, parent, false);
        Context context = view.getContext();
        builder = new AlertDialog.Builder(context);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position){

        holder.tvMarque.setText(listeVoitures.get(position).getMarque());
        holder.tvModele.setText(listeVoitures.get(position).getModele());
        holder.tvAnnee.setText(listeVoitures.get(position).getAnnee().toString());
        holder.tvCategorie.setText(listeVoitures.get(position).getCategorie());
        holder.tvTarif.setText(listeVoitures.get(position).getTarifJourn().toString());
        holder.tvValeur.setText(listeVoitures.get(position).getPrix().toString());
        holder.tvStatutDispo.setText(listeVoitures.get(position).getStatutLocation());

    }


    @Override
    public int getItemCount(){
        return listeVoitures.size();
    }






    public class MonViewHolder extends RecyclerView.ViewHolder{

        TextView tvMarque, tvModele, tvAnnee, tvCategorie,
                tvTarif, tvValeur, tvStatutDispo;


        public MonViewHolder(View view){
            super(view);

            tvMarque = view.findViewById(R.id.tvMarque);
            tvModele = view.findViewById(R.id.tvModele);
            tvAnnee = view.findViewById(R.id.tvAnne);
            tvCategorie = view.findViewById(R.id.tvCategorie);
            tvTarif = view.findViewById(R.id.tvTarif);
            tvValeur = view.findViewById(R.id.tvValeur);
            tvStatutDispo = view.findViewById(R.id.tvStatut);
            fragFicheVoiture = new FicheVoiture();

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Integer position;
                    position = getAdapterPosition();

                    interface_adapterVoiture.positVoiture_a_FicheVoiture(position);
                    fragmentManager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragFicheVoiture);
                    fragmentTransaction.commit();




                }
            });

        }
    }


}
