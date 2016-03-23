package com.codekul.activitylifecycle;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnOkay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textView = (TextView) findViewById(R.id.textView);

        if(savedInstanceState != null){
            int color = savedInstanceState.getInt("KEY_MY_COLOR");
            textView.setBackgroundColor(color);
        }

        btnOkay = (Button) findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setBackgroundColor(Color.RED);
            }
        });

        mt("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mt("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        mt("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        mt("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mt("onDestory");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mt("onRestart");
    }

    private void mt(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("KEY_MY_COLOR", Color.RED);
        mt("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int color = savedInstanceState.getInt("KEY_MY_COLOR");

        mt("onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mt("onConfigurationChanged");

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){

            getWindow().setBackgroundDrawableResource(R.drawable.mmp);
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            getWindow().setBackgroundDrawableResource(R.drawable.pop);
        }
        else {

            getWindow().setBackgroundDrawableResource(R.drawable.goofy);
        }
    }
}
