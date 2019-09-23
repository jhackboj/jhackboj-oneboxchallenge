package es.onebox.exercise.trains.facade;

import es.onebox.exercise.trains.models.Graph;
import es.onebox.exercise.trains.models.Route;

/**
 * Route service for the trains problem.
 *
 * @author "Jose Luis Sanchez Boj <joselsb3@gmail.com>"
 *
 */
public interface RouteService
{

    /**
     * Given a route between two cities and its intermediates, calculate the total distance.
     *
     * @param route
     *          Route given {@link Route}
     *
     * @return The total distance of the route.
     */
    int routeDistance(final Route route);


    /**
     * Return a {@link Graph} with all edges and nodes.
     *
     *
     * @return a graph representing all routes.
     */
    Graph getInputGraph();

}
