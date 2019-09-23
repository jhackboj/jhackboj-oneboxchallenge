package es.onebox.exercise.trains.models;

import es.onebox.exercise.trains.exceptions.NoSuchEdgeException;

import java.util.*;

public class Graph
{
    private Map<String, List<Edge>> routeGraph = new HashMap<>();

    private Graph(){}

    public static Graph emptyGraph() {
        return new Graph();
    }

    public void addNode(final String sourceNode) {
        asserNullArgument(sourceNode);
        if (!routeGraph.containsKey(sourceNode))
            routeGraph.put(sourceNode, new ArrayList<>());
    }

    public void addEdge(final String source, final String destination, final int weight) {
        assertNodeExist(source);
        assertNodeExist(destination);

        final Edge path = Edge.newInstanceBy(source, destination, weight);
        final List<Edge> pathsInRouteGraph = routeGraph.get(source);

        if (pathsInRouteGraph.contains(path)) {
            pathsInRouteGraph.remove(path);
            pathsInRouteGraph.add(path);
        } else {
            pathsInRouteGraph.add(path);
        }
    }

    public Edge searchEdge(final String src, final String dst) {
        final List<Edge> edgesSource = routeGraph.get(src);
        Optional<Edge> optionalEdgeDst = edgesSource.stream().filter(edge -> edge.getDestination().equals(dst)).findFirst();

        if (!optionalEdgeDst.isPresent())
            throw new NoSuchEdgeException("NO SUCH ROUTE");

        return optionalEdgeDst.get();
    }

    private void assertNodeExist(final String node) {
        asserNullArgument(node);
        if (!routeGraph.containsKey(node))
            throw new RuntimeException("Node " + node + " not found in the graph");
    }

    private <K> void asserNullArgument(final K argument) {
        if (argument == null)
            throw new NullPointerException("argument is null");
    }

    public Map<String, List<Edge>> getRouteGraph()
    {
        return routeGraph;
    }
}
