package com.sterrenwacht.cozmix;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        /*Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText txtNaamPersoon1 = (EditText)findViewById(R.id.txtNaamPersoon1);
                EditText txtNaamPersoon2 = (EditText)findViewById(R.id.txtNaamPersoon2);
                EditText txtNaamPersoon3 = (EditText)findViewById(R.id.txtNaamPersoon3);
                EditText txtNaamPersoon4 = (EditText)findViewById(R.id.txtNaamPersoon4);

                EditText txtGewichtPersoon1 =(EditText)findViewById(R.id.txtGewichtPersoon1);
                EditText txtGewichtPersoon2 =(EditText)findViewById(R.id.txtGewichtPersoon2);
                EditText txtGewichtPersoon3 =(EditText)findViewById(R.id.txtGewichtPersoon3);
                EditText txtGewichtPersoon4 =(EditText)findViewById(R.id.txtGewichtPersoon4);


                startActivity(new Intent(LoginActivity.this, PlanetenpadOuterFragment.class));
            }
        });*/
    }
}
