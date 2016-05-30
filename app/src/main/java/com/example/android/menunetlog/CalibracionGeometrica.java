package com.example.android.menunetlog;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fabiola on 29/05/16.
 */
public class CalibracionGeometrica extends Fragment {

    public CalibracionGeometrica(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivityMenu) getActivity()).setActionBarTitle("Calibracion Geometrica");
        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);

        return rootView;
    }
}
