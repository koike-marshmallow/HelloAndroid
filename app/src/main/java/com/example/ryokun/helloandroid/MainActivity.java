package com.example.ryokun.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
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
        final Random r = new Random();

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int drawableId;

                droidSide1 = r.nextInt(4);
                switch( droidSide1 ){
                    case 0:
                        drawableId = R.drawable.droid_front; break;
                    case 1:
                        drawableId = R.drawable.droid_back; break;
                    case 2:
                        drawableId = R.drawable.droid_left; break;
                    default:
                        drawableId = R.drawable.droid_right;
                }
                droidImage1.setImageResource(drawableId);
                Toast.makeText(getApplicationContext(), Integer.toString(droidSide1), Toast.LENGTH_SHORT).show();
                b1.setEnabled(false);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int drawableId;

                droidSide2 = r.nextInt(4);
                switch( droidSide2 ){
                    case 0:
                        drawableId = R.drawable.droid_front; break;
                    case 1:
                        drawableId = R.drawable.droid_back; break;
                    case 2:
                        drawableId = R.drawable.droid_left; break;
                    default:
                        drawableId = R.drawable.droid_right;
                }
                droidImage2.setImageResource(drawableId);
                Toast.makeText(getApplicationContext(), Integer.toString(droidSide2), Toast.LENGTH_SHORT).show();
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int drawableId;

                droidSide3 = r.nextInt(4);
                switch( droidSide3 ){
                    case 0:
                        drawableId = R.drawable.droid_front; break;
                    case 1:
                        drawableId = R.drawable.droid_back; break;
                    case 2:
                        drawableId = R.drawable.droid_left; break;
                    default:
                        drawableId = R.drawable.droid_right;
                }
                droidImage3.setImageResource(drawableId);
                Toast.makeText(getApplicationContext(), Integer.toString(droidSide3), Toast.LENGTH_SHORT).show();
                b3.setEnabled(false);
            }
        });
    }
}
