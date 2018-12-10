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

import com.ibridotechnologies.billingapp.getJson.getJobType.JSONDownloaderSP;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobType extends Fragment implements View.OnClickListener {

    TextView txtFontJobType;
    Spinner spinnerJobType;
    ProgressDialog progressDialog;
    Button btnGetJob;
    String JsonURL = "http://www.acmecreations.co.in/api/AcmeQuotation/GetJobTypeList";

    public JobType() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_job_type, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        txtFontJobType = (TextView)view.findViewById(R.id.txtFontJobType);
        txtFontJobType.setTypeface(font);
        txtFontJobType.setText("\uf0b1");

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Getting Job Type");
        progressDialog.setMessage("Loading... Please wait.");
        progressDialog.show();

        spinnerJobType = (Spinner)view.findViewById(R.id.spinnerJobType);

        new JSONDownloaderSP(getActivity(),JsonURL,spinnerJobType,progressDialog).execute();

        btnGetJob = (Button)view.findViewById(R.id.btnGetJob);
        btnGetJob.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetJob:
                Toast.makeText(getActivity(),"Job Type Clicked.",Toast.LENGTH_SHORT).show();
                Fragment fragment = new Quantity();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContainer,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
