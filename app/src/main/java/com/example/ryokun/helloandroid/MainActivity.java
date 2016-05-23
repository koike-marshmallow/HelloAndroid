package com.example.ryokun.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    int[] sideImage = {
            R.drawable.droid_front,
            R.drawable.droid_back,
            R.drawable.droid_left,
            R.drawable.droid_right
    };
    int defImage = R.drawable.star;

    Button bRetry;

    int droidSide1 = -1;
    int droidSide2 = -1;
    int droidSide3 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("DroidSlot");

        final ImageView droidImage1 = (ImageView)this.findViewById(R.id.droidimageid1);
        final ImageView droidImage2 = (ImageView)this.findViewById(R.id.droidimageid2);
        final ImageView droidImage3 = (ImageView)this.findViewById(R.id.droidimageid3);
        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);
        final Button b2 = (Button) this.findViewById(R.id.slotbutton2);
        final Button b3 = (Button) this.findViewById(R.id.slotbutton3);
        bRetry = (Button) this.findViewById(R.id.retrybutton);
        final Random r = new Random();

        bRetry.setVisibility(View.INVISIBLE);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int drawableId;

                droidSide1 = r.nextInt(4);
                droidImage1.setImageResource(getDrawableId(droidSide1));
                checkState();
                b1.setEnabled(false);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int drawableId;

                droidSide2 = r.nextInt(4);
                droidImage2.setImageResource(getDrawableId(droidSide2));
                checkState();
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int drawableId;

                droidSide3 = r.nextInt(4);
                droidImage3.setImageResource(getDrawableId(droidSide3));
                checkState();
                b3.setEnabled(false);
            }
        });
        bRetry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                droidImage1.setImageResource(defImage);
                droidImage2.setImageResource(defImage);
                droidImage3.setImageResource(defImage);
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                bRetry.setVisibility(View.INVISIBLE);
                droidSide1 = droidSide2 = droidSide3 = -1;
            }
        });
    }

    private int getDrawableId(int side){
        if( side >= 0 && side < sideImage.length ){
            return sideImage[side];
        }else{
            return defImage;
        }
    }

    private void checkState(){
        if( droidSide1 == droidSide2 && droidSide2 == droidSide3 ){
            Toast.makeText(getApplicationContext(), "おめでとう 揃いました", Toast.LENGTH_SHORT).show();
        }
        if( droidSide1 != -1 && droidSide2 != -1 && droidSide3 != -1 ){
            bRetry.setVisibility(View.VISIBLE);
        }
    }
}
