package com.ibridotechnologies.billingapp;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddJob extends Fragment implements OnClickListener {

    TextView txtFontBook;
    Button btnAddJobType;

    public AddJob() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_job,container,false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        txtFontBook = (TextView)view.findViewById(R.id.txtFontBook);
        txtFontBook.setTypeface(font);
        txtFontBook.setText("\uf0b1");

        btnAddJobType = (Button)view.findViewById(R.id.btnAddJobType);
        btnAddJobType.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddJobType:
                Toast.makeText(getActivity(),"Add Job Type Clicked.",Toast.LENGTH_SHORT).show();
                break;
        }

    }

}
