package com.example.ryokun.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("DroidSlot");

        ImageView droidImage1 = (ImageView)this.findViewById(R.id.droidimageid1);
        int droidSide1;
        Random r = new Random();

        droidSide1 = r.nextInt(2);
        if( droidSide1 == 0 ){
            droidImage1.setImageResource(R.drawable.droid_front);
        }else{
            droidImage1.setImageResource(R.drawable.droid_back);
        }
    }
}
