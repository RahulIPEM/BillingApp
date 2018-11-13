package com.ibridotechnologies.billingapp;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobType extends Fragment {

    TextView txtFontJobType;

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
        // Inflate the layout for this fragment
        return view;
    }

}
