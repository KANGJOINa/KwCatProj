package com.example.join.kwproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class DbActivity extends AppCompatActivity {

    EditText et;
    String sfName = "myFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        et = (EditText)findViewById(R.id.editText1);

        // 지난번 저장해놨던 사용자 입력값을 꺼내서 보여주기
        SharedPreferences sf = getSharedPreferences(sfName, 0);
        String str = sf.getString("name", ""); // 키값으로 꺼냄
        et.setText(str); // EditText에 반영함



    }

    @Override
    protected void onStop() {
        super.onStop();
        // Activity 가 종료되기 전에 저장한다
        // SharedPreferences 에 설정값(특별히 기억해야할 사용자 값)을 저장하기
        SharedPreferences sf = getSharedPreferences(sfName, 0);
        SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요
        String str = et.getText().toString(); // 사용자가 입력한 값
        editor.putString("name", str); // 입력
        editor.putString("xx", "xx"); // 입력
        editor.commit(); // 파일에 최종 반영함
    }



}
