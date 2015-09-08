package com.lindu.crackingtheinterview;

import android.app.ActionBar;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by Lin on 9/7/15.
 */
public class SimpleQuestion extends ActionBarActivity implements OnClickListener {

    String[] simple_question, simple_answers;

    TextView tvquestion, tvanswer, tvtotoallength_yy, tvpresentindex_xx;

    Button bleft, bshow, bright;

    int index;

    // TextToSpeech
    TextToSpeech ttsobject;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        // Action Bar
        LinearLayout question_11 = (LinearLayout)findViewById(R.id.question_page_titlebar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);


        Button bspeak = (Button)findViewById(R.id.bspeak);
        Button bmute = (Button)findViewById(R.id.bmute);
        TextView tv_category = (TextView)findViewById(R.id.tv_question_titlebar);
        tv_category.setText("Simple Questions");

        // Initialization of TextView
        tvquestion = (TextView)findViewById(R.id.tvquestion);
        tvanswer = (TextView)findViewById(R.id.tvanswer);
        tvpresentindex_xx = (TextView)findViewById(R.id.tvxx);
        tvtotoallength_yy = (TextView)findViewById(R.id.tvyy);

        // Initialization of Buttons
        bleft = (Button)findViewById(R.id.bleft);
        bshow = (Button)findViewById(R.id.bshowanswer);
        bright = (Button)findViewById(R.id.bright);

        // Import Arrays from value folder
        simple_question = getResources().getStringArray(R.array.simple_ques);
        simple_answers = getResources().getStringArray(R.array.simple_ans);

        // OnClick methods
        bleft.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bright.setOnClickListener(this);
        bspeak.setOnClickListener(this);
        bmute.setOnClickListener(this);

        // Setting Values to our Variables and 4 TextViews.
        index = 0;
        tvquestion.setText(simple_question[index]);
        tvanswer.setText("Press \"A\" Button for the Answer");
        tvpresentindex_xx.setText(String.valueOf(index + 1));
        tvtotoallength_yy.setText("/" + String.valueOf(simple_question.length));

        /* TTS Object */
        ttsobject = new TextToSpeech(SimpleQuestion.this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = ttsobject.setLanguage(Locale.US);
                } else {
                    Toast.makeText(getApplicationContext(), "Feature not supported in Your Device", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bleft:
                tvanswer.setText("Press \"A\" Button for the Answer");
                index--;
                if (index == -1) {
                    index = simple_question.length - 1;
                }
                tvquestion.setText(simple_question[index]);
                tvpresentindex_xx.setText(String.valueOf(index + 1));
                break;
            case R.id.bshowanswer:
                tvanswer.setText(simple_answers[index]);
                break;
            case R.id.bright:
                tvanswer.setText("Press \"A\" Button for the Answer");
                index++;
                if (index == simple_question.length) {
                    index = 0;
                }
                tvquestion.setText(simple_question[index]);
                tvpresentindex_xx.setText(String.valueOf(index + 1));

                break;

            case R.id.bspeak:

                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                    Toast.makeText(getApplicationContext(),"Feature not supported in Your Device", Toast.LENGTH_SHORT).show();
                } else {
                    ttsobject.speak(simple_answers[index], TextToSpeech.QUEUE_FLUSH, null);
                }

                break;

            case R.id.bmute:

                if (ttsobject != null) {
                    ttsobject.stop();
                }

                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ttsobject != null) {
            ttsobject.stop();
            ttsobject.shutdown();
        }
    }
}
