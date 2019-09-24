package es.onebox.exercise.trains.command;

import es.onebox.exercise.trains.facade.RouteService;

/**
 * Providers a commands executions to process input
 * and build RouteService {@link RouteService}
 *
 * @author "Jose Luis Sanchez Boj <joselsb3@gmail.com>"
 *
 */
public interface ExecutorBuilders
{
    void make(RouteService routeService);
}
