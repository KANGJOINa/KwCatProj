package com.example.join.kwproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;

public class SecondActivity extends AppCompatActivity {

    public static Object mOnPopupClick;
    private Handler handler = new Handler();

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mRecyclerView = findViewById(R.id.recycle2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        final ArrayList<RecycleInfoSecond> foodInfoArrayList2 = new ArrayList<>();

        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.pant,"신축성 있는 청바지\n15"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.shoose, "가죽 신발\n7"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.hat, "귀여운 모자 \n2"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.pant, "두꺼운 청바지 \n20"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.shoose,"그냥 신발\n5"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.acc, "따뜻한 목도리\n10"));

        SecondAdapter secondAdapter = new SecondAdapter(foodInfoArrayList2) {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(getApplicationContext(), position, Toast.LENGTH_LONG).show();
            }
        };

        mRecyclerView.setAdapter(secondAdapter);


    }

    public void Clicknextpage(View view){
        Intent intent = new Intent(this,TempActivity.class);
        startActivity(intent);

    }



}
