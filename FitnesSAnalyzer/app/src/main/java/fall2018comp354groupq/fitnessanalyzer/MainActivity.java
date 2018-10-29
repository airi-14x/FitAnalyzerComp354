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
import java.util.List;

import DomainClasses.Graphing;

public class MainActivity extends AppCompatActivity {

    //ArrayList<String> x_axis=new ArrayList<String>();
    //ArrayList<String> y_axis=new ArrayList<String>();


    //ArrayList<Integer> y_axis=new ArrayList<Integer>();
    ArrayList<Double> y_axis=new ArrayList<Double>();

    ArrayList<Date> x_axis = new ArrayList<Date>();
    List<Date> x_data_list = x_axis;
    //List<String> y_data_list;

    ArrayList<Date> x_axis_new = new ArrayList<Date>();
    LineGraphSeries<DataPoint> series;

    String time1 = "2018-10-03T09:35:00.000Z";
    String time2 = "2018-10-03T23:00:00.000Z";
    String time3 = "2018-10-04T14:35:00.000Z";
    String time4 = "2018-10-05T17:35:00.000Z";
    String time5 = "2018-10-06T19:35:00.000Z";


    DataPoint[] values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
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

        x_axis.add(dt1);
        y_axis.add(40);
        x_axis.add(dt2);
        y_axis.add(20);
        x_axis.add(dt3);
        y_axis.add(40);

        for(int i = 0; i < x_data_list.size(); i++)
        {
            Date temp = (Date)x_data_list.get(i);
            x_axis_new.add(temp);
        }

        */
        ///
        // Setting series //

        /*
        int n = x_axis.size();
        values = new DataPoint[n];

        for(int i=0;i<n;i++){
            //DataPoint v = new DataPoint(Double.parseDouble(x_axis.get(i)),Double.parseDouble(y_axis.get(i)));
            DataPoint v = new DataPoint((x_axis_new.get(i)),y_axis.get(i));
            values[i] = v;
        }

        series = new LineGraphSeries<DataPoint>(values);

        GraphView graph = (GraphView) findViewById(R.id.graph1);

        // you can directly pass Date objects to DataPoint-Constructor
        // this will convert the Date to double via Date#getTime()
       /* LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(dt1, 1),
                new DataPoint(dt2, 5),
                new DataPoint(dt3, 3)
        });*/

        /*
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



        Graphing new_graph = new Graphing(this);


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

        new_graph.select_graph(2);
        new_graph.setX_axis(x_axis);
        new_graph.setY_axis_Double(y_axis);
        new_graph.set_series();


    }



}
