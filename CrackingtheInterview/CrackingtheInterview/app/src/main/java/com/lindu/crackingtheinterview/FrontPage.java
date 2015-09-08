package com.lindu.crackingtheinterview;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;


public class FrontPage extends ActionBarActivity implements OnClickListener {

    Button bsimple, btough, bseeotherapps, brateapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        // ActionBar
        LinearLayout front_11 = (LinearLayout)findViewById(R.id.front_page_titlebar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.front_title_bar);

        bsimple = (Button)findViewById(R.id.bsq);
        btough = (Button)findViewById(R.id.btq);
        bseeotherapps = (Button)findViewById(R.id.bseeotherapps);
        brateapp = (Button)findViewById(R.id.brateapp);

        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bseeotherapps.setOnClickListener(this);
        brateapp.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bsq:
                Intent i = new Intent(FrontPage.this, SimpleQuestion.class);
                startActivity(i);
                break;
            case R.id.btq:
                Intent j = new Intent(FrontPage.this, ToughQuestion.class);
                startActivity(j);
                break;
            case R.id.brateapp:

                break;
            case R.id.bseeotherapps:

                break;
            default:

                break;
        }
    }
}
