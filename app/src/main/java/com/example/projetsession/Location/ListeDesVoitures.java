package com.example.projetsession.Location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projetsession.Accueil.Accueil;
import com.example.projetsession.Objets.Voiture;
import com.example.projetsession.R;
import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeDesVoitures extends AppCompatActivity {

    private RecyclerView rvListedesvoitres;
    private Adapter_Toute_Voiture adapter_toute_voiture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_voitures);

        configView();
        remplirListeVoiture();
    }

    public void configView(){
        rvListedesvoitres = (RecyclerView) this.findViewById(R.id.rvListeDesVoitures);
        rvListedesvoitres.setHasFixedSize(true);
        rvListedesvoitres.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        rvListedesvoitres.setLayoutManager(new LinearLayoutManager(this));
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
                    //Toast.makeText(ListeDesVoitures.this,"" + response.body().get(0),Toast.LENGTH_LONG).show();

                    for (int i = 0; i < listVoiture.size(); i++) {
                        Voiture voiture = listVoiture.get(i);
                        Toast.makeText(ListeDesVoitures.this,"" + response.body().get(i),Toast.LENGTH_LONG).show();
                        adapter_toute_voiture.ajouterVoiture(voiture);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Voiture>> call, Throwable t) {
                Toast.makeText(ListeDesVoitures.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}