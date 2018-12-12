package com.ibridotechnologies.billingapp;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cutting extends Fragment implements View.OnClickListener {

    TextView txtFontCutting;
    Button btnGetCutting;

    public Cutting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cutting, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        txtFontCutting = (TextView)view.findViewById(R.id.txtFontPrinting);
        txtFontCutting.setTypeface(font);
        txtFontCutting.setText("\uf0c4");

        btnGetCutting = (Button)view.findViewById(R.id.btnGetCutting);
        btnGetCutting.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetCutting:
                Toast.makeText(getActivity(),"Cutting Clicked.",Toast.LENGTH_SHORT).show();
                /*Fragment fragment = new Cutting();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContainer,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
                break;
        }
    }

}
