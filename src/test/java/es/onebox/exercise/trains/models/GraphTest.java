package es.onebox.exercise.trains.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;

public class GraphTest
{

    private Graph graph;

    @Before
    public void init() {
        graph = Graph.emptyGraph();
    }

    @Test
    public void Should_AddNode_When_NameGiven() {
        final String sourceNode = "A";
        graph.addNode(sourceNode);
        final Map<String, List<Edge>> routeGraph = graph.getRouteGraph();
        Assert.assertTrue(routeGraph.containsKey(sourceNode));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Should_Throw_When_AddNodeAlreadyExist() {
        final String sourceNode = "A";
        graph.addNode(sourceNode);
        graph.addNode(sourceNode);
    }

    @Test(expected = NullPointerException.class)
    public void Should_Thow_When_NodeIsNull() {
        graph.addNode(null);
    }

    @Test
    public void Should_AddEdge_When_SoruceDstAndWeightGiven() {
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B", 5);
        List<Edge> listEdgeNode = graph.getRouteGraph().get("A");
        Edge edge = Edge.newInstanceBy("A", "B", 5);
        Assert.assertTrue(listEdgeNode.contains(edge));
    }

    @Test(expected = RuntimeException.class)
    public void Should_Throw_When_NodeNotExist() {
        graph.addEdge("A", "B", 5);
    }


}
