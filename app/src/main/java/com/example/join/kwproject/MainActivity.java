package com.example.join.kwproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //final Context ctx = this;

    EditText idedit,passedit;
    TextView Notice ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,LodingActivity.class);
        startActivity(intent);

        idedit = (EditText)findViewById(R.id.idtxt);
        passedit = (EditText)findViewById(R.id.passwordtxt);
        Notice = (TextView)findViewById(R.id.notice);
    }


    public void Clicknextpage(View view){

        Intent intent = new Intent(this,ArrayActivity.class);
        startActivity(intent);

      /*  if(idedit.getText().toString()=="JOIN"){

            if(passedit.getText().toString()=="0622"){

                Intent intent = new Intent(this,DbActivity.class);
        startActivity(intent);
            }
        else {
                Notice.setText("비밀 번호를 다시 입력하세요.");}

        }else {
            Notice.setText("아이디를 다시 입력하세요.");}*/
     /*   Intent intent = new Intent(ctx, PopupActivity.class);

        startActivity(intent);//
*/





    }
}
