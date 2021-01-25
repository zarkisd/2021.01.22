package com.example.a20210122;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

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
    int count = 1;
    int i = 0;
    Chronometer ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //중복없이 랜덤으로 숫자 나오는 3가지 방법
        ch=findViewById(R.id.textView);
        ch.start();
        //1
        for (i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 25 + 1);
            //arr[i] = rand.nextInt(25) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }


        //ch.start();
        //2
        /*arraylist 이용방법
        ArrayList<Integer> card=new ArrayList<>();
        for(int i =1; i<=25;i++){
         card.add(i)}
        for(int i=0; i<num.length;i++){
         int num=rand.nextInt(card.size());
         nums[i]=card.get(num);
         card.remove(num);
         }*/


        /*Set<Integer> set=new HashSet<>();
        while (set.size()<25){
            Double d=Math.random()*25+1;
            set.add(d.intValue());
        }
        List<Integer> arr=new ArrayList<>(set);
        Collections.sort(arr)*/


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


        for (i = 0; i < btns.length; i++) {
            int btnID = getResources().getIdentifier("button" + (i + 1), "id", getPackageName());
            //문자열(변수명)로 view와 id값(주소값)찾아오는 메소드
            btns[i] = findViewById(btnID);
            btns[i].setBackgroundColor(Color.parseColor("#FF6367"));
            //25개에 전부 숫자를 적어주려면 setText도 25번??
            // => 버튼이 배열에 들어있기 때문에 for문으로 일괄처리 가능
            btns[i].setText(arr[i] + "");
            //=>setText 괄호안에 int 넣을수 없다.
            //=> 정수를 넣으면 resource의 주소값이라 인식
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //현재 클릭이 발생한 뷰
                   // v.setVisibility(View.INVISIBLE);

                    //현재 누른 버튼에 적힌 숫자 Toast에 띄워주기
                    Toast.makeText(MainActivity4.this, ((Button) v).getText() + "", Toast.LENGTH_SHORT).show();

                    if (count == Integer.parseInt(((Button) v).getText() + "")) {
                        v.setVisibility(View.INVISIBLE);
                        Log.v("value", ((Button) v).getText() + " 맞게 했어요");
                        count++;

                    }
                    else{
                        Log.v("value", "틀렸어요");
                    }
                    if(count==26){
                        ch.stop();
                    }


                    //업캐스팅
                    //상위 클래스 타입의 변수에 하위 클래스 객체 담기
                    //다운캐스팅
                    //하위 클래스에서 새롭게 만들어낸 기능을 상위 클래스에서 사용하기 위해
                }


            });
            //객체 생성과 동시에 오버라이딩
        }


    }

}