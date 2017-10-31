package org.apparatum.simple_app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apparatum.simple_app.R;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class ContactsFragment extends Fragment {
    private static ContactsFragment instance;

    public static Fragment getInstance(){
        return (instance == null) ? new ContactsFragment() : instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_contacts, container, false);
    }
}
