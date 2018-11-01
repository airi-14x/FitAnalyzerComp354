package fall2018comp354groupq.fitnessanalyzer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DomainClasses.Graphing;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Integer> y_axis_int = new ArrayList<Integer>();
    static ArrayList<Double> y_axis = new ArrayList<Double>();

    static ArrayList<Date> x_axis = new ArrayList<Date>();
    List<Date> x_data_list = x_axis;

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

        // TESTING SCENARIO: GRAPH #1 //
        // CREATE A GRAPH via Constructor + Set Labels //
        new_graph = new Graphing(this);
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
        new_graph.set_series();


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
        */


        // TESTING SCENARIO: GRAPH #3 //
        // CREATE A GRAPH via Constructor + Set Labels //
        //new_graph = new Graphing(this);
        //new_graph.select_graph(3);

    }

    public void select_button(View v) {

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        new_graph = create_Graph(new_graph);
        switch (v.getId()) {

            case R.id.graph1_radio:
                new_graph.select_graph(1);
                //new_graph.setX_axis(x_axis);
                //new_graph.setY_axis_Double(y_axis);
                //new_graph.set_series();
                break;

            case R.id.graph2_radio:
                new_graph.select_graph(2);
                //Log.d("test2", "Value" + y_axis.get(0));
                //Log.d("test2", "Value" + y_axis.get(1));
                new_graph.setX_axis(x_axis);
                new_graph.setY_axis_Double(y_axis);
                new_graph.set_series();
                break;

            case R.id.graph3_radio:
                break;

        }


    }

    public Graphing create_Graph(Graphing new_graph) {
        new_graph = new Graphing(this);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Date dt1 = null;
        Date dt2 = null;
        Date dt3 = null;
        Date dt4 = null;
        Date dt5 = null;
        try {
            dt1 = sdf.parse(time1);
            dt2 = sdf.parse(time2);
            dt3 = sdf.parse(time3);
            dt4 = sdf.parse(time4);
            dt5 = sdf.parse(time5);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        x_axis.add(dt1);
        //y_axis.add(30);
        y_axis.add(30.4);

        x_axis.add(dt2);
        //y_axis.add(20);
        y_axis.add(34.3);

        x_axis.add(dt3);
        //y_axis.add(40);
        y_axis.add(44.3);

        x_axis.add(dt4);
        //y_axis.add(10);
        y_axis.add(14.3);

        x_axis.add(dt5);
        //y_axis.add(50);
        y_axis.add(54.3);

        return new_graph;
    }


}
