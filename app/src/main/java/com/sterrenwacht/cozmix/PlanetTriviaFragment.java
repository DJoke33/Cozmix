package com.sterrenwacht.cozmix;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlanetTriviaFragment extends Fragment {

    String planetName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate fragment view
        View view = inflater.inflate(R.layout.fragment_planet_trivia, null);

        // prep resource management
        Resources resources = getResources();
        String packageName = getActivity().getPackageName();
        planetName = getArguments().getString("planet");

        // set text resources
        ((TextView)view.findViewById(R.id.planet_name))
                .setText(capitalise(getString(
                        resources.getIdentifier(planetName+"_name", "string", packageName)
                )));
        ((TextView)view.findViewById(R.id.planet_moons))
                .setText(resources.getIdentifier(planetName+"_moons", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_temperature))
                .setText(resources.getIdentifier(planetName+"_temperature", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_length_day))
                .setText(resources.getIdentifier(planetName+"_length_day", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_orbital_period))
                .setText(resources.getIdentifier(planetName+"_orbital_period", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_travel_time_sun))
                .setText(resources.getIdentifier(planetName+"_travel_time_sun", "string", packageName));

        return view;
    }

    // TODO: store this method elsewhere
    public String capitalise(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        else {
            return s.substring(0,1).toUpperCase() + s.substring(1);
        }
    }
}
