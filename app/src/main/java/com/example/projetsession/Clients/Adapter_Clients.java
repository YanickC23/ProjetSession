package com.example.projetsession.Clients;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
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

import com.example.projetsession.Objets.Client;
import com.example.projetsession.R;
import com.example.projetsession.Singleton;
import com.example.projetsession.Voitures.FicheVoiture;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Adapter_Clients  extends RecyclerView.Adapter<Adapter_Clients.MonViewHolder>{

    ModificationCompte fragModifCompte;
    private List<Client> listeClients;
    AlertDialog.Builder builder;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;




    public Adapter_Clients(List<Client>list){
        this.listeClients = list;
    }



    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_liste_clients, parent, false);
        Context context = view.getContext();
        builder = new AlertDialog.Builder(context);
        return new MonViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position){
        holder.tvPrenom.setText(Singleton.getInstance().Obt_PrenomClient(position));
        holder.tvNom.setText(Singleton.getInstance().Obt_NomClient(position));
        //Toast.makeText(holder.tvNom.getContext(),Singleton.getInstance().Obt_PrenomClient(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount(){
        return listeClients.size();
    }







    public class MonViewHolder extends RecyclerView.ViewHolder{

        TextView tvPrenom, tvNom;


        public MonViewHolder(View view){
            super(view);

            tvPrenom = view.findViewById(R.id.tvPrenomClient);
            tvNom = view.findViewById(R.id.tvNomClient);
            fragModifCompte = new ModificationCompte();


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    int position;
                    position = getAdapterPosition();


                    SharedPreferences pref = view.getContext().getSharedPreferences("PositLstClients",MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("PositLstClients", position);
                    editor.commit();

                    fragmentManager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flFrag_GestClient, fragModifCompte);
                    fragmentTransaction.commit();




                }
            });

        }
    }






}
