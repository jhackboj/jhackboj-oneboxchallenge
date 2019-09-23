package es.onebox.exercise.trains;

import es.onebox.exercise.trains.command.DistanceBuilder;
import es.onebox.exercise.trains.command.GraphBuilder;
import es.onebox.exercise.trains.facade.RouteInformation;
import es.onebox.exercise.trains.file.InputModel;
import es.onebox.exercise.trains.file.XMLInputProvider;
import java.io.File;
import java.io.PrintStream;

public class RailRoadService
{
    private final PrintStream outputPrint = System.out;
    private static final String FILE_INPUT = "/input.xml";

    private void run() throws Exception {
        final RouteInformation routesInformation = new RouteInformation();
        final InputModel inputModel = new XMLInputProvider(outputPrint).read(
                new File(RailRoadService.class.getResource(FILE_INPUT).toURI()));

        GraphBuilder.newInstanceBy(inputModel).make(routesInformation);
        DistanceBuilder.newInstaceBy(inputModel, outputPrint).make(routesInformation);
    }

    public static void main(String[] args) throws Exception
    {
        if (args.length > 1)
            throw new IllegalArgumentException("Arguments size can't be greater than one");
        new RailRoadService().run();
    }



}
