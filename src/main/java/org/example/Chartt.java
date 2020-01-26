package org.example;


import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;
import org.example.entity.Curs;
import org.example.repository.InitSpring;

import java.util.List;

public class Chartt extends Composite implements View {
    InitSpring initSpring;
    public Chartt() {
initSpring.getInstance();
    Chart chart = new Chart(ChartType.COLUMN);
    Configuration conf = chart.getConfiguration();
conf.setTitle("Curs");
        XAxis x =new XAxis();
        x.setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec");
        YAxis y= new YAxis();
        y.setMin(0);
        y.setTitle("Rainfall (mm)");
        conf.addyAxis(y);

        conf.addxAxis(x);


        conf.addSeries(new ListSeries("Tokyo", 49.9, 71.5, 106.4, 129.2, 144.0,
                176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4));
        conf.addSeries(new ListSeries("New York", 83.6, 78.8, 98.5, 93.4,
                106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3));
        conf.addSeries(new ListSeries("London", 48.9, 38.8, 39.3, 41.4, 47.0,
                48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2));
        conf.addSeries(new ListSeries("Berlin", 42.4, 33.2, 34.5, 39.7, 52.6,
                75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1));
        chart.drawChart(conf);
        HorizontalLayout layout = new HorizontalLayout();
        layout.addComponent(chart);
        setCompositionRoot(layout);
}
}
