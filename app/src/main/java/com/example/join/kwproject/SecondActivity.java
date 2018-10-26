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

        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.pant,"123"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.shoose, "234"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.hat, "3"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.pant, "12443"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.shoose,"1523"));
        foodInfoArrayList2.add(new RecycleInfoSecond(R.drawable.hat, "12223"));

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
