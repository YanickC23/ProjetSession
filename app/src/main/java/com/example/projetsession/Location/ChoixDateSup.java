package com.example.projetsession.Location;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.projetsession.R;


public class ChoixDateSup  extends DialogFragment implements DatePickerDialog.OnDateSetListener{


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        return new DatePickerDialog(getActivity(), this, 2020, 9, 30);
    }




    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        TextView tvDateSup = getActivity().findViewById(R.id.edxRechDateSup);
        tvDateSup.setText(i2 + "/" + i1 + "/" + i);
    }







}
