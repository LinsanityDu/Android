package com.lindu.crackingtheinterview;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;


/**
 * Created by Lin on 9/7/15.
 */
public class ToughQuestion extends ActionBarActivity implements OnClickListener {


    String[] simple_question, simple_answers;

    TextView tvquestion, tvanswer, tvtotoallength_yy, tvpresentindex_xx;

    Button bleft, bshow, bright;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        LinearLayout question_11 = (LinearLayout)findViewById(R.id.question_page_titlebar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);


        Button bspeak = (Button)findViewById(R.id.bspeak);
        Button bmute = (Button)findViewById(R.id.bmute);
        TextView tv_category = (TextView)findViewById(R.id.tv_question_titlebar);
        tv_category.setText("Tough Questions");

        tvquestion = (TextView)findViewById(R.id.tvquestion);
        tvanswer = (TextView)findViewById(R.id.tvanswer);
        tvpresentindex_xx = (TextView)findViewById(R.id.tvxx);
        tvtotoallength_yy = (TextView)findViewById(R.id.tvyy);

        bleft = (Button)findViewById(R.id.bleft);
        bshow = (Button)findViewById(R.id.bshowanswer);
        bright = (Button)findViewById(R.id.bright);


        simple_question = getResources().getStringArray(R.array.simple_ques);
        simple_answers = getResources().getStringArray(R.array.simple_ans);

        bleft.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bright.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bleft:
                break;
            case R.id.bshowanswer:
                break;
            case R.id.bright:
                break;
        }
    }
}
