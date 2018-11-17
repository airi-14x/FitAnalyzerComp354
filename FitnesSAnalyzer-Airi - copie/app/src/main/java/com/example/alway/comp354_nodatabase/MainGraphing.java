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

    static Graphing new_graph_1;
    static Graphing new_graph_2;

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
        new_graph_1 = new Graphing(this);
        new_graph_2 = new Graphing(this);

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


        new_graph_1.select_graph(1);
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

        new_graph_1.str_format_date(time_list);
        new_graph_1.setY_axis_Integer(y_axis_int);
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

         //to test graph2 uncomment this block
        new_graph_2.select_graph(2);
        isGraph2 = true;
        current_set = new WorkOutSet();
        //List<WorkOut> data = current_set.getworkOutList(); // GET list<Workout>

        for(int i = jsonData.size() - 1; i >= 0; i--)
        {
            WorkOut current_data = jsonData.get(i);
            time_list.add(current_data.getStartTime());
            y_axis.add(current_data.getDistanceKm());
        }

        new_graph_2.str_format_date(time_list);
        new_graph_2.setY_axis_Double(y_axis);
        displaying_graph();
        time_list.clear();



        /* GRAPH #3 Runs with the Button */

        // TESTING SCENARIO: GRAPH #3 //
        // CREATE A GRAPH via Constructor + Set Labels //
        //new_graph = new Graphing(this);
        //new_graph.select_graph(3);

    }



    private void displaying_graph() {
        new Thread() {

            public void run() {
                //new_graph.set_series();
                //new_graph.setGraph();

                try {
                    if (isGraph1) {
                        new_graph_1.set_series();
                        new_graph_1.setGraph1();
                        isGraph1 = false;
                    }
                    else if (isGraph2){
                        new_graph_2.set_series();
                        new_graph_2.setGraph2();
                        isGraph2 = false;
                    }

                } catch (final Exception ex) {
                    Log.i("---", "Exception in thread");
                }

            }

        }.start();
    }

}

