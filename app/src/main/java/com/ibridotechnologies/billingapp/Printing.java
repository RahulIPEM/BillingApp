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
public class Printing extends Fragment implements View.OnClickListener {

    TextView txtFontPrinting;
    Button btnGetPrinting;

    public Printing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_printing, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        txtFontPrinting = (TextView)view.findViewById(R.id.txtFontPrinting);
        txtFontPrinting.setTypeface(font);
        txtFontPrinting.setText("\uf02f");

        btnGetPrinting = (Button)view.findViewById(R.id.btnGetPaper);
        btnGetPrinting.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetPrinting:
                Toast.makeText(getActivity(),"Printing Clicked.",Toast.LENGTH_SHORT).show();
                Fragment fragment = new Cutting();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContainer,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }

}
