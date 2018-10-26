package com.example.join.kwproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ArrayActivity  extends AppCompatActivity {


    private static String TAG = "recyclerview_example";

    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);



        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mArrayList = new ArrayList<>();


        mAdapter = new CustomAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ArrayActivity.this);
                View view = LayoutInflater.from(ArrayActivity.this)
                        .inflate(R.layout.edit_box, null, false);
                builder.setView(view);
                final Button ButtonSubmit = (Button) view.findViewById(R.id.button_dialog_submit);
                final EditText editTextID = (EditText) view.findViewById(R.id.edittext_dialog_id);
                final EditText editTextEnglish = (EditText) view.findViewById(R.id.edittext_dialog_endlish);
                final EditText editTextKorean = (EditText) view.findViewById(R.id.edittext_dialog_korean);

                ButtonSubmit.setText("삽입");


                final AlertDialog dialog = builder.create();
                ButtonSubmit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String strID = editTextID.getText().toString();
                        String strEnglish = editTextEnglish.getText().toString();
                        String strKorean = editTextKorean.getText().toString();

                        Dictionary dict = new Dictionary(strID, strEnglish, strKorean );

                        mArrayList.add(0, dict); //첫 줄에 삽입
                        //mArrayList.add(dict); //마지막 줄에 삽입
                        mAdapter.notifyDataSetChanged(); //변경된 데이터를 화면에 반영



                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
    public void ClickTemp(View view){
        Intent intent = new Intent(this,TempActivity.class);
        startActivity(intent);

    }





}
