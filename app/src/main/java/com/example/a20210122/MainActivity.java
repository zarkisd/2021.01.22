package com.example.a20210122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int i;
    int[] img = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    private ImageView img_view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = 0;
        img_view = (ImageView) findViewById(R.id.img1);
    }

    public void pre(View view) {
        Log.v("myValue1", "이전버튼을 눌렀습니다.");
        
        i--;
        if (i == -1) {
            i = 0;
            Toast.makeText(this, "맨 앞", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "이전 버튼누름", Toast.LENGTH_SHORT).show();
            
        }
        img_view.setImageResource(img[i]);
    }
    public void next(View view) {

        Log.v("myValue2", "다음버튼을 눌렀습니다.");

        i++;
        if (i == img.length) {
            i = img.length-1;
            Toast.makeText(this, "끝", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "다음 버튼누름", Toast.LENGTH_SHORT).show();
        }
        img_view.setImageResource(img[i]);

    }
}