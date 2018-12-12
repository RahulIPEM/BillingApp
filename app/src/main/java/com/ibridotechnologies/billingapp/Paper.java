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
public class Paper extends Fragment implements View.OnClickListener {

    TextView txtFontPaper;
    Button btnGetPaper;

    public Paper() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_paper, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        txtFontPaper = (TextView)view.findViewById(R.id.txtFontPaper);
        txtFontPaper.setTypeface(font);
        txtFontPaper.setText("\uf0f6");

        btnGetPaper = (Button)view.findViewById(R.id.btnGetPaper);
        btnGetPaper.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetPaper:
                Toast.makeText(getActivity(),"Paper Clicked.",Toast.LENGTH_SHORT).show();
                Fragment fragment = new Printing();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContainer,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }

}
