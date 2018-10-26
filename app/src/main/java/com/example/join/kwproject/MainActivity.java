package com.example.join.kwproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final Context ctx = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,LodingActivity.class);
        startActivity(intent);

    }


    public void Clicknextpage(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
     /*   Intent intent = new Intent(ctx, PopupActivity.class);

        startActivity(intent);//
*/





    }
}
