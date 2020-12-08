package com.example.projetsession.Location;

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

import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListeVoitures extends Fragment {

    InterfaceListe_LocationVoiture interfaceListe_locationVoiture;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Voiture> listeVoitures;

    private RecyclerView rvListedesvoitres;
    public Adapter_Toute_Voiture adapter_toute_voiture;


    public ListeVoitures() {
        // Required empty public constructor
    }

    public interface InterfaceListe_LocationVoiture{
        List<Voiture> CreerListeLocationVoitures();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_liste_des_voitures, container, false);


        configView(view);
        remplirListeVoiture();

      /*  recyclerView = view.findViewById(R.id.rvLocation);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter_Voitures(interfaceListe_locationVoiture.CreerListeLocationVoitures());
        recyclerView.setAdapter(adapter);*/

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void configView(View v){
        rvListedesvoitres = (RecyclerView) v.findViewById(R.id.rvListeDesVoitures);
        rvListedesvoitres.setHasFixedSize(true);
        rvListedesvoitres.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        rvListedesvoitres.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter_toute_voiture = new Adapter_Toute_Voiture();
        rvListedesvoitres.setAdapter(adapter_toute_voiture);
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
                        adapter_toute_voiture.ajouterVoiture(voiture);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Voiture>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
