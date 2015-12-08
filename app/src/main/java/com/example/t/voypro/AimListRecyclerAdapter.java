package com.example.t.voypro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-12-07.
 */
public class AimListRecyclerAdapter extends RecyclerView.Adapter<AimListRecyclerAdapter.AimDataHolder> {
    private static String LOG_TAG = AimListRecyclerAdapter.class.getName();
    private List<AimListData> mDataset = new ArrayList<AimListData>();

    public AimListRecyclerAdapter(ArrayList<AimListData> dataset) {
        mDataset = dataset;
    }

    @Override
    public AimListRecyclerAdapter.AimDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);

        AimListRecyclerAdapter.AimDataHolder dataObjectHolder = new AimListRecyclerAdapter.AimDataHolder(view);
        return dataObjectHolder;
    }
    public static class AimDataHolder extends RecyclerView.ViewHolder {
        TextView tag;
        TextView content;
        TextView startDate;
        TextView week;
        TextView date;

        public AimDataHolder(View itemView) {
            super(itemView);
            tag = (TextView) itemView.findViewById(R.id.tag);
            content = (TextView) itemView.findViewById(R.id.textView2);
            startDate = (TextView) itemView.findViewById(R.id.textView3);
            week = (TextView) itemView.findViewById(R.id.textView4);
            date = (TextView) itemView.findViewById(R.id.textView5);
        }
    }
    @Override
    public void onBindViewHolder(AimListRecyclerAdapter.AimDataHolder holder, int position) {
        AimListData aimData = mDataset.get(position);

        //  holder.tag.setText(String.valueOf(aimData.tag));
        // holder.tag.setText(aimData.tag);
        holder.tag.setText(mDataset.get(position).tag.toString());
        holder.content.setText(mDataset.get(position).content.toString());
        holder.date.setText(mDataset.get(position).alam.toString());
        holder.week.setText(mDataset.get(position).week.toString());
    }

    public void addItem(AimListData dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}