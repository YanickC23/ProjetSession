package com.example.projetsession.Accueil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.projetsession.Clients.GestionClients;
import com.example.projetsession.Location.GestionLocation;
import com.example.projetsession.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PageAccueil extends Fragment  {

    Login login;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    InterfacePageAccueil interfacePageAccueil;
    Spinner spinner;
    Button btnAcces;
    BottomNavigationView bottomNavAccueil;

    public PageAccueil() {
        // Required empty public constructor
    }

    public interface InterfacePageAccueil{
            void CacherBarreNav();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
          interfacePageAccueil = (InterfacePageAccueil) context;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_page_accueil, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){



        spinner = view.findViewById(R.id.spnConnectInscr);
        login = new Login();

        interfacePageAccueil.CacherBarreNav();

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this.getContext(),
                                                R.array.SpinnerChoix, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
                switch (item){

                    case "Me Connecter":
                        fragmentManager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.flFragAccueil, login);
                        fragmentTransaction.commit();
                        break;

                    case "M'Inscrire":
                        Intent intent = new Intent(view.getContext(), GestionClients.class);
                        intent.putExtra("FragmentDemande", "CreationCompte");
                        startActivity(intent);
                        break;
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });


        btnAcces = view.findViewById(R.id.btnAcces);
        btnAcces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GestionLocation.class);
                intent.putExtra("FragmentDemande", "ListeVoiture");
                startActivity(intent);
            }
        });





    }







}
