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
    Button btnAddBook,btnUpdate;

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
        txtFontBook.setText("\uf02d");

        btnAddBook = (Button)view.findViewById(R.id.btnAddBook);
        btnAddBook.setOnClickListener(this);
        btnUpdate = (Button)view.findViewById(R.id.btnGoToUpdate);
        btnUpdate.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddBook:
                Toast.makeText(getActivity(),"Add Button Clicked.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnGoToUpdate:
                Toast.makeText(getActivity(),"Update Button Clicked.",Toast.LENGTH_SHORT).show();
                break;
        }

    }

}
