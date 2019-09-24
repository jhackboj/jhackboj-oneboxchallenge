package es.onebox.exercise.trains.command;

import es.onebox.exercise.trains.facade.RouteService;
import es.onebox.exercise.trains.file.InputModel;
import es.onebox.exercise.trains.models.Graph;

public class GraphBuilder implements ExecutorBuilders
{

    private final InputModel input;

    private GraphBuilder(final InputModel input) {
        this.input = input;
    }

    public static GraphBuilder newInstanceBy(final InputModel input) {
        return new GraphBuilder(input);
    }

    @Override
    public void make(RouteService routeService)
    {
        Graph routes = routeService.getInputGraph();

        // Removes all whitespaces and non-visible characters
        String[] graph = input.getRoutes().replaceAll("\\s+", "").split(",");

        for (String route : graph) {
            String from = route.substring(0, 1);
            String dest = route.substring(1, 2);
            int distance = Integer.valueOf(route.substring(2,3));
            routes.addNode(from);
            routes.addNode(dest);
            routes.addEdge(from, dest, distance);
        }
    }

}
