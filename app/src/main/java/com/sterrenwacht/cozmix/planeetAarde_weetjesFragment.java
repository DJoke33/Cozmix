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

public class planeetAarde_weetjesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate fragment view
        View view = inflater.inflate(R.layout.fragment_aarde_weetjes, null);

        // prep resource management
        Resources resources = getResources();
        String packageName = getActivity().getPackageName();

        // set text resources
        ((TextView)view.findViewById(R.id.planet_moons))
                .setText(resources.getIdentifier("aarde_moons", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_temperature))
                .setText(resources.getIdentifier("aarde_temperature", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_length_day))
                .setText(resources.getIdentifier("aarde_length_day", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_orbital_period))
                .setText(resources.getIdentifier("aarde_orbital_period", "string", packageName));
        ((TextView)view.findViewById(R.id.planet_travel_time_sun))
                .setText(resources.getIdentifier("aarde_travel_time_sun", "string", packageName));

        return view;
    }
}
