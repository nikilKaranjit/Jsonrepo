package com.leapfrog.nikil.attendanceleap.Activity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.leapfrog.nikil.attendanceleap.Adapters.BatchAdapter;
import com.leapfrog.nikil.attendanceleap.Adapters.CourseAdapter;
import com.leapfrog.nikil.attendanceleap.Models.Batch;
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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikil on 9/19/2016.
 */
public class BatchActivity extends AppCompatActivity {
    private ListView listView;
    private BatchAdapter batchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch);

        listView = (ListView) findViewById(R.id.listviewCourse);
           //yo part ma pani execute garda pani bhayena mainactivity bata listview ko item click garda
        //yo page ko json parse hunu parcha

    }



        public class BatchAsyncTask extends AsyncTask<String, String, List<Batch>> {


            @Override
            protected List<Batch> doInBackground(String... params) {
                HttpURLConnection connection = null;
                BufferedReader reader = null;

                try {


                    String finalJson = Grabber.get(params[0]);

                    Log.e("test", finalJson);

                    JSONObject parentObject = new JSONObject(finalJson);
                    JSONArray parentArray = parentObject.getJSONArray("batches");

                    List<Batch> batchList = new ArrayList<>();

                    Gson gson = new Gson();
                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);

                        Batch batch = gson.fromJson(finalObject.toString(), Batch.class);

                        batchList.add(batch);
                    }
                    return batchList;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;

            }

            @Override
            protected void onPostExecute(List<Batch> batches) {
                super.onPostExecute(batches);
                if (batches != null) {
                    batchAdapter = new BatchAdapter(getApplicationContext(), R.layout.itembatch, batches);
                    listView.setAdapter(batchAdapter);
                }


            }
    }
}
