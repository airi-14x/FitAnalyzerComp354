package DomainClasses;

import android.app.Activity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fall2018comp354groupq.fitnessanalyzer.R;

public class Graphing {

    public Activity activity; // Calling from Main Activity Class //
    //ArrayList<String> x_axis=new ArrayList<String>();
    ArrayList<Date> x_axis = new ArrayList<Date>();
    ArrayList<String> y_axis=new ArrayList<String>();
    GraphView graph; // To display graph //
    LineGraphSeries<DataPoint> series; // Actual Data Series to plot //
    DataPoint[] values; // To set the data points //

    String main_title;
    String x_title;
    String y_title;

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
                x_title = "Start Time";
                y_title = "Duration";
                break;

            case 2:
                main_title = "Graph 2";
                x_title = "Start Time";
                y_title = "Average Speed";
                break;

            case 3:
                main_title = "Graph 3";
                x_title = "Distance";
                y_title = "Average Speed";
                break;
        }

    }


    // Need to be ascending order or it will crash //
    public void setX_axis(List x_data_list){
        for(int i = 0; i < x_data_list.size(); i++) {
            //x_axis.add(String.valueOf(x_data_list.get(i)));
            x_axis.add((Date)x_data_list.get(i));
        }
    }

    public void setY_axis(List y_data_list){
        for(int i = 0; i < y_data_list.size(); i++){
            y_axis.add(String.valueOf(y_data_list.get(i)));
        }

    }


    public void set_series(){
        int n = x_axis.size();

        values = new DataPoint[n];
        for(int i=0;i<n;i++){
            //DataPoint v = new DataPoint(Double.parseDouble(x_axis.get(i)),Double.parseDouble(y_axis.get(i)));
            DataPoint v = new DataPoint((x_axis.get(i)),Double.parseDouble(y_axis.get(i)));
            values[i] = v;
        }

        // Completed setting the values for series //
        series = new LineGraphSeries<>(values);
        setGraph(graph);
    }

    public LineGraphSeries<DataPoint> getSeries() {
        return series;
    }

    public void setGraph(GraphView graph) {
        graph.addSeries(series);

        setTitle(main_title, x_title, y_title);
        //graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(20);

        //graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(20);

        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        //graph.getViewport().setScrollable(true); //No zoom, just scroll - X's axis//
        //graph.getViewport().setScrollableY(true); //No zoom, just scroll - Y's axis//
    }

    public void setTitle(String main_title, String x_title, String y_title ){
        graph.setTitle(main_title);
        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle(x_title);
        gridLabel.setVerticalAxisTitle(y_title);
    }



}
