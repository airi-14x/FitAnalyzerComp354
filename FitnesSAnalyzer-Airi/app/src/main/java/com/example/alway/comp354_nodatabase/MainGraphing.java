package com.example.alway.comp354_nodatabase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class MainGraphing extends AppCompatActivity {



    static ArrayList<Integer> y_axis_int = new ArrayList<Integer>();
    static ArrayList<Double> y_axis = new ArrayList<Double>();

    static ArrayList<Date> x_axis = new ArrayList<Date>();
    static ArrayList<Double> x_axis_double = new ArrayList<Double>();

    String time1 = "2018-10-03T09:35:00.000Z";
    String time2 = "2018-10-03T23:00:00.000Z";
    String time3 = "2018-10-04T14:35:00.000Z";
    String time4 = "2018-10-05T17:35:00.000Z";
    String time5 = "2018-10-06T19:35:00.000Z";

    static ArrayList<String> time_list = new ArrayList<String>();
    static ArrayList<myPair> unsorted_list = new ArrayList<myPair>();

    static Graphing new_graph;

    boolean isPair = false; // For Graph #3 --> Needs the X to be in ASC order //
    boolean isGraph1 = false;
    boolean isGraph2 = false;

    ArrayList<WorkOut> jsonData ;
    static WorkOutSet current_set = new WorkOutSet();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_graphing);

        Log.d("test1","is this working");

        jsonData = getIntent().getExtras().getParcelableArrayList("workoutData");

        //List<WorkOut> jsonData = getIntent().getExtras().getParcelable("workoutData");

        Log.d("parcelable", "please tell me this works");

        //new GraphingTask().execute("Starting Graphing Task");
        new_graph = new Graphing(this);
        Log.d("test2","is this working");

        /*
            GRAPH #1 & GRAPH #2 are ONLY Functional if you call them one at a time from this onCreate() method.
            - The buttons do not work properly. It would take 2 - 3 minutes to render the x-axis and it will skip frames.
            - Async and creating a new thread didn't make it run better.
            - ** THE ISSUE MIGHT BE FROM THE CONVERSIONS DONE IN THE BACKGROUND **
            - Though, I attempted to use Async to run it in the background but it doesn't work...
            >> String --> UNIX time --> Java.Date --> getTime() [Results in: 2018/10/03]
         */

        // TESTING SCENARIO: GRAPH #1 //
        // CREATE A GRAPH via Constructor + Set Labels //


        /*new_graph.select_graph(1);

        // SETTING X-AXIS: String List via str_format_date() //
        time_list.add(time1);
        time_list.add(time2);
        time_list.add(time3);
        time_list.add(time4);
        time_list.add(time5);
        new_graph.str_format_date(time_list);

        // SETTING Y-AXIS: Integer List //
        y_axis_int.add(30);
        y_axis_int.add(20);
        y_axis_int.add(40);
        y_axis_int.add(10);
        y_axis_int.add(50);
        new_graph.setY_axis_Integer(y_axis_int);

        // DISPLAY GRAPH via set_series() //
        displaying_graph();
        time_list.clear();*/


        /* ==========================================================
            TO SET: Using Workout Data --> Get X values & Y Values
            - Extract from WorkOutSet the List<WorkOut>
            - Get the necessary parameters.
            >> UNCOMMENT OUT THESE LINES BELOW <<
           ==========================================================
         */

          //to test graph 1 uncomment this block


        new_graph.select_graph(1);
        isGraph1 = true;
        WorkOutSet current_set = new WorkOutSet();
        //List<WorkOut> data = current_set.getworkOutList(); // GET list<Workout>

        for(int i = jsonData.size() - 1; i >= 0; i--)
        {
            WorkOut current_data = jsonData.get(i);
            Log.d("Test_index", "current " + i);
            Log.d("Test_value", "Value " + current_data.getStartTime());
            time_list.add(current_data.getStartTime());
            y_axis_int.add(current_data.getDurationSec());
        }

        new_graph.str_format_date(time_list);
        new_graph.setY_axis_Integer(y_axis_int);
        displaying_graph();
        time_list.clear();



        // TESTING SCENARIO: GRAPH #2 //

         /* ==========================================================
            TO SET: Using Workout Data --> Get X values & Y Values
            - Extract from WorkOutSet the List<WorkOut>
            - Get the necessary parameters.
            >> UNCOMMENT OUT THESE LINES BELOW <<
           ==========================================================
         */

        /*  //to test graph2 uncomment this block
        new_graph.select_graph(2);
        isGraph2 = true;
        current_set = new WorkOutSet();
        //List<WorkOut> data = current_set.getworkOutList(); // GET list<Workout>

        for(int i = jsonData.size() - 1; i >= 0; i--)
        {
            WorkOut current_data = jsonData.get(i);
            time_list.add(current_data.getStartTime());
            y_axis.add(current_data.getDistanceKm());
        }

        new_graph.str_format_date(time_list);
        new_graph.setY_axis_Double(y_axis);
        displaying_graph();
        time_list.clear();
        */


        /* GRAPH #3 Runs with the Button */

        // TESTING SCENARIO: GRAPH #3 //
        // CREATE A GRAPH via Constructor + Set Labels //
        //new_graph = new Graphing(this);
        //new_graph.select_graph(3);

    }

    static private class GraphingTask extends AsyncTask<String, Graphing, String> {

        @Override
        protected String doInBackground(String... strings) {
            Log.d("test1", "Value1");
            //time_list.add(time1);
            //time_list.add(time2);
            //time_list.add(time3);
            //time_list.add(time4);
            //time_list.add(time5);
            //y_axis_int.add(30);
            //y_axis_int.add(20);
            //y_axis_int.add(40);
            //y_axis_int.add(10);
            //y_axis_int.add(50);
            //new_graph.str_format_date(time_list);
            //new_graph.setY_axis_Integer(y_axis_int);
            new_graph.set_series();
            //publishProgress(new_graph);
            //new_graph.setGraph();
            Log.d("test2", "Value2");
            return "Executed";
        }

        @Override
        protected void onProgressUpdate(Graphing... values) {
            //new_graph.setGraph();
        }

        protected void onPostExecute(String display_graph) {
            //new_graph.set_series();
            //new_graph.setGraph();
        }


    }


    public void select_button(View v) {

        switch (v.getId()) {

            case R.id.graph1_radio:
                time_list.clear();
                y_axis_int.clear();

                //displaying_graph();
                time_list.clear();
                break;

            case R.id.graph2_radio:
                time_list.clear();
                y_axis.clear();
                time_list.clear();
                break;


                //comment this block and uncomment the next one
            case R.id.graph3_radio:

                 /* ==========================================================
                 TO SET: Using Workout Data --> Get X values & Y Values
                 - Extract from WorkOutSet the List<WorkOut>
                 - Get the necessary parameters.
                 >> UNCOMMENT OUT THESE LINES BELOW <<
                ==========================================================
                */

                x_axis_double.clear();
                y_axis.clear();
                isPair = true;
                new_graph.select_graph(3);
                current_set = new WorkOutSet();
                //jsonData = getIntent().getExtras().getParcelable("workoutData");

                ArrayList<WorkOut> data = jsonData; // GET list<Workout>
                for (int i = 0; i < data.size(); i++) {
                    WorkOut current_data = data.get(i);
                    x_axis_double.add(current_data.getDistanceKm());
                    y_axis.add(current_data.getSpeedKmhAvg());
                }
                for (int i = 0; i < x_axis_double.size(); i++) {
                    myPair new_pair;
                    new_pair = new myPair(x_axis_double.get(i), y_axis.get(i));
                    unsorted_list.add(new_pair);
                    Log.d("Test3", "Value" + unsorted_list.get(i).getX());
                }
                Comparator<myPair> comparator = new Comparator<myPair>() {
                    @Override
                    public int compare(myPair myPair, myPair t1) {
                        return myPair.getX().compareTo(t1.getX());
                    }
                };
                Collections.sort(unsorted_list, comparator);
                for (int i = 0; i < x_axis_double.size(); i++) {
                    Log.d("Test4.1", "Value" + unsorted_list.get(i).getX());
                    Log.d("Test4.2", "Value" + unsorted_list.get(i).getY());
                }
                new_graph.set_series_myPair(unsorted_list);
                displaying_graph();

                break;
        }

    }

    private void displaying_graph() {
        new Thread() {

            public void run() {
                //new_graph.set_series();
                //new_graph.setGraph();

                try {
                    if (isPair) {
                        new_graph.setGraphPair();
                        isPair = false;
                    } else if (isGraph1) {
                        new_graph.set_series();
                        new_graph.setGraph1();
                        isGraph1 = false;
                    }
                    else if (isGraph2){
                        new_graph.set_series();
                        new_graph.setGraph2();
                        isGraph2 = false;
                    }

                } catch (final Exception ex) {
                    Log.i("---", "Exception in thread");
                }

            }

        }.start();
    }

}

