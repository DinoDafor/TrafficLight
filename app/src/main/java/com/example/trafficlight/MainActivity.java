package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bulb_1,bulb_2,bulb_3;
    private Button button1;
    private boolean start_stop = false;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulb_1 = findViewById(R.id.bulb_1);
        bulb_2 = findViewById(R.id.bulb_2);
        bulb_3 = findViewById(R.id.bulb_3);
        button1 = findViewById(R.id.button1);
    }

    public void onClickStart(View view){
        if (!start_stop){
            start_stop = true;
            button1.setText("Stop");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start_stop){
                    counter++;
                    switch(counter){
                        case 1:
                            bulb_1.setBackgroundColor(getResources().getColor(R.color.green));
                            bulb_2.setBackgroundColor(getResources().getColor(R.color.grey));
                            bulb_3.setBackgroundColor(getResources().getColor(R.color.grey));
                            break;
                        case 2:
                            bulb_1.setBackgroundColor(getResources().getColor(R.color.grey));
                            bulb_2.setBackgroundColor(getResources().getColor(R.color.yellow));
                            bulb_3.setBackgroundColor(getResources().getColor(R.color.grey));
                            break;
                        case 3:
                            bulb_1.setBackgroundColor(getResources().getColor(R.color.grey));
                            bulb_2.setBackgroundColor(getResources().getColor(R.color.grey));
                            bulb_3.setBackgroundColor(getResources().getColor(R.color.red));
                            counter = 0;
                            break;

                    }

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        }
        else
        {
            start_stop = false;
            button1.setText("Start");

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}