package com.sterrenwacht.cozmix;

import android.annotation.SuppressLint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

            @SuppressLint("InflateParams") View formView = getLayoutInflater().inflate(R.layout.astronaut_input_form, null);
            EditText editTextName= formView.findViewById(R.id.editTxtName);
            EditText editTextWeight = formView.findViewById(R.id.editTxtWeight);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(formView)
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
    }

    private void refreshListView() {
        List<Person> persons = ((GlobalVariables) getApplication()).getPersons();
        ArrayAdapter<Person> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                persons);
        ListView listPersons = findViewById(R.id.list_personsPlanet);
        TextView emptyText = findViewById(R.id.text_empty_list);
        listPersons.setEmptyView(emptyText);
        listPersons.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                (adapterView, view, id, l) -> {

                    @SuppressLint("InflateParams") View formView = getLayoutInflater().inflate(R.layout.astronaut_display_form, null);
                    ((TextView) formView.findViewById(R.id.labelAstronaut)).setText(persons.get(id).toString());

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setView(formView)
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