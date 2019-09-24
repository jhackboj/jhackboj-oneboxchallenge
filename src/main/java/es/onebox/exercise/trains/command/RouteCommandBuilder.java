package es.onebox.exercise.trains.command;

import es.onebox.exercise.trains.facade.RouteService;

import java.util.ArrayList;
import java.util.List;

public class RouteCommandBuilder implements ManageCommands
{

    private final List<ExecutorBuilders> executors = new ArrayList<>();
    private final RouteService routeService;

    public RouteCommandBuilder(final RouteService routeService){
        this.routeService = routeService;
    }

    @Override
    public void addCommand(ExecutorBuilders executorCommand)
    {
        executors.add(executorCommand);
    }

    @Override
    public void runCommands()
    {
        executors.forEach(executorBuilders -> executorBuilders.make(routeService));
    }
}
