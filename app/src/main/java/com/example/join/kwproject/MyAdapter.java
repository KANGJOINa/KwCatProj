package com.example.join.kwproject;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private int temp = TempActivity.temporature;

    private OnItemClickListener onItemClickListener;
    private ImageButton ivPicture;
    TextView tvPrice;

    public abstract void onItemClick(View view, int position);

    private ItemClick itemClick;

    public interface ItemClick {
        public void onClick(View view,int position);


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

            ivPicture = view.findViewById(R.id.iv_picture);
            tvPrice = view.findViewById(R.id.tv_price);


        }


        public ImageButton getBtnTest() {
            return ivPicture;
        }
    }






    private ArrayList<RecycleInfo> foodInfoArrayList;
    MyAdapter(ArrayList<RecycleInfo> foodInfoArrayList){
        this.foodInfoArrayList = foodInfoArrayList;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(v);
    }

    public MyAdapter(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        ivPicture.setImageResource(foodInfoArrayList.get(position).drawableId);
        tvPrice.setText(foodInfoArrayList.get(position).price);



        myViewHolder.getBtnTest().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TempActivity.check[position]==false) {
                    TempActivity.temporature += Integer.parseInt(foodInfoArrayList.get(position).price.toString());
                    TempActivity.tempcloth.setProgress(TempActivity.temporature);
                    Log.d("test", "" + position + "  " + TempActivity.temporature);
                    TempActivity.top.setImageResource(foodInfoArrayList.get(position).drawableId);
                    TempActivity.check[position]=true;

                } else{
                    TempActivity.temporature -= Integer.parseInt(foodInfoArrayList.get(position).price.toString());
                    TempActivity.tempcloth.setProgress(TempActivity.temporature);
                    Log.d("test", "" + position + "  " + TempActivity.temporature);
                    TempActivity.top.setImageResource(R.drawable.model);
                    TempActivity.check[position]=false;

                }

            }
        });


    }



    @Override
    public int getItemCount() {
        return foodInfoArrayList.size();
    }


}
