package org.apparatum.simple_app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apparatum.simple_app.R;
import org.apparatum.simple_app.RecyclerAdapter;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class HomeFragment extends Fragment {
    private static HomeFragment instance;

    public static Fragment getInstance(){
        return (instance == null) ? new HomeFragment() : instance;
    }

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_home, container, false);

        mRecycleView = (RecyclerView)view.findViewById(R.id.my_recycler_view);

        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(container.getContext());
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter();
        mRecycleView.setAdapter(mAdapter);

        return view;
    }
}
