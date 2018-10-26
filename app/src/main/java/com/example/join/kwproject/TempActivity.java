package com.example.join.kwproject;

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

public class TempActivity extends AppCompatActivity {

    private ProgressBar tempprogress;
    static ProgressBar tempcloth;
    private int progressStatus = 0;
    private TextView temp,realtemp;

    static ImageView mainimage;

    static int temporature;

    static Boolean check[] = {false,false,false,false,false,false};

    private Handler handler = new Handler();

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        tempprogress = (ProgressBar)findViewById(R.id.progressTemp);
        tempcloth = (ProgressBar)findViewById(R.id.progressCloth);
        temp = (TextView)findViewById(R.id.Temp);
        realtemp =(TextView)findViewById(R.id.RealTemp);
        mainimage = (ImageView)findViewById(R.id.imagemain);

        mainimage.setImageResource(R.drawable.model);
        temporature =0;


        temp.setText(temp.getText().toString() + " "+ temporature+ " °C");



        mRecyclerView = findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        final ArrayList<RecycleInfo> foodInfoArrayList = new ArrayList<>();
        foodInfoArrayList.add(new RecycleInfo(R.drawable.pant, "10"));
        foodInfoArrayList.add(new RecycleInfo(R.drawable.shoose, "2"));
        foodInfoArrayList.add(new RecycleInfo(R.drawable.hat, "5"));
        foodInfoArrayList.add(new RecycleInfo(R.drawable.pant, "10"));
        foodInfoArrayList.add(new RecycleInfo(R.drawable.shoose, "2"));
        foodInfoArrayList.add(new RecycleInfo(R.drawable.hat, "5"));

        MyAdapter myAdapter = new MyAdapter(foodInfoArrayList) {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(getApplicationContext(), position, Toast.LENGTH_LONG).show();
            }
        };

        mRecyclerView.setAdapter(myAdapter);





        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 60) {
                    progressStatus += 5;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            tempprogress.setProgress(progressStatus);

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public void ClickReset(View view){
       temporature = 5;
       tempcloth.setProgress(temporature);
        TempActivity.mainimage.setImageResource(R.drawable.maneq);

       for(int i=0;i<6;i++){
           check[i]=false;
       }
    }

    public void Clickbackpage(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

    }
}
