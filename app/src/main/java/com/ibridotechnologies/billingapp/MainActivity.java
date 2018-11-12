package com.ibridotechnologies.billingapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_add_job:
                    loadInitialFragment(new AddJob());
                    //mTextMessage.setText("Add Job");
                    /*Fragment fragment=new AddJob();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameContainer,fragment);
                    fragmentTransaction.commit();*/
                    return true;
                case R.id.navigation_add_party:
                    loadInitialFragment(new AddParty());
                    /*Fragment fragment=new AddParty();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameContainer,fragment);
                    fragmentTransaction.commit();*/
                    return true;
                case R.id.navigation_new_job:
                    //mTextMessage.setText("New Job");
                    return true;
                case R.id.navigation_receipt:
                    //mTextMessage.setText("Receipt of the Job");
                    return true;
                case R.id.navigation_exit:
                    //mTextMessage.setText("Exit");
                    return true;
            }
            return false;
        }
    };

    private void loadInitialFragment(Fragment fragmentParam) {
        Fragment fragment = fragmentParam;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadInitialFragment(new AddJob());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
