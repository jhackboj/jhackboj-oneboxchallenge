package es.onebox.exercise.trains.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteTest
{

    @Test
    public void Should_CreateANewRoute_When_InputRouteIsCorrect()
    {
        final String input = "A-B-C-D-E-F-G";
        final Route route = Route.createRouteBy(input);

        final List<String> routeTests = new ArrayList<String>()
        {{
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
        }};

        Assert.assertEquals(route.getSource(), "A");
        Assert.assertEquals(route.getDestination(), "G");
        Assert.assertEquals(route.getIntermediates(), routeTests);
    }

    @Test
    public void Get_Weight_When_WeightGiven()
    {
        final String input = "A-B";
        final Route route = Route.createRouteBy(input);
        route.setWeightRoute(3);
        Assert.assertEquals(route.getWeightRoute(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Should_Thrown_When_InputRouteIsNotCorrect()
    {
        final String input = "A-B-C-D--E";
        final Route route = Route.createRouteBy(input);
    }
}
