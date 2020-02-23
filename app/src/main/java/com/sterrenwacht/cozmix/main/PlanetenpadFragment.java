package com.sterrenwacht.cozmix.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sterrenwacht.cozmix.R;

import java.util.Objects;

public class PlanetenpadFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planetenpad, container, false);

        if (getActivity() != null & getArguments() != null) {
            String IO = getArguments().getString("IO");

            if (Objects.equals(IO, "inner")) {
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
        }

        return view;
    }
}