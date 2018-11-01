package DomainClasses;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fall2018comp354groupq.fitnessanalyzer.R;

public class Graphing {

    public Activity activity; // Calling from Main Activity Class //
    //ArrayList<String> x_axis=new ArrayList<String>();

    ArrayList<Date> current_date_values = new ArrayList<Date>(); //
    ArrayList<Date> x_axis = new ArrayList<Date>();
    ArrayList<Integer> y_axis=new ArrayList<Integer>();
    ArrayList<Double> y_axis_double=new ArrayList<Double>();
    GraphView graph; // To display graph //
    LineGraphSeries<DataPoint> series; // Actual Data Series to plot //
    DataPoint[] values; // To set the data points //

    String main_title;
    String x_title;
    String y_title;

    boolean isYDouble = false;
    boolean isYInteger = false;

    // Default Constructor //
    public Graphing(Activity _activity){
        this.activity = _activity;
    }

    // USER chooses which graph to display //
    public void select_graph(int choice){
        // All graph one but different labels for x and y axis to set//
        graph = (GraphView)this.activity.findViewById(R.id.graph1);
        switch(choice){

            case 1:
                main_title = "Graph 1";
                x_title = "Start Time"; // String
                y_title = "Duration"; // Integer
                isYInteger = true;
                break;

            case 2:
                main_title = "Graph 2";
                x_title = "Start Time"; // String
                y_title = "Average Speed"; //Double
                isYDouble = true;
                break;

            case 3:
                main_title = "Graph 3";
                x_title = "Distance"; // Double
                y_title = "Average Speed"; // Double
                break;
        }

    }

    // List of Strings with date format //
    public void str_format_date(List<String> string_dates){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Date new_date = null;
        for(int i = 0; i < string_dates.size(); i++)
        {
            try{
                new_date = sdf.parse(string_dates.get(i));
                current_date_values.add(new_date);
                //x_axis.add(new_date);
            }
            catch (ParseException e) {
                Log.e("ERROR", "Here");
                e.printStackTrace();
            }
        }
       setX_axis(current_date_values);
    }


    // Need to be ascending order or it will crash //
    public void setX_axis(List<Date> x_data_list){
        for(int i = 0; i < x_data_list.size(); i++) {
            Date temp = (Date)x_data_list.get(i);
            x_axis.add(temp);
        }
    }

    public void setY_axis_Integer(List<Integer> y_data_list){
        for(int i = 0; i < y_data_list.size(); i++){
            //y_axis.add(String.valueOf(y_data_list.get(i)));
            y_axis.add(y_data_list.get(i));
        }

    }

    public void setY_axis_Double(List<Double> y_data_list){
        for(int i = 0; i < y_data_list.size(); i++){
            //y_axis.add(String.valueOf(y_data_list.get(i)));
            y_axis_double.add(y_data_list.get(i));
        }

    }


    public void set_series(){
        int n = x_axis.size();

        values = new DataPoint[n];
        for(int i=0;i<n;i++){
            //DataPoint v = new DataPoint(Double.parseDouble(x_axis.get(i)),Double.parseDouble(y_axis.get(i)));
            DataPoint v;
            if (isYDouble == true)
            {
                v = new DataPoint((x_axis.get(i)),(y_axis_double.get(i)));
            }
            // Integer version //
            else{
                v = new DataPoint((x_axis.get(i)),(y_axis.get(i)));
            }
            values[i] = v;
        }

        //DataPoint[] test_val = new DataPoint[1];
        //test_val[0] = new DataPoint((x_axis.get(0)),(y_axis_double.get(0)));


        // Completed setting the values for series //
        //Log.d("test", "Here" + n);
        //Log.d("test2", "Value" + values);
        //series = new LineGraphSeries<DataPoint>(test_val);
        series = new LineGraphSeries<DataPoint>(values);
        setGraph(graph);

    }

    public LineGraphSeries<DataPoint> getSeries() {
        return series;
    }

    public void setGraph(GraphView graph) {
        graph.addSeries(series);

        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(activity.getApplicationContext()));
        //graph.getViewport().setMinX(x_axis.get(0).getTime());
        //graph.getViewport().setMaxX(x_axis.get(2).getTime());
        //graph.getGridLabelRenderer().setNumHorizontalLabels(5);

        setTitle(main_title, x_title, y_title);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(20);


        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(x_axis.get(0).getTime());
        graph.getViewport().setMaxX(x_axis.get(4).getTime());
        graph.getGridLabelRenderer().setHumanRounding(false);
       // graph.getViewport().setMinX(0);
        //graph.getViewport().setMaxX(20);

        //graph.getViewport().setScalable(true);
        //graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true); //No zoom, just scroll - X's axis//
        graph.getViewport().setScrollableY(true); //No zoom, just scroll - Y's axis//
    }

    public void setTitle(String main_title, String x_title, String y_title ){
        graph.setTitle(main_title);
        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle(x_title);
        gridLabel.setVerticalAxisTitle(y_title);
    }



}
