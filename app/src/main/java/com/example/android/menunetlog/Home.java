package com.example.android.menunetlog;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fabiola on 30/05/16.
 */
public class Home extends Fragment {
    public Home(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivityMenu) getActivity()).setActionBarTitle("Home");
        View rootView = inflater.inflate(R.layout.home, container, false);

        return rootView;
    }
}
