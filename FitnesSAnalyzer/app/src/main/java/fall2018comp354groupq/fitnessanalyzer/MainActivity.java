package fall2018comp354groupq.fitnessanalyzer;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DomainClasses.Graphing;

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


    static Graphing new_graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new_graph = new Graphing(this);

        //new GraphingTask().execute("Starting Graphing Task");


        // TESTING SCENARIO: GRAPH #1 //
        // CREATE A GRAPH via Constructor + Set Labels //
        //new_graph = new Graphing(this);
        //new_graph.select_graph(1);

        // SETTING X-AXIS: String List via str_format_date() //
        //time_list.add(time1);
        //time_list.add(time2);
        //time_list.add(time3);
        //time_list.add(time4);
        //time_list.add(time5);
        //new_graph.str_format_date(time_list);

        // SETTING Y-AXIS: Integer List //
        //y_axis_int.add(30);
        //y_axis_int.add(20);
        //y_axis_int.add(40);
        //y_axis_int.add(10);
        //y_axis_int.add(50);
        //new_graph.setY_axis_Integer(y_axis_int);


        // SET OTHER Y-AXIS //
        //y_axis.add(30.4);
        //y_axis.add(34.3);
        //y_axis.add(44.3);
        //y_axis.add(14.3);
        //y_axis.add(54.3);

        // DISPLAY GRAPH via set_series() //
        //new_graph.set_series();
        //new_graph.setGraph();


        /*
        // TESTING SCENARIO: GRAPH #2 //

        // CREATE A GRAPH via Constructor + Set Labels //
        new_graph = new Graphing(this);
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

        //new_graph.setX_axis(x_axis);
        //new_graph.setY_axis_Double(y_axis);

        // DISPLAY GRAPH via set_series() //
        new_graph.set_series();
        new_graph.setGraph();
        */


        // TESTING SCENARIO: GRAPH #3 //
        // CREATE A GRAPH via Constructor + Set Labels //
        //new_graph = new Graphing(this);
        //new_graph.select_graph(3);

    }

    private class GraphingTask extends AsyncTask<String,Graphing,String>{

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

        protected void onPostExecute(String display_graph)
        {
            //new_graph.set_series();
            new_graph.setGraph();
        }



    }


    public void select_button(View v) {

        switch (v.getId()) {

            case R.id.graph1_radio:
                time_list.clear();
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
                break;

        }

    }

    private void displaying_graph(){
        new Thread(){

            public void run(){
                //new_graph.set_series();
                //new_graph.setGraph();

                try {
                    new_graph.set_series();
                    new_graph.setGraph();
                    // code runs in a thread
                    /*runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            new_graph.set_series();
                            new_graph.setGraph();
                        }
                    });*/
                } catch (final Exception ex) {
                    Log.i("---","Exception in thread");
                }

            }

        }.start();
    }

}
