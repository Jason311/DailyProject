package com.jason.dailyproject.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jason.dailyproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期: 2017/9/21 on 下午7:40
 * 描述: 首页RecycleView Adapter
 * 作者: Jason  jianbo311@163.com
 */
public class RecycleviewAdapter extends RecyclerView.Adapter {

    private Context context;

    private List<IntentBean> intentBeanList = new ArrayList<>();

    public RecycleviewAdapter(Context context, List<IntentBean> intentBeanList) {
        this.context = context;
        this.intentBeanList = intentBeanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View itemView = layoutInflater.inflate(R.layout.item_main, null, false);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_main, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final IntentBean bean = intentBeanList.get(position);
        myViewHolder.item_main_tv.setText(bean.getDemoName());
        myViewHolder.item_main_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, bean.getActivity().getClass());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return intentBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item_main_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_main_tv = itemView.findViewById(R.id.activityName_tv);
        }
    }

}
