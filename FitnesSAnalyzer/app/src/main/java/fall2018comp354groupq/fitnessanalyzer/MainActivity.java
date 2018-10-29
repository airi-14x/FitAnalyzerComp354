package fall2018comp354groupq.fitnessanalyzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DomainClasses.Graphing;

public class MainActivity extends AppCompatActivity {

    //ArrayList<String> x_axis=new ArrayList<String>();
    //ArrayList<String> y_axis=new ArrayList<String>();

    //ArrayList<Integer> x_axis=new ArrayList<Integer>();
    ArrayList<Integer> y_axis=new ArrayList<Integer>();

    ArrayList<Date> x_axis = new ArrayList<Date>();

    String time1 = "2018-10-03T09:35:00.000Z";
    String time2 = "2018-10-03T23:00:00.000Z";
    String time3 = "2018-10-05T17:35:00.000Z";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // generate Dates
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();
        */

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Date dt1 = null;
        Date dt2 = null;
        Date dt3 = null;
        try {
            dt1 = sdf.parse(time1);
            dt2 = sdf.parse(time2);
            dt3 = sdf.parse(time3);

        } catch (ParseException e) {
            e.printStackTrace();
        }


       // x_axis.add(dt1);
        // y_axis.add(30);

        GraphView graph = (GraphView) findViewById(R.id.graph1);

        // you can directly pass Date objects to DataPoint-Constructor
        // this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(dt1, 1),
                new DataPoint(dt2, 5),
                new DataPoint(dt3, 3)
        });

        graph.addSeries(series);

    // set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
        graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

    // set manual x bounds to have nice steps
        //graph.getViewport().setMinX(d1.getTime());
        //graph.getViewport().setMaxX(d3.getTime());
        graph.getViewport().setXAxisBoundsManual(true);

    // as we use dates as labels, the human rounding to nice readable numbers
    // is not necessary
        graph.getGridLabelRenderer().setHumanRounding(false);
        graph.setTitle("Title1");

        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("X Axis Title");



        /*
        // Zooming in and out //
        // first series is a line
        DataPoint[] points = new DataPoint[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);


        GraphView graph = (GraphView) findViewById(R.id.graph1);
        // set manual X bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-150);
        graph.getViewport().setMaxY(150);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(4);
        graph.getViewport().setMaxX(80);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.addSeries(series);
        */


        //Graphing new_graph = new Graphing(this);

        /*
        // X must be ascending order  --> String//
        x_axis.add("10");
        y_axis.add("20");

        x_axis.add("22");
        y_axis.add("32");

        x_axis.add("22");
        y_axis.add("12");

        x_axis.add("33");
        y_axis.add("43");

        x_axis.add("42");
        y_axis.add("30");
        */

        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Date dt1 = null;
        Date dt2;
        Date dt3;
        try {
            dt1 = sdf.parse(time1);
            dt2 = sdf.parse(time2);
            dt3 = sdf.parse(time3);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        x_axis.add(dt1);
        y_axis.add(30);
        */

        /*
        // X must be ascending order  --> Integer --> Using Valueof//
        x_axis.add(10);
        y_axis.add(20);

        x_axis.add(22);
        y_axis.add(32);

        x_axis.add(22);
        y_axis.add(12);

        x_axis.add(33);
        y_axis.add(43);

        x_axis.add(42);
        y_axis.add(30);

        new_graph.select_graph(1);
        new_graph.setX_axis(x_axis);
        new_graph.setY_axis(y_axis);
        new_graph.set_series();
        */

    }



}
