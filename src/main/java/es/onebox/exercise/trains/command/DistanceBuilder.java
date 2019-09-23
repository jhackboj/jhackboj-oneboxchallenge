package es.onebox.exercise.trains.command;

import es.onebox.exercise.trains.exceptions.NoSuchEdgeException;
import es.onebox.exercise.trains.facade.RouteService;
import es.onebox.exercise.trains.file.InputModel;
import es.onebox.exercise.trains.models.Route;
import java.io.PrintStream;
import java.util.List;

public class DistanceBuilder implements ManageCommands
{

    private final InputModel input;
    private final PrintStream outputPrint;

    private DistanceBuilder(final InputModel input, final PrintStream outputPrint) {
        this.input = input;
        this.outputPrint = outputPrint;
    }

    public static DistanceBuilder newInstaceBy(final InputModel input, final PrintStream outputPrint) {
        return new DistanceBuilder(input, outputPrint);
    }

    @Override
    public void make(RouteService routeService)
    {
        final List<String> inputTrips = input.getTrip();
        inputTrips.forEach(trip -> {
            try {
                final Route route = Route.createRouteBy(trip);
                outputPrint.println(String.format("OUTPUT %s: %s", trip, routeService.routeDistance(
                        route)));
            } catch (final NoSuchEdgeException ex)
            {
                outputPrint.println(String.format("OUTPUT %s: %s", trip, ex.getMessage()));
            }
        });
    }

}
