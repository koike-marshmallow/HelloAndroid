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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("DroidSlot");

        final ImageView droidImage1 = (ImageView)this.findViewById(R.id.droidimageid1);
        final Random r = new Random();
        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);

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
    }
}
