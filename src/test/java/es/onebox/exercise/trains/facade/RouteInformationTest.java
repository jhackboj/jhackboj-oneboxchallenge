package es.onebox.exercise.trains.facade;

import es.onebox.exercise.trains.exceptions.NoSuchEdgeException;
import es.onebox.exercise.trains.models.Graph;
import es.onebox.exercise.trains.models.Route;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouteInformationTest
{

    private Route route;
    private Graph graph;
    private RouteInformation routeInformation;

    @Before
    public void setUp() {
        graph = Graph.emptyGraph();
        routeInformation = new RouteInformation();
        graph = routeInformation.getInputGraph();
    }

    @Test
    public void Should_DistanceBe8_When_RouteAB(){
        route = Route.createRouteBy("A-B");
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A","B",9);
        Assert.assertEquals(9, routeInformation.routeDistance(route));
    }

    @Test
    public void Should_DistanceBe13_WhenRouteABC() {
        route = Route.createRouteBy("A-B-C");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A","B",9);
        graph.addEdge("B","C",4);
        Assert.assertEquals(13, routeInformation.routeDistance(route));
    }

    @Test(expected = NoSuchEdgeException.class)
    public void Should_Throw_When_RouteNotExist() {
        route = Route.createRouteBy("A-B-D");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A","B",9);
        graph.addEdge("B","C",4);
        routeInformation.routeDistance(route);
    }


}
