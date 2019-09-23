package es.onebox.exercise.trains.facade;

import es.onebox.exercise.trains.models.Edge;
import es.onebox.exercise.trains.models.Graph;
import es.onebox.exercise.trains.models.Route;
import java.util.List;

public class RouteInformation implements RouteService
{

    private final Graph graph = Graph.emptyGraph();

    @Override
    public int routeDistance(final Route route)
    {
        final List<String> intermediates = route.getIntermediates();
        final String from = route.getSource();
        final String destination = route.getDestination();
        if (intermediates.isEmpty())
        {
            final Edge edge = graph.searchEdge(from, destination);
            return edge.getWeight();
        } else {
            final Edge edgeStart = graph.searchEdge(from, route.getIntermediates().get(0));
            route.setWeightRoute(route.getWeightRoute() + edgeStart.getWeight());
            for (int i = 0; i < intermediates.size() && i + 1 < intermediates.size(); i++) {
                final Edge edge = graph.searchEdge(route.getIntermediates().get(i), route.getIntermediates().get(i + 1));
                route.setWeightRoute(route.getWeightRoute() + edge.getWeight());
            }
            final Edge edgeEnd = graph.searchEdge(intermediates.get(intermediates.size() - 1), destination);
            route.setWeightRoute(route.getWeightRoute() + edgeEnd.getWeight());
        }
        return route.getWeightRoute();
    }

    @Override
    public Graph getInputGraph()
    {
        return graph;
    }
}
