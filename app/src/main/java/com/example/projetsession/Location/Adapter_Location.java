package com.example.projetsession.Location;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.Voitures.Adapter_Voitures;
import com.example.projetsession.Voitures.FicheVoiture;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Adapter_Location extends RecyclerView.Adapter<Adapter_Location.MonViewHolder>{

    FicheVoiture fragFicheVoiture;
    private List<Voiture> listeVoitures;
    AlertDialog.Builder builder;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;




    public Adapter_Location(List<Voiture>list){

        this.listeVoitures = list;
    }



    @NonNull
    @Override
    public Adapter_Location.MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_liste__mes_voitures, parent, false);
        Context context = view.getContext();
        builder = new AlertDialog.Builder(context);
        return new Adapter_Location.MonViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull Adapter_Location.MonViewHolder holder, int position){

        holder.tvMarqueModele.setText(Singleton.getInstance().Obt_MarqueModele(position).toString());
        holder.tvAnnee.setText(Integer.toString(Singleton.getInstance().Obt_AnneeVoiture(position)));
        holder.tvCategorie.setText(Singleton.getInstance().Obt_CategorieVoiture(position).toString());
        holder.tvTarif.setText(Double.toString(Singleton.getInstance().Obt_TarifJournVoiture(position)));
        holder.tvValeur.setText(Double.toString(Singleton.getInstance().Obt_PrixVoiture(position)));
        holder.tvStatutDispo.setText(Singleton.getInstance().Obt_Statut(position).toString());

    }


    @Override
    public int getItemCount(){
        return listeVoitures.size();
    }






    public class MonViewHolder extends RecyclerView.ViewHolder{

        TextView tvMarqueModele, tvAnnee, tvCategorie,
                tvTarif, tvValeur, tvStatutDispo;


        public MonViewHolder(View view){
            super(view);

            tvMarqueModele = view.findViewById(R.id.tvMarqueModele);
            tvAnnee = view.findViewById(R.id.tvAnne);
            tvCategorie = view.findViewById(R.id.tvCategorie);
            tvTarif = view.findViewById(R.id.tvTarif);
            tvValeur = view.findViewById(R.id.tvValeur);
            tvStatutDispo = view.findViewById(R.id.tvStatut);
            fragFicheVoiture = new FicheVoiture();

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    int position;
                    position = getAdapterPosition();


                    SharedPreferences pref = view.getContext().getSharedPreferences("PositLstMVoit",MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("PositLstMVoit", position);
                    editor.commit();

                    fragmentManager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flFrag_GestVoiture, fragFicheVoiture);
                    fragmentTransaction.commit();




                }
            });

        }
    }




}
