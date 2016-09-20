package com.leapfrog.nikil.attendanceleap.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.leapfrog.nikil.attendanceleap.Models.Course;
import com.leapfrog.nikil.attendanceleap.R;

import java.util.List;

/**
 * Created by Nikil on 9/18/2016.
 */
public class CourseAdapter extends ArrayAdapter {

    private List<Course>courseList;
    private int resource;
    private LayoutInflater inflater;
    private Context context;

    public CourseAdapter(Context context, int resource, List<Course> objects) {
        super(context, resource, objects);
        courseList=objects;
        this.resource=resource;
        this.context=context;

         inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
     public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder ;
        if(convertView==null){
           convertView= inflater.inflate(resource,null);
            holder= new ViewHolder();
            holder.tvCourseId=(TextView)convertView.findViewById(R.id.tvCourseId);
            holder.tvCourseName=(TextView)convertView.findViewById(R.id.tvCourseName);

            convertView.setTag(holder);
        } else{
            holder =(ViewHolder) convertView.getTag();
        }

           holder.tvCourseId.setText(courseList.get(position).getCourseId()+"");
           holder.tvCourseId.setText(courseList.get(position).getCourseName());
        return convertView;
    }

    static class ViewHolder{
        public TextView tvCourseId;
        public TextView tvCourseName;
    }
}
