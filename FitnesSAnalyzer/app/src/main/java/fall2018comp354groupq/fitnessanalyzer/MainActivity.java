package fall2018comp354groupq.fitnessanalyzer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import DomainClasses.Graphing;
import DomainClasses.WorkOut;
import DomainClasses.WorkOutSet;
import DomainClasses.myPair;


public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new GraphingTask().execute("Starting Graphing Task");
        new_graph = new Graphing(this);

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

        /*
        new_graph.select_graph(1);

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
        time_list.clear();
        */

        /* ==========================================================
            TO SET: Using Workout Data --> Get X values & Y Values
            - Extract from WorkOutSet the List<WorkOut>
            - Get the necessary parameters.
            >> UNCOMMENT OUT THESE LINES BELOW <<
           ==========================================================
         */

        /*
        WorkOutSet current_set = new WorkOutSet();
        List<WorkOut> data = current_set.getworkOutList(); // GET list<Workout>

        for(int i = 0; i < data.size(); i++)
        {
            WorkOut current_data = data.get(i);
            time_list.add(current_data.getStartTime());
            y_axis_int.add(current_data.getDurationSec());
        }

        new_graph.str_format_date(time_list);
        new_graph.setY_axis_Integer(y_axis_int);
        displaying_graph();
        time_list.clear();
        */


        // TESTING SCENARIO: GRAPH #2 //
        // CREATE A GRAPH via Constructor + Set Labels //

        /*
        new_graph.select_graph(2);
        //new_graph =  create_Graph(new_graph);

        // SETTING X-AXIS: String List via str_format_date() //
        time_list.add(time1);
        time_list.add(time2);
        time_list.add(time3);
        time_list.add(time4);
        time_list.add(time5);
        new_graph.str_format_date(time_list);

        // SETTING Y-AXIS: Double List //
        y_axis.add(30.4);
        y_axis.add(34.3);
        y_axis.add(44.3);
        y_axis.add(14.3);
        y_axis.add(54.3);
        new_graph.setY_axis_Double(y_axis);

        // DISPLAY GRAPH via set_series() //
        displaying_graph();
        time_list.clear();
        */

         /* ==========================================================
            TO SET: Using Workout Data --> Get X values & Y Values
            - Extract from WorkOutSet the List<WorkOut>
            - Get the necessary parameters.
            >> UNCOMMENT OUT THESE LINES BELOW <<
           ==========================================================
         */

        /*
        WorkOutSet current_set = new WorkOutSet();
        List<WorkOut> data = current_set.getworkOutList(); // GET list<Workout>

        for(int i = 0; i < data.size(); i++)
        {
            WorkOut current_data = data.get(i);
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
            new_graph.setGraph();
        }


    }


    public void select_button(View v) {

        switch (v.getId()) {

            case R.id.graph1_radio:
                time_list.clear();
                y_axis_int.clear();
                new_graph.select_graph(1);
                time_list.add(time1);
                time_list.add(time2);
                time_list.add(time3);
                time_list.add(time4);
                time_list.add(time5);
                new_graph.str_format_date(time_list);
                y_axis_int.add(30);
                y_axis_int.add(20);
                y_axis_int.add(40);
                y_axis_int.add(10);
                y_axis_int.add(50);
                new_graph.setY_axis_Integer(y_axis_int);

                Log.d("test1", "Value" + time_list.get(0));
                Log.d("test2", "Value" + y_axis_int.get(0));
                //new GraphingTask().execute("Currently graphing..");
                //new_graph.set_series();
                //new_graph.setGraph();
                displaying_graph();
                time_list.clear();
                break;

            case R.id.graph2_radio:
                time_list.clear();
                y_axis.clear();
                new_graph.select_graph(2);
                time_list.add(time1);
                time_list.add(time2);
                time_list.add(time3);
                time_list.add(time4);
                time_list.add(time5);
                new_graph.str_format_date(time_list);
                y_axis.add(30.4);
                y_axis.add(34.3);
                y_axis.add(44.3);
                y_axis.add(14.3);
                y_axis.add(54.3);
                new_graph.setY_axis_Double(y_axis);
                Log.d("test1", "Value" + time_list.get(0));
                Log.d("test2", "Value" + y_axis.get(0));
                //new GraphingTask().execute("Currently graphing..");
                displaying_graph();
                //new_graph.set_series();
                //new_graph.setGraph();
                time_list.clear();
                break;

            case R.id.graph3_radio:
                x_axis_double.clear();
                y_axis.clear();
                isPair = true;
                new_graph.select_graph(3);
                x_axis_double.add(10.4337);
                x_axis_double.add(2.4567);
                x_axis_double.add(1.3543);
                x_axis_double.add(11.5314);
                x_axis_double.add(12.1135);

                y_axis.add(8.1456);
                y_axis.add(3.1541);
                y_axis.add(1.5731);
                y_axis.add(4.5413);
                y_axis.add(6.7540);

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
                    } else {
                        new_graph.set_series();
                        new_graph.setGraph();
                    }

                } catch (final Exception ex) {
                    Log.i("---", "Exception in thread");
                }

            }

        }.start();
    }

}
