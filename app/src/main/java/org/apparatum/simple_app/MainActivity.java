package org.apparatum.simple_app;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;


import org.apparatum.simple_app.fragments.ContactsFragment;
import org.apparatum.simple_app.fragments.HomeFragment;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView =
                (BottomNavigationView) findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home: {
                    selectedFragment = HomeFragment.getInstance();
                }break;

                case R.id.nav_contacts: {
                    selectedFragment = ContactsFragment.getInstance();
                }break;
            }

            makeFragmentTransaction(R.id.frame_container, selectedFragment);
            return true;
        });


        makeFragmentTransaction(R.id.frame_container, HomeFragment.getInstance());
    }

    private void makeFragmentTransaction(int id, Fragment fragment){
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }

}
