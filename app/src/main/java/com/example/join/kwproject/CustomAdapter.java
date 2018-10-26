package com.example.join.kwproject;



import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>  {

    private ArrayList<Dictionary> mList;
    private Context mContext;



    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener { // 1. 리스너 추가

        protected TextView mId;
        //protected ImageView mId;

        protected TextView mEnglish;
        protected TextView mKorean;





        public CustomViewHolder(View view) {
            super(view);

            this.mId = (TextView) view.findViewById(R.id.textview_recyclerview_id);
            this.mEnglish = (TextView) view.findViewById(R.id.textview_recyclerview_english);
            this.mKorean = (TextView) view.findViewById(R.id.textview_recyclerview_korean);

            view.setOnCreateContextMenuListener(this); //2. 리스너 등록
        }




        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {  // 3. 메뉴 추가U

            MenuItem Edit = menu.add(Menu.NONE, 1001, 1, "편집");
            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);

        }

        // 4. 캔텍스트 메뉴 클릭시 동작을 설정
        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                switch (item.getItemId()) {
                    case 1001:

                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        View view = LayoutInflater.from(mContext)
                                .inflate(R.layout.edit_box, null, false);
                        builder.setView(view);
                        final Button ButtonSubmit = (Button) view.findViewById(R.id.button_dialog_submit);
                        final EditText editTextID = (EditText) view.findViewById(R.id.edittext_dialog_id);
                        final EditText editTextEnglish = (EditText) view.findViewById(R.id.edittext_dialog_endlish);
                        final EditText editTextKorean = (EditText) view.findViewById(R.id.edittext_dialog_korean);

                        editTextID.setText(mList.get(getAdapterPosition()).getId());
                        editTextEnglish.setText(mList.get(getAdapterPosition()).getEnglish());
                        editTextKorean.setText(mList.get(getAdapterPosition()).getKorean());

                        final AlertDialog dialog = builder.create();
                        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                String strID = editTextID.getText().toString();
                                String strEnglish = editTextEnglish.getText().toString();
                                String strKorean = editTextKorean.getText().toString();

                                Dictionary dict = new Dictionary(strID, strEnglish, strKorean );

                                mList.set(getAdapterPosition(), dict);
                                notifyItemChanged(getAdapterPosition());

                                dialog.dismiss();
                            }
                        });

                        dialog.show();

                        break;

                    case 1002:

                        mList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), mList.size());

                        break;

                }
                return true;
            }
        };


    }



    public CustomAdapter(Context context, ArrayList<Dictionary> list) {
        mList = list;
        mContext = context;

    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {



        viewholder.mId.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.mEnglish.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.mKorean.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewholder.mId.setGravity(Gravity.CENTER);
        viewholder.mEnglish.setGravity(Gravity.CENTER);
        viewholder.mKorean.setGravity(Gravity.CENTER);

        viewholder.mId.setText(mList.get(position).getId());
        viewholder.mEnglish.setText(mList.get(position).getEnglish());
        viewholder.mKorean.setText(mList.get(position).getKorean());

    }


    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }



}