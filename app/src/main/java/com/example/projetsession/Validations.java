package com.example.projetsession;

import android.widget.EditText;

public class Validations {




    public boolean Validation_String(EditText entreeUtilisateur){
         boolean valide = true;
         String valeur = entreeUtilisateur.getText().toString();

         if(valeur.length()==0){
             entreeUtilisateur.requestFocus();
             entreeUtilisateur.setError("Ce champs est vide");
             valide = false;
         }
         else if(!valeur.matches("((^[A-Z a-z - ' \\ áÁàÀâÂäÄéÉèÈëËêÊíÍîÎïÏóÓôÔòÒöÖúÚùÙûÛüÜçÇ\\\\s\\-]+$){1})")){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Vous devez entrer seulement des caratères");
            valide = false;
        }

         return valide;
    }

    public boolean Validation_Numerique_Int(EditText entreeUtilisateur){
        boolean valide = true;
        String valeur = entreeUtilisateur.getText().toString();

        if(valeur.length()==0){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Ce champs est vide");
            valide = false;
        }
        else if(!valeur.matches("((^[0-9]+$){1})")){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Vous devez entrer seulement des chiffres");
            valide = false;
        }

        return valide;
    }

    public boolean Validation_Numerique_Decimal(EditText entreeUtilisateur){
        boolean valide = true;
        String valeur = entreeUtilisateur.getText().toString();

        if(valeur.length()==0){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Ce champs est vide");
            valide = false;
        }
        else if(!valeur.matches("(^(([0-9]+)([,.]?)([0-9]+)){1}$)")){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Vous devez entrer seulement des chiffres");
            valide = false;
        }

        return valide;
    }

    public boolean Validation_Telephone(EditText entreeUtilisateur){
        boolean valide = true;
        String valeur = entreeUtilisateur.getText().toString();

        if(valeur.length()==0){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Ce champs est vide");
            valide = false;
        }
        else if(!valeur.matches("((^([(]*)(([0-9]{3}){1})([)]*)([ -]*)(([0-9]{3}){1})([ -]*)(([0-9]{4}){1})$){1})")){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Le numéro de téléphone n'est pas valide");
            valide = false;
        }

        return valide;
    }

    public boolean Validation_Email(EditText entreeUtilisateur){
        boolean valide = true;
        String valeur = entreeUtilisateur.getText().toString();

        if(valeur.length()==0){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Ce champs est vide");
            valide = false;
        }
        else if(!valeur.matches("^(.+)(@)((.+)([\\.]{1})(.+))+$")){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("L'adresse Courriel n'est pas valide");
            valide = false;
        }

        return valide;
    }

    public boolean Validation_AlphaNumerique(EditText entreeUtilisateur){
        boolean valide = true;
        String valeur = entreeUtilisateur.getText().toString();

        if(valeur.length()==0){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Ce champs est vide");
            valide = false;
        }
        else if(!valeur.matches("((^[A-Z a-z 0-9 |(){}\\[\\]#!%?&*-+\\/=,.;:`'\\\"«»°_\\ áÁàÀâÂäÄéÉèÈëËêÊíÍîÎïÏóÓôÔòÒöÖúÚùÙûÛüÜçÇ\\\\s\\-]+$){1})")){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Vous devez entrer seulement des caratères valides");
            valide = false;
        }

        return valide;
    }


    public boolean Validation_MotDePasse(EditText entreeUtilisateur){
        boolean valide = true;
        String valeur = entreeUtilisateur.getText().toString();

        if(valeur.length()==0){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Ce champs est vide");
            valide = false;
        }
        else if(!valeur.matches("((^(?=.*?[0-9])(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#!\"$%?&*()_+|=\\/*]).{8,}$))")){
            entreeUtilisateur.requestFocus();
            entreeUtilisateur.setError("Le mot de passe doit comprendre une majuscule, une minuscule, un chiffre et un caractere spécial et avoir un minimum de 8 caractère.");
            valide = false;
        }

        return valide;
    }




}
