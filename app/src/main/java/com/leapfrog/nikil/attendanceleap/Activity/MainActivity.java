package com.leapfrog.nikil.attendanceleap.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leapfrog.nikil.attendanceleap.Adapters.CourseAdapter;
import com.leapfrog.nikil.attendanceleap.Models.Course;
import com.leapfrog.nikil.attendanceleap.R;
import com.leapfrog.nikil.attendanceleap.util.Grabber;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ListView listView;
    private CourseAdapter courseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnGetlist);
        listView = (ListView) findViewById(R.id.listviewCourse);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CourseAsyncTask().execute("");

            }

        });
    }

    public class CourseAsyncTask extends AsyncTask<String, String, List<Course>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Course> doInBackground(String... params) {

            try {


                String finalJson = Grabber.get(params[0]);

                Log.e("test",finalJson);

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("courses");

                List<Course> courseList = new ArrayList<>();

                Gson gson = new Gson();
                for (int i = 0; i < parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);

                    Course course = gson.fromJson(finalObject.toString(), Course.class);

                    courseList.add(course);
                }
                return courseList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }


        @Override
        protected void onPostExecute(final List<Course> courses) {
            super.onPostExecute(courses);
            if (courses != null) {
                courseAdapter = new CourseAdapter(getApplicationContext(), R.layout.itemcourse, courses);
                listView.setAdapter(courseAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Course course=courses.get(position);
                        Intent intent=new Intent(MainActivity.this,BatchActivity.class);

                        startActivity(intent);
                        Log.e("test", "Test");
                    }
                });
            }
            else{
                Toast.makeText(getApplicationContext(),"URL Cannot be fetched Try network connection",Toast.LENGTH_LONG).show();
            }


        }
    }
}
