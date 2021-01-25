package com.example.a20210122;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity4 extends AppCompatActivity {
    Random rand = new Random();
    int[] arr = new int[25];
    //findViewById 25번힘듬
    Button[] btns = new Button[arr.length];//버튼 저장 공간 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //중복없이 랜덤으로 숫자 나오는 3가지 방법
        //1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 25 + 1);
            //arr[i] = rand.nextInt(25) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }
        //2




        //3. 1~25배열 세팅
        /*int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for(int i=0; i<100;i++){
            int n1=rand.nextInt(arr.length);
            int n2=rand.nextInt(arr.length);

            int temp=arr[n1];
            arr[n1]=arr[n2];
            arr[n2]=temp;

        }*/



        for (int i = 0; i < btns.length; i++) {
            int btnID = getResources().getIdentifier("button" + (i + 1), "id", getPackageName());
            //문자열(변수명)로 view와 id값(주소값)찾아오는 메소드
            btns[i] = findViewById(btnID);
            btns[i].setBackgroundColor(Color.parseColor("#FF6367"));
            //25개에 전부 숫자를 적어주려면 setText도 25번??
            // => 버튼이 배열에 들어있기 때문에 for문으로 일괄처리 가능
            btns[i].setText(arr[i] + "");
            //=>setText 괄호안에 int 넣을수 없다.
            //=> 정수를 넣으면 resource의 주소값이라 인식
        }


    }

}