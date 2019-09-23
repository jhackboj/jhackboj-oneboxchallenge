package es.onebox.exercise.trains.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route
{
    private static final String CHAR_INPUT_ROUTE = "-";
    private static final String REG_INPUT_ROUTE = "\\D-\\D(-\\D)*";
    private static final int SOURCE_INDEX = 0;

    private final String source;
    private final String destination;
    private final List<String> intermediates;
    private int weightRoute = 0;

    private Route(final String source,
                  final String destination,
                  final List<String> intermediates) {
        this.source = source;
        this.destination = destination;
        this.intermediates = intermediates;
    }

    public static Route createRouteBy(final String inputRoute) {
        Route.assertCheckInputRoute(inputRoute);
        final String[] inputRouteSplit = inputRoute.split(CHAR_INPUT_ROUTE);

        final String source = inputRouteSplit[SOURCE_INDEX];
        final String destination = inputRouteSplit[inputRouteSplit.length - 1];

        final List<String> intermediatesInput = new ArrayList<>(
                Arrays.asList(inputRouteSplit).subList(1, inputRouteSplit.length - 1));

        return new Route(source, destination, intermediatesInput);
    }

    private static void assertCheckInputRoute(final String inputRoute) {
        boolean matches = inputRoute.matches(REG_INPUT_ROUTE);
        if (!matches)
            throw new IllegalArgumentException("Input distances is not valid");
    }

    public String getSource()
    {
        return source;
    }

    public String getDestination()
    {
        return destination;
    }

    public List<String> getIntermediates()
    {
        return intermediates;
    }

    public void setWeightRoute(int weightRoute)
    {
        this.weightRoute = weightRoute;
    }

    public int getWeightRoute()
    {
        return weightRoute;
    }
}
