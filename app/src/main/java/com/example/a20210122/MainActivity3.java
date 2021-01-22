package com.example.a20210122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    int[] img = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    int i, j;
    private ImageView img_view1, img_view2 = null;
    private TextView Dice, leftResult, textView3, rightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        i = 0;
        j = 0;
        img_view1 = (ImageView) findViewById(R.id.ran_img1);
        img_view2 = (ImageView) findViewById(R.id.ran_img2);

        Dice = findViewById(R.id.Dice);
        leftResult = findViewById(R.id.leftResult);
        textView3 = findViewById(R.id.textView3);
        rightResult = findViewById(R.id.rightResult);
    }


    public void shpae(View view) {
        Random ram = new Random();
        int num1 = ram.nextInt(img.length);
        int num2 = ram.nextInt(img.length);

        img_view1.setImageResource(img[num1]);
        img_view2.setImageResource(img[num2]);

        if (num1 < num2) {
            j++;
            rightResult.setText(j+"");

        } else if (num1>num2){
            i++;

            leftResult.setText(i+"");

        }
        else{
            Toast.makeText(this, "비김", Toast.LENGTH_SHORT).show();
        }


    }
}