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

    ImageView droidImage1, droidImage2, droidImage3;
    Button b1, b2, b3;
    Button bRetry;

    ImageidSlotReel droidSide1, droidSide2, droidSide3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("DroidSlot");

        droidImage1 = (ImageView)this.findViewById(R.id.droidimageid1);
        droidImage2 = (ImageView)this.findViewById(R.id.droidimageid2);
        droidImage3 = (ImageView)this.findViewById(R.id.droidimageid3);
        b1 = (Button) this.findViewById(R.id.slotbutton1);
        b2 = (Button) this.findViewById(R.id.slotbutton2);
        b3 = (Button) this.findViewById(R.id.slotbutton3);
        bRetry = (Button) this.findViewById(R.id.retrybutton);
        final Random r = new Random();
        droidSide1 = new ImageidSlotReel(sideImage, r.nextInt(4));
        droidSide2 = new ImageidSlotReel(sideImage, r.nextInt(4));
        droidSide3 = new ImageidSlotReel(sideImage, r.nextInt(4));

        bRetry.setEnabled(true);
        initGame();
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                droidSide1.stop();
                droidImage1.setImageResource(droidSide1.getSymbolId());
                checkState();
                b1.setEnabled(false);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                droidSide2.stop();
                droidImage2.setImageResource(droidSide2.getSymbolId());
                checkState();
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                droidSide3.stop();
                droidImage3.setImageResource(droidSide3.getSymbolId());
                checkState();
                b3.setEnabled(false);
            }
        });
        bRetry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                initGame();
            }
        });
    }

    private void initGame(){
        droidImage1.setImageResource(defImage);
        droidSide1.start();
        b1.setEnabled(true);
        droidImage2.setImageResource(defImage);
        droidSide2.start();
        b2.setEnabled(true);
        droidImage3.setImageResource(defImage);
        droidSide3.start();
        b3.setEnabled(true);
        bRetry.setVisibility(View.INVISIBLE);
    }

    private void checkState(){
        System.out.println(droidSide1.isRotate() + ","+ droidSide2.isRotate() + "," + droidSide3.isRotate());
        if( droidSide1.getValue() == droidSide2.getValue() && droidSide2.getValue() == droidSide3.getValue() ){
            Toast.makeText(getApplicationContext(), "おめでとう 揃いました", Toast.LENGTH_SHORT).show();
            bRetry.setVisibility(View.VISIBLE);
        }else if( !droidSide1.isRotate() && !droidSide2.isRotate() && !droidSide3.isRotate() ){
            bRetry.setVisibility(View.VISIBLE);
        }
    }
}
