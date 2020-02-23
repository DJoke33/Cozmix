package com.sterrenwacht.cozmix.main;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sterrenwacht.cozmix.R;
import com.sterrenwacht.cozmix.helper.GlobalVariables;

public class IntroductionFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate fragment view
        View view = inflater.inflate(R.layout.fragment_introduction, container, false);

        // set introduction text and format HTML
        TextView textView = view.findViewById(R.id.home_introduction);
        String formattedText = getString(R.string.introduction_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY));
        } else {
            textView.setText(Html.fromHtml(formattedText));
        }

        if (getActivity() != null) {
            // mark introduction seen as true
            ((GlobalVariables) getActivity().getApplication()).setSeenIntroduction(true);
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnStart = view.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> startActivity(new Intent(getActivity(), MainActivity.class)));
    }
}