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

public class planeetAarde_homeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate fragment view
        View view = inflater.inflate(R.layout.fragment_aarde_home, container, false);

        // prep resource management
        Resources resources = getResources();
        String packageName = getActivity().getPackageName();

        // set image resources
        ((ImageView) view.findViewById(R.id.planet_image))
                .setImageResource(resources.getIdentifier("plan_aarde2","drawable", packageName));
        ((ImageView) view.findViewById(R.id.planet_probe_image))
                .setImageResource(resources.getIdentifier("sonde_aarde", "drawable", packageName));
        ((ImageView) view.findViewById(R.id.planet_statue_image))
                .setImageResource(resources.getIdentifier("aarde_statue_description", "drawable", packageName));

        // set text resources
        ((TextView)view.findViewById(R.id.planet_name))
                .setText(resources.getIdentifier("aarde_name", "string", packageName));
        ((TextView) view.findViewById(R.id.planet_description))
                .setText(resources.getIdentifier("aarde_description", "string", packageName));
        ((TextView) view.findViewById(R.id.planet_statue_name))
                .setText(resources.getIdentifier("aarde_statue_name", "string", packageName));
        ((TextView) view.findViewById(R.id.planet_statue_description))
                .setText(resources.getIdentifier("aarde_statue_description", "string", packageName));

        return view;
    }
}
