package com.gnyapp.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11;
    private int click = 0;
    private Boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11);

        ArrayList<AppCompatButton> btn_list = new ArrayList<>();
        btn_list.add(btn_0);
        btn_list.add(btn_1);
        btn_list.add(btn_2);
        btn_list.add(btn_3);
        btn_list.add(btn_4);
        btn_list.add(btn_5);
        btn_list.add(btn_6);
        btn_list.add(btn_7);
        btn_list.add(btn_8);
        btn_list.add(btn_9);
        btn_list.add(btn_10);
        btn_list.add(btn_11);

        Collections.shuffle(btn_list);
        Collections.shuffle(btn_list);
        Collections.shuffle(btn_list);

        ArrayList<Integer> myImageList = new ArrayList<>();
        myImageList.add(R.drawable.camel);
        myImageList.add(R.drawable.coala);
        myImageList.add(R.drawable.lion);
        myImageList.add(R.drawable.monkey);
        myImageList.add(R.drawable.wolf);
        myImageList.add(R.drawable.fox);
        myImageList.add(R.drawable.camel);
        myImageList.add(R.drawable.coala);
        myImageList.add(R.drawable.lion);
        myImageList.add(R.drawable.monkey);
        myImageList.add(R.drawable.wolf);
        myImageList.add(R.drawable.fox);

        Collections.shuffle(myImageList);
        Collections.shuffle(myImageList);
        Collections.shuffle(myImageList);

        ArrayList<Integer> imgs = new ArrayList<>();
        ArrayList<AppCompatButton> btns = new ArrayList<>();

        for(int i = 0; i < btn_list.size(); i++){
            int finalI = i;
            btn_list.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(click < 2) {

                        btn_list.get(finalI).setBackgroundResource(myImageList.get(finalI));
                        imgs.add(myImageList.get(finalI));
                        btns.add(btn_list.get(finalI));
                        click++;
                        if(click == 2) {

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    click = 0;

                                    if(imgs.get(0) == imgs.get(1)) {
                                        for(int j = 0; j < btn_list.size(); j++){
                                            if(btn_list.get(j) == btns.get(0) || btn_list.get(j) == btns.get(1)){
                                                btn_list.get(j).setVisibility(View.INVISIBLE);
                                            }
                                        }
                                    }

                                    for(int j = 0; j < btn_list.size(); j++){
                                        btn_list.get(j).setBackgroundResource(R.drawable.code);
                                    }

                                    imgs.clear();
                                    btns.clear();
                                }
                            }, 1000);


                        }

                    }



                }
            });
        }





    }
}