package com.ibridotechnologies.billingapp;


import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.ibridotechnologies.billingapp.getJson.spinnerstate.JSONDownloaderSP;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddParty extends Fragment {

    TextView txtFontParty;
    Spinner spinnerState,spinnerDistrict;
    ProgressDialog pg;
    AlertDialog.Builder builder;
    String spJsonURL ="http://www.acmecreations.co.in/api/AcmeQuotation/GetStateList";

    public AddParty() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_party,container,false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        txtFontParty = (TextView)view.findViewById(R.id.txtFontParty);
        txtFontParty.setTypeface(font);
        txtFontParty.setText("\uf234");

        spinnerState = (Spinner)view.findViewById(R.id.spinnerState);
        spinnerDistrict = (Spinner)view.findViewById(R.id.spinnerDistrict);

        pg = new ProgressDialog(getActivity());
        pg.setTitle("States");
        pg.setMessage("Loading... Please wait.");
        pg.show();

        new JSONDownloaderSP(getActivity(),spJsonURL,spinnerState,spinnerDistrict,pg).execute();

        builder = new AlertDialog.Builder(getActivity());

        // Inflate the layout for this fragment
        return view;
    }

}
