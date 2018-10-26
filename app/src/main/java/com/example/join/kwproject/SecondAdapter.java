package com.example.join.kwproject;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public abstract class SecondAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {


    private int temp = TempActivity.temporature;

    private OnItemClickListener onItemClickListener;

    private ImageButton Pic1,Pic2;
    private TextView textsec;




    public abstract void onItemClick(View view, int position);

    private ItemClick itemClick;



    public interface ItemClick {
        public void onClick(View view, int position);


    }

    //아이템 클릭시 실행 함수 등록 함수
    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;

    }



    public interface OnItemClickListener {
        void onItemClick(View v, int position);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {



        MyViewHolder(View view){
            super(view);

            Pic1 = view.findViewById(R.id.pic1);
            //Pic2 = view.findViewById(R.id.pic2);
            textsec = view.findViewById(R.id.secText);


        }


        public ImageButton getBtnTest1() {
            return Pic1;
        }

    /*    public ImageButton getBtnTest2() {
            return Pic2;
        }*/
    }






    private ArrayList<RecycleInfoSecond> foodInfoArrayList2;
    SecondAdapter(ArrayList<RecycleInfoSecond> foodInfoArrayList2){
        this.foodInfoArrayList2 = foodInfoArrayList2;

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_view_recycle, parent, false);

        return new MyViewHolder(v);
    }

    public SecondAdapter(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        MyViewHolder myViewHolder = (MyViewHolder) holder;

        Pic1.setImageResource(foodInfoArrayList2.get(position).drawable1);
        //Pic2.setImageResource(foodInfoArrayList2.get(position).drawable2);
        textsec.setText(foodInfoArrayList2.get(position).textsecond);




        myViewHolder.getBtnTest1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




           /*         Intent intent = new Intent(this, PopupActivity.class);

                    startActivityForResult(intent, 1);*/

            }
        });

     /*   myViewHolder.getBtnTest2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }





    @Override
    public int getItemCount() {
        return foodInfoArrayList2.size();
    }


}
