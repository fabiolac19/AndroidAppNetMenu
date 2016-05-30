package com.example.android.menunetlog;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fabiola on 29/05/16.
 */
public class CalibracionLineal extends Fragment {

    public CalibracionLineal(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivityMenu) getActivity()).setActionBarTitle("Calibracion Lineal");
        View rootView = inflater.inflate(R.layout.calib_lineal, container, false);

        return rootView;
    }
}
