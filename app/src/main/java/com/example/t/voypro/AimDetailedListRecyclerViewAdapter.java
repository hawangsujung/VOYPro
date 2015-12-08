package com.example.t.voypro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by T on 2015-12-01.
 */
public class AimDetailedListRecyclerViewAdapter extends RecyclerView.Adapter<AimDetailedListRecyclerViewAdapter.AimDetailedListDataHolder> {
    private static String LOG_TAG = "AimDetailedListRecyclerViewAdapter";
    private ArrayList<AimDetailedListData> mDataset;
    private static MyClickListener myClickListener;

    public static class AimDetailedListDataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView startDate, content, success, successDate;

        public AimDetailedListDataHolder(View itemView) {
            super(itemView);
            startDate = (TextView) itemView.findViewById(R.id.detailedText1);
            content = (TextView) itemView.findViewById(R.id.detailedText2);
            success = (TextView) itemView.findViewById(R.id.detailedText3);
            successDate = (TextView) itemView.findViewById(R.id.successDate);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public AimDetailedListRecyclerViewAdapter(ArrayList<AimDetailedListData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public AimDetailedListDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aim_detailed_cardview, parent, false);
        AimDetailedListDataHolder detailedDataObjectHolder = new AimDetailedListDataHolder(view);
        return detailedDataObjectHolder;
    }

    @Override
    public void onBindViewHolder(AimDetailedListDataHolder holder, int position) {
        holder.startDate.setText(mDataset.get(position).getStartDate());
        holder.content.setText  (mDataset.get(position).getContent());
        holder.success.setText(mDataset.get(position).getSuccess());
        holder.successDate.setText(mDataset.get(position).getSuccessDate());
    }

    public void addItem(AimDetailedListData dataObj, int index) {
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

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}