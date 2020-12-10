package com.example.projetsession.Clients;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projetsession.Location.Adapter_Toute_Voiture;
import com.example.projetsession.Objets.Client;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.Voitures.Adapter_Voitures;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListeClients extends Fragment {

    InterfaceListe_Clients interfaceListeClients;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Client> listeClients;

    private RecyclerView rvListeclientvoitres;
    public Adapter_Clients adapter2;

    public ListeClients() {
        // Required empty public constructor
    }


    public interface InterfaceListe_Clients{
        List<Client> CreerListeClients();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_gestion_client, container, false);
        configView(view);
        remplirListeVoiture();
       /* recyclerView = view.findViewById(R.id.rvClients);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter_Clients(interfaceListeClients.CreerListeClients());
        recyclerView.setAdapter(adapter);*/

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceListeClients = (InterfaceListe_Clients) context;
    }

    public void configView(View v){
        rvListeclientvoitres = (RecyclerView) v.findViewById(R.id.rvListeClientVoitures);
        rvListeclientvoitres.setHasFixedSize(true);
        rvListeclientvoitres.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        rvListeclientvoitres.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter_Clients();
        rvListeclientvoitres.setAdapter(adapter);
    }


    public void remplirListeVoiture(){
        InterfaceServeur interfaceServeur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<List<Voiture>> call = interfaceServeur.getAllVoiture();

        call.enqueue(new Callback<List<Voiture>>() {
            @Override
            public void onResponse(Call<List<Voiture>> call, Response<List<Voiture>> response) {

                if (response.isSuccessful()) {
                    List<Voiture> listVoiture = response.body();

                    for (int i = 0; i < listVoiture.size(); i++) {
                        Voiture voiture = listVoiture.get(i);
                        //Toast.makeText(getContext(),"" + response.body().get(i),Toast.LENGTH_LONG).show();
                        adapter2.ajouterVoiture(voiture);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Voiture>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


}
