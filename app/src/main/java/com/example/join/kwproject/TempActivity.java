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

import android.app.Activity;
import android.os.AsyncTask;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class TempActivity extends AppCompatActivity {

    //////////////////////////////////////////////
    private final String sampleURL = "http://openapi.seoul.go.kr:8088/6c556b764f6b6a6d35334d76584a63/xml/ForecastWarningUltrafineParticleOfDustService/1/5/";
    parsingTask mParsingTask = null;
    public TempActivity() throws ParserConfigurationException, IOException, SAXException {
    }

    private ProgressBar tempprogress;
    static ProgressBar tempcloth;
    private int progressStatus = 0;
    private TextView temp,realtemp;

    static ImageView mainimage;
    static ImageView pant,top;

    static int temporature;

    static Boolean check[] = {false,false,false,false,false,false};

    private Handler handler = new Handler();

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;



    private class parsingTask
            extends AsyncTask<String, String, Boolean>{
        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Boolean doInBackground(String... url) {

            String APPLC_DT= null;
            String FA_ON = null;
            String POLLUTANT = null;
            String CAISTEP = null;
            String ALARM_CNDT = null;

            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(sampleURL);

                Element root = doc.getDocumentElement();
                APPLC_DT = root.getElementsByTagName("APPLC_DT").item(0).getTextContent();
                FA_ON = root.getElementsByTagName("FA_ON").item(0).getTextContent();
                POLLUTANT= root.getElementsByTagName("POLLUTANT").item(0).getTextContent();
                CAISTEP= root.getElementsByTagName("CAISTEP").item(0).getTextContent();
                ALARM_CNDT= root.getElementsByTagName("ALARM_CNDT").item(0).getTextContent();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            publishProgress(APPLC_DT, FA_ON,POLLUTANT, CAISTEP, ALARM_CNDT);

            return true;
        }
        @Override
        protected void onProgressUpdate(String... url){
            temp.setText(temp.getText().toString()+ url[0]+" °C");

        }
    }


    //////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);



        tempprogress = (ProgressBar)findViewById(R.id.progressTemp);
        tempcloth = (ProgressBar)findViewById(R.id.progressCloth);
        temp = (TextView)findViewById(R.id.Temp);
        realtemp =(TextView)findViewById(R.id.RealTemp);

        mainimage = (ImageView)findViewById(R.id.imagemain);
        pant = (ImageView)findViewById(R.id.imagepant);
        top =(ImageView)findViewById(R.id.imagetop);

        mainimage.setImageResource(R.drawable.model);
        temporature =0;


        temp.setText(temp.getText().toString() + " " );



        mRecyclerView = findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        final ArrayList<RecycleInfo> foodInfoArrayList = new ArrayList<>();
        foodInfoArrayList.add(0,new RecycleInfo(R.drawable.pants, "10"));
        foodInfoArrayList.add(1,new RecycleInfo(R.drawable.hat, "2"));
        foodInfoArrayList.add(2,new RecycleInfo(R.drawable.hat, "5"));
        foodInfoArrayList.add(3,new RecycleInfo(R.drawable.pant, "10"));
        foodInfoArrayList.add(4,new RecycleInfo(R.drawable.shoose, "2"));
        foodInfoArrayList.add(5,new RecycleInfo(R.drawable.hat, "5"));

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

        ///
        mParsingTask = new parsingTask();
        mParsingTask.execute(sampleURL);
        ///
    }

    public void ClickReset(View view){
       temporature = 5;
       tempcloth.setProgress(temporature);
        TempActivity.mainimage.setImageResource(R.drawable.model);

       for(int i=0;i<6;i++){
           check[i]=false;
       }
    }

    public void Clickbackpage(View view){
        Intent intent = new Intent(this,ArrayActivity.class);
        startActivity(intent);

    }
    public void ClickCloset(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

    }
}
