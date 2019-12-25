package com.sterrenwacht.cozmix;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // set introduction text and format HTML
        TextView view = (TextView) findViewById(R.id.home_introduction);
        String formattedText = getString(R.string.introduction_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.setText(Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY));
        } else {
            view.setText(Html.fromHtml(formattedText));
        }
    }
}
