package com.example.android.menunetlog;
import android.app.ListFragment;
import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabiola on 29/05/16.
 */
public class HomeFragment extends ListFragment {
    private static final String STATE_COUNTER = "counter";
    private int mCounter;
    private static final String STATE_ITEMS = "items";

    // Make sure to declare as ArrayList so it's Serializable
    private ArrayList<ClipData.Item> mItems;

    private JSONArray jsonArray;
    List<String> values;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        values = new ArrayList<>();
        values.add(0,"pepe");

        String url = "http://api.androidhive.info/contacts/";
        json(url,"contacts");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item, values);
        setListAdapter(adapter);
        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(STATE_COUNTER, 0);
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
                ((MainActivityMenu) getActivity()).setActionBarTitle("Gestionar Estacion");
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        values = new ArrayList<>();
//        values.add(0,"pepe");
//
//        String url = "http://api.androidhive.info/contacts/";
//        json(url,"contacts");
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                R.layout.support_simple_spinner_dropdown_item, values);
//        setListAdapter(adapter);
    }
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        values = new ArrayList<>();
        values.add(0,"pepe");

        String url = "http://api.androidhive.info/contacts/";
        json(url,"contacts");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item, values);
        setListAdapter(adapter);
        outState.putInt(STATE_COUNTER, mCounter);
        outState.putSerializable(STATE_ITEMS, mItems);
    }
    private void json(String url, final String nombre)
    {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub

                        try {
                            //extracting json array from response string
                            jsonArray = response.getJSONArray(nombre);

                            leerJson();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub-

                    }
                });
        queue.add(jsObjRequest);

    }

    private void leerJson()
    {
        String[] contacs = {
                "id",
                "name",
                "email",
                "address"
        };
        for (int i=0; i< jsonArray.length(); i++){
            JSONObject jsonRow = null;
            try {
                jsonRow = jsonArray.getJSONObject(i);
                for (int j = 0; j < contacs.length; j++ ){
                    String resultStr = null;
                    try {
                        resultStr = jsonRow.getString(contacs[j]);
                        if (j ==  1) {values.add(i,resultStr);}
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

