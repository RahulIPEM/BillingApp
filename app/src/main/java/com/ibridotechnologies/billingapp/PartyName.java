package com.ibridotechnologies.billingapp;


import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ibridotechnologies.billingapp.getJson.getParty.JSONDownloaderSP;


/**
 * A simple {@link Fragment} subclass.
 */
public class PartyName extends Fragment implements View.OnClickListener {

    TextView txtFontPartyName;
    Spinner spinnerParty;
    ProgressDialog progressDialog;
    Button btnGetParty;
    String JsonURL = "http://www.acmecreations.co.in/api/AcmeQuotation/GetPartyList";

    public PartyName() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_party_name, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        txtFontPartyName = (TextView)view.findViewById(R.id.txtFontPartyName);
        txtFontPartyName.setTypeface(font);
        txtFontPartyName.setText("\uf007");

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Getting Client List");
        progressDialog.setMessage("Loading... Please wait.");
        progressDialog.show();

        spinnerParty = (Spinner)view.findViewById(R.id.spinnerParty);

        new JSONDownloaderSP(getActivity(),JsonURL,spinnerParty,progressDialog).execute();

        btnGetParty = (Button)view.findViewById(R.id.btnGetParty);
        btnGetParty.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetParty:
                Toast.makeText(getActivity(),"Party Clicked.",Toast.LENGTH_SHORT).show();
                Fragment fragment = new JobType();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContainer,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
