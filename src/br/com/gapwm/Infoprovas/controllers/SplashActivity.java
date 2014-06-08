package br.com.gapwm.Infoprovas.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import br.com.gapwm.Infoprovas.R;


public class SplashActivity extends Activity {

    private Thread thred;
    private Handler handler;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startApplication();
            }
        }, 3000);
    }

    public void startApplication(){
        Intent intentNextAct = new Intent(SplashActivity.this, PrincipalActivity.class);
        startActivity(intentNextAct);
        SplashActivity.this.finish();
    }
}
