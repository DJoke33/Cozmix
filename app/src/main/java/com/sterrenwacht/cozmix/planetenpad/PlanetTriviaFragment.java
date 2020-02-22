package com.sterrenwacht.cozmix.planetenpad;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sterrenwacht.cozmix.R;

public class PlanetTriviaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate fragment view
        View view = inflater.inflate(R.layout.fragment_planet_trivia, container, false);

        // prep resource management
        Resources resources = getResources();
        String packageName = getActivity().getPackageName();
        String planetName = getArguments().getString("planet");

        // set text resources
        ((TextView)view.findViewById(R.id.planet_moons))
                .setText(resources.getIdentifier(planetName +"_moons", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_temperature))
                .setText(resources.getIdentifier(planetName +"_temperature", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_length_day))
                .setText(resources.getIdentifier(planetName +"_length_day", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_orbital_period))
                .setText(resources.getIdentifier(planetName +"_orbital_period", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_travel_time_sun))
                .setText(resources.getIdentifier(planetName +"_travel_time_sun", "string", packageName));

        return view;
    }
}
