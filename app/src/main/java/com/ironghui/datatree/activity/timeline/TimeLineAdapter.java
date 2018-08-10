package com.ironghui.datatree.activity.timeline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ironghui.datatree.R;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.HorizontalVh> {
    private Context context;


    //时间节点数
    private int nodeNum = 0;

    //当前到达节点
    private int currentNode = 1;


    public TimeLineAdapter(Context context, int nodeNum) {
        this.context = context;
        this.nodeNum = nodeNum;
    }

    @Override
    public HorizontalVh onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.time_line, null, false);
        HorizontalVh vh = new HorizontalVh(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(HorizontalVh holder, int position) {
        if (position < currentNode) {
            //当前节点之前的全部设为已经经过
            holder.point.setImageResource(R.drawable.yuan2);
            holder.lineLeft.setBackgroundResource(R.color.colorPrimary);
            holder.lineRight.setBackgroundResource(R.color.colorPrimary);

        }

        // 去掉左右两头的分支
        if (position == 0) {
            holder.lineLeft.setVisibility(View.INVISIBLE);
        }
        if (position == nodeNum - 1) {
            holder.lineRight.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return nodeNum;
    }

    /**
     * 设置当前节点
     *
     * @param currentNode
     */
    public void setCurrentNode(int currentNode) {
        this.currentNode = currentNode;
        this.notifyDataSetChanged();
    }

    class HorizontalVh extends RecyclerView.ViewHolder {
        private ImageView point;

        private View lineLeft, lineRight;
        private TextView show_time;

        public HorizontalVh(View itemView) {
            super(itemView);
            this.point = (ImageView) itemView.findViewById(R.id.point);
            this.lineLeft = itemView.findViewById(R.id.line_left);
            this.lineRight = itemView.findViewById(R.id.line_right);
            this.show_time = itemView.findViewById(R.id.show_time);
        }
    }
}
