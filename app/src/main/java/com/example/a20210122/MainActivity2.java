package com.example.a20210122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView tv_title;
    private EditText edt_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_title = findViewById(R.id.tv_title);
        edt_input = findViewById(R.id.edt_input);

    }

    public void click(View view) {
        String txt=edt_input.getText().toString();
        tv_title.setText(txt);




    }
}