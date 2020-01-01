package com.sterrenwacht.cozmix;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate fragment view
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // set introduction text and format HTML
        TextView textView = view.findViewById(R.id.home_introduction);
        String formattedText = getString(R.string.introduction_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY));
        } else {
            textView.setText(Html.fromHtml(formattedText));
        }

        return view;
    }
}