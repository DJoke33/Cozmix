package com.sterrenwacht.cozmix;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sterrenwacht.cozmix.helper.GlobalVariables;
import com.sterrenwacht.cozmix.helper.Person;

import java.util.List;

public class AstronautsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronauts);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Context context = view.getRootView().getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formView = inflater.inflate(R.layout.astronaut_input_form, null, false);
            final EditText editTextName= formView.findViewById(R.id.editTxtName);
            final EditText editTextWeight = formView.findViewById(R.id.editTxtWeight);

            new AlertDialog.Builder(context)
                    .setView(formView)
                    .setTitle(R.string.create_astronaut_title)
                    .setPositiveButton(R.string.btn_txt_add,
                            (dialogInterface, i) -> {
                                try {
                                    // get user input
                                    String name = editTextName.getText().toString();
                                    double weight = Double.parseDouble(editTextWeight.getText().toString());
                                    // add astronaut to Global Variables
                                    ((GlobalVariables) getApplication()).addPerson(new Person(name, weight));
                                    refreshListView();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                dialogInterface.cancel();
                            })
                    .show();
        });

        refreshListView();

        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/
    }

    private void refreshListView() {
        List<Person> persons = ((GlobalVariables) getApplication()).getPersons();
        ArrayAdapter<Person> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                persons);
        ListView listPersons = findViewById(R.id.list_personsPlanet);
        listPersons.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                (adapterView, view, id, l) -> {

                    // action on listitem click
                    Context context = view.getRootView().getContext();
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View formView = inflater.inflate(R.layout.astronaut_display_form, null, false);
                    ((TextView) formView.findViewById(R.id.labelAstronaut)).setText(persons.get(id).toString());

                    new AlertDialog.Builder(context)
                            .setView(formView)
                            .setTitle(R.string.delete_astronaut_title)
                            .setPositiveButton(R.string.btn_txt_delete,
                                    (dialogInterface, i) -> {
                                        try {
                                            // delete astronaut from Global Variables
                                            ((GlobalVariables) getApplication()).deletePerson(id);
                                            refreshListView();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        dialogInterface.cancel();
                                    })
                            .show();
                };
        listPersons.setOnItemClickListener(itemClickListener);
    }
}