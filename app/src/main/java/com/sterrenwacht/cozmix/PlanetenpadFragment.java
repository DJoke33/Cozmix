package com.sterrenwacht.cozmix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlanetenpadFragment extends Fragment {

    String IO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planetenpad, container, false);

        IO = getArguments().getString("IO");

        if (IO == "inner") {
            Fragment fragment = new PlanetenpadInnerFragment();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.add(R.id.planetenpad_host_fragment, fragment);
            ft.commit();
        } else {
            Fragment fragment = new PlanetenpadOuterFragment();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.add(R.id.planetenpad_host_fragment, fragment);
            ft.commit();
        }

        return view;
    }
}