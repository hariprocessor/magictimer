package com.nunuplanet.magictimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AttributeSet attributeSet;
    private ProgressBar progressBar;
    private TextView textView;
    static final int DELAY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attributeSet = null;
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textView = (TextView) findViewById(R.id.text_view);

        workingTimer(10*60);
    }

    private void workingTimer(final int time){
        int i = 0;
        progressBar.setProgress(i);
        new CountDownTimer(time* 1000, MainActivity.DELAY) {
            @Override
            public void onTick(long m) {
                textView.setText(String.valueOf(m*100) + "/" + String.valueOf(time*100) +"="+String.valueOf(m/(time*10)));
                progressBar.setProgress((int)m/(time*10));
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(100);
            }
        }.start();
    }
}
