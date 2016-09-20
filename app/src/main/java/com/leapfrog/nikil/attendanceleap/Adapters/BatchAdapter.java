package com.leapfrog.nikil.attendanceleap.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.leapfrog.nikil.attendanceleap.Models.Batch;
import com.leapfrog.nikil.attendanceleap.Models.Course;
import com.leapfrog.nikil.attendanceleap.R;

import java.util.List;

/**
 * Created by Nikil on 9/20/2016.
 */
public class BatchAdapter extends ArrayAdapter {
    private List<Batch> batchList;
    private int resource;
    private LayoutInflater inflater;
    private Context context;
    public BatchAdapter(Context context, int resource, List<Batch> objects) {
        super(context, resource, objects);
        batchList=objects;
        this.resource=resource;
        this.context=context;

        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          BatchViewHolder holder;
        if(convertView==null){
            convertView= inflater.inflate(resource,null);
            holder= new BatchViewHolder();
            holder.tvBatchId=(TextView)convertView.findViewById(R.id.tvBatchId);
            holder.tvbatchCode=(TextView)convertView.findViewById(R.id.tvbatchCode);
            holder.tvCourseId=(TextView)convertView.findViewById(R.id.tvCourseId);
            holder.tvfacilitator=(TextView)convertView.findViewById(R.id.tvfacilitator);
            holder.tvstartDate=(TextView)convertView.findViewById(R.id.tvstartDate);
            holder.tvendDate=(TextView)convertView.findViewById(R.id.tvendDate);
            holder.tvtimingId=(TextView)convertView.findViewById(R.id.tvtimingId);
            holder.tvaddedDate=(TextView)convertView.findViewById(R.id.tvaddedDate);
            holder.tvmodifiedDate=(TextView)convertView.findViewById(R.id.tvmodifiedDate);

            convertView.setTag(holder);
        } else{
            holder =(BatchViewHolder) convertView.getTag();
        }

        holder.tvBatchId.setText(batchList.get(position).getBatchId());
        holder.tvbatchCode.setText(batchList.get(position).getBatchCode());
        holder.tvCourseId.setText(batchList.get(position).getCourseId()+"");
        holder.tvfacilitator.setText(batchList.get(position).getFacilitatorId()+"");
        holder.tvstartDate.setText(batchList.get(position).getStartDate());
        holder.tvendDate.setText(batchList.get(position).getEndDate());
        holder.tvtimingId.setText(batchList.get(position).getTimingId()+"");
        holder.tvaddedDate.setText(batchList.get(position).getAddedDate());
        holder.tvmodifiedDate.setText(batchList.get(position).getModifiedDate());

        return convertView;
    }

    static  class BatchViewHolder{
        public TextView tvBatchId;
        public TextView tvbatchCode;
        public TextView tvCourseId;
        public TextView tvfacilitator;
        public TextView tvstartDate;
        public TextView tvendDate;
        public TextView tvtimingId;
        public TextView tvaddedDate;
        public TextView tvmodifiedDate;

    }
}
