package es.onebox.exercise.trains.file;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "onebox")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputModel
{

    @XmlElement(name = "routes")
    private String routes;

    @XmlElement(name = "distance")
    private List<String> trip;

    public InputModel(){}

    public InputModel(final String routes,
                      final List<String> trip) {
        this.routes = routes;
        this.trip = trip;
    }


    public String getRoutes()
    {
        return routes;
    }

    public List<String> getTrip()
    {
        return trip;
    }

    @Override
    public String toString()
    {
        return "InputModel{" +
                "routes = '" + routes + '\'' +
                ", trip = " + trip +
                '}';
    }
}
