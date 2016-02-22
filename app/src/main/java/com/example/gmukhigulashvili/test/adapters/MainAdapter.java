package com.example.gmukhigulashvili.test.adapters;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmukhigulashvili.test.R;
import com.example.gmukhigulashvili.test.domain.MainFragment;
import com.example.gmukhigulashvili.test.interfaces.RecyclerViewOnClickListenerHack;

import java.util.List;

/**
 * Created by g.mukhigulashvili on 2/18/2016.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private List<MainFragment> mList;
    private LayoutInflater mLayoutInflater;
    RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;


    public MainAdapter(Context c, List<MainFragment> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.main_list_card2, viewGroup, false);
        MyViewHolder mvh =  new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.ivCar.setImageResource(mList.get(position).getPhoto());
        myViewHolder.tvModel.setText(mList.get(position).getModel());
        myViewHolder.tvBrand.setText(mList.get(position).getBrand());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListnerHack(RecyclerViewOnClickListenerHack r){
         mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(MainFragment c, int position){
         mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivCar;
        public TextView tvModel;
        public TextView tvBrand;


        public MyViewHolder(View itemView) {
            super(itemView);

            ivCar = (ImageView) itemView.findViewById(R.id.iv_car);
            tvModel =(TextView) itemView.findViewById(R.id.tv_model);
            tvBrand =(TextView) itemView.findViewById(R.id.tv_brand);

            itemView.setOnClickListener(this);



        }


        @Override
        public void onClick(View v) {
            if (mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListner(v, getAdapterPosition());
            }
        }
    }
}
