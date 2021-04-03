package com.earnmoney.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.earnmoney.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Thread splashh = new Thread(){
            public void run(){
                try{

                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(),LanguageActivity.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        };
        splashh.start();
    }
}
