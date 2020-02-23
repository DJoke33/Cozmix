package com.sterrenwacht.cozmix.planetenpad;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sterrenwacht.cozmix.R;
import com.sterrenwacht.cozmix.helper.GlobalVariables;
import com.sterrenwacht.cozmix.helper.Person;

import java.util.List;

public class PlanetWeightFragment extends Fragment {

    private double planetGravity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planet_weight, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        if (getActivity() != null & getArguments() != null) {
            // get resources
            Resources resources = getResources();
            String packageName = getActivity().getPackageName();

            String planetName = getArguments().getString("planet");
            planetGravity = Double.parseDouble(
                    getString(resources.getIdentifier(
                            planetName + "_gravity",
                            "string",
                            packageName
                    ))
            );

            ((TextView) view.findViewById(R.id.weight_subtitle))
                            .setText(String.format(
                                    getString(resources.getIdentifier(
                                            "weight_subtitle",
                                            "string",
                                            packageName)),
                                    getString(resources.getIdentifier(
                                            planetName +"_name",
                                            "string",
                                            packageName))
                            ));
        }

        refreshListView();
    }

    @Override
    public void onStart() {
        super.onStart();
        refreshListView();
    }

    private void refreshListView() {
        if (getActivity() != null) {
            List<Person> persons = ((GlobalVariables) getActivity().getApplication()).getPersons();
            List<Person> personsPlanet = Person.planetaryConversion(persons, planetGravity);

            ArrayAdapter<Person> listAdapter = new ArrayAdapter<>(
                    getActivity(),
                    android.R.layout.simple_list_item_1,
                    personsPlanet);
            ListView listPersons = getActivity().findViewById(R.id.list_personsPlanet);
            TextView emptyText = getActivity().findViewById(R.id.text_empty_list);
            listPersons.setEmptyView(emptyText);
            listPersons.setAdapter(listAdapter);
        }
    }

    // TODO: nakijken welke van onderstaande code bruikbaar is in invoervenster Persons en/of eigen validatie op invoer toevoegen
    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btnBereken = (Button) getView().findViewById(R.id.btnBereken);
        btnBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtGewichtP1 =(EditText)getView().findViewById(R.id.txtGewichtP1);
                String valueGewichtP1 = txtGewichtP1.getText().toString();
                EditText txtGewichtP2 =(EditText)getView().findViewById(R.id.txtGewichtP2);
                String valueGewichtP2 = txtGewichtP2.getText().toString();
                EditText txtGewichtP3 =(EditText)getView().findViewById(R.id.txtGewichtP3);
                String valueGewichtP3 = txtGewichtP3.getText().toString();
                EditText txtGewichtP4 =(EditText)getView().findViewById(R.id.txtGewichtP4);
                String valueGewichtP4 = txtGewichtP4.getText().toString();

                // controlleerd lege ingeving van gewicht /////////////////////////////////////////////////////////////////////////
                //*1 Verwijderd de focus op het invulvak //////////////////////////////////////////////////////////////////////////
                //*2 Berekend de zwaarte kracht (blauwe cijfer is gravitatie van de planeet) ///////////////////////////////////////
                //*3 rond het getal af en zet het resultaat in een textbox /////////////////////////////////////////////////////////

                //Persoon 1 ///////////////////////////////////////////////////////////////////////////////////////////////////
                if (valueGewichtP1.matches("")) {
                    TextView txtGewichtResultaatP1 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP1);
                    txtGewichtResultaatP1.setText(" ... Kg");
                    txtGewichtP1.clearFocus();
                }else {
                    //*1
                    txtGewichtP1.clearFocus();
                    //*2
                    int gewichtP1 =Integer.parseInt(valueGewichtP1);
                    double gewichtResultaatP1 = gewichtP1 * 1;
                    //*3
                    TextView txtGewichtResultaatP1 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP1);
                    int intGewichtResultaatP1 = (int) Math.round(gewichtResultaatP1);
                    txtGewichtResultaatP1.setText(Integer.toString(Math.round(intGewichtResultaatP1)) + " Kg");
                }

                //Persoon 2 //////////////////////////////////////////////////////////////////////////////////////////////////
                if (valueGewichtP2.matches("")) {
                    TextView txtGewichtResultaatP2 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP2);
                    txtGewichtResultaatP2.setText(" ... Kg");
                    txtGewichtP2.clearFocus();
                }else{
                    //*1
                    txtGewichtP2.clearFocus();
                    //*2
                    int gewichtP2 =Integer.parseInt(valueGewichtP2);
                    double gewichtResultaatP2 = gewichtP2 * 1;
                    //*3
                    TextView txtGewichtResultaatP2 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP2);
                    int intGewichtResultaatP2 = (int) Math.round(gewichtResultaatP2);
                    txtGewichtResultaatP2.setText(Integer.toString(Math.round(intGewichtResultaatP2)) + " Kg");
                }

                //Persoon 3 /////////////////////////////////////////////////////////////////////////////////////////////////
                if (valueGewichtP3.matches("")) {
                    TextView txtGewichtResultaatP3 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP3);
                    txtGewichtResultaatP3.setText(" ... Kg");
                    txtGewichtP3.clearFocus();
                }else{
                    //*1
                    txtGewichtP3.clearFocus();
                    //*2
                    int gewichtP3 =Integer.parseInt(valueGewichtP3);
                    double gewichtResultaatP3 = gewichtP3 * 1;
                    //*3
                    TextView txtGewichtResultaatP3 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP3);
                    int intGewichtResultaatP3 = (int) Math.round(gewichtResultaatP3);
                    txtGewichtResultaatP3.setText(Integer.toString(Math.round(intGewichtResultaatP3)) + " Kg");
                }

                //Persoon 4 //////////////////////////////////////////////////////////////////////////////////////////////
                if (valueGewichtP4.matches("")) {
                    TextView txtGewichtResultaatP4 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP4);
                    txtGewichtResultaatP4.setText(" ... Kg");
                    txtGewichtP4.clearFocus();
                }else{
                    //*1
                    txtGewichtP4.clearFocus();
                    //*2
                    int gewichtP4 =Integer.parseInt(valueGewichtP4);
                    double gewichtResultaatP4 = gewichtP4 * 1;
                    //*3
                    TextView txtGewichtResultaatP4 = (TextView) getView().findViewById(R.id.txtGewichtResultaatP4);
                    int intGewichtResultaatP4 = (int) Math.round(gewichtResultaatP4);
                    txtGewichtResultaatP4.setText(Integer.toString(Math.round(intGewichtResultaatP4)) + " Kg");
                }
            }
        });

        // verwijder keyboard bij bereken button klik ///////////////////////////////////////////////////////////////////////////
        EditText txtGewichtP1 =(EditText)getView().findViewById(R.id.txtGewichtP1);
        txtGewichtP1.setOnFocusChangeListener(this);
        EditText txtGewichtP2 =(EditText)getView().findViewById(R.id.txtGewichtP2);
        txtGewichtP2.setOnFocusChangeListener(this);
        EditText txtGewichtP3 =(EditText)getView().findViewById(R.id.txtGewichtP3);
        txtGewichtP3.setOnFocusChangeListener(this);
        EditText txtGewichtP4 =(EditText)getView().findViewById(R.id.txtGewichtP4);
        txtGewichtP4.setOnFocusChangeListener(this);
    }*/

    /*@Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == R.id.txtGewichtP1 && !hasFocus) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        if (v.getId() == R.id.txtGewichtP2 && !hasFocus) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        if (v.getId() == R.id.txtGewichtP3 && !hasFocus) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        if (v.getId() == R.id.txtGewichtP4 && !hasFocus) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }*/
}