package com.sterrenwacht.cozmix;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetHomeFragment extends Fragment {

    String planetName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate fragment view
        View view = inflater.inflate(R.layout.fragment_planet_home, container, false);

        // prep resource management
        Resources resources = getResources();
        String packageName = getActivity().getPackageName();
        planetName = getArguments().getString("planet");

        // set image resources
        ((ImageView) view.findViewById(R.id.planet_image))
                .setImageResource(resources.getIdentifier(planetName+"_image","drawable", packageName));
        ((ImageView) view.findViewById(R.id.planet_probe_image))
                .setImageResource(resources.getIdentifier(planetName+"_sonde", "drawable", packageName));
        ((ImageView) view.findViewById(R.id.planet_statue_image))
                .setImageResource(resources.getIdentifier(planetName+"_standbeeld", "drawable", packageName));

        // set text resources
        ((TextView)view.findViewById(R.id.planet_name))
                .setText(StringHelper.capitalise(getString(
                        resources.getIdentifier(planetName+"_name", "string", packageName)
                )));
        ((TextView) view.findViewById(R.id.planet_description))
                .setText(resources.getIdentifier(planetName+"_description", "string", packageName));
        ((TextView) view.findViewById(R.id.planet_statue_name))
                .setText(resources.getIdentifier(planetName+"_statue_name", "string", packageName));
        ((TextView) view.findViewById(R.id.planet_statue_description))
                .setText(resources.getIdentifier(planetName+"_statue_description", "string", packageName));

        return view;
    }
}