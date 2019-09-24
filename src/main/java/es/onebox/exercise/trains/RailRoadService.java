package es.onebox.exercise.trains;

import es.onebox.exercise.trains.command.DistanceBuilder;
import es.onebox.exercise.trains.command.GraphBuilder;
import es.onebox.exercise.trains.command.RouteCommandBuilder;
import es.onebox.exercise.trains.facade.RouteInformation;
import es.onebox.exercise.trains.facade.RouteService;
import es.onebox.exercise.trains.file.InputModel;
import es.onebox.exercise.trains.file.XMLInputProvider;
import java.io.File;
import java.io.PrintStream;

public class RailRoadService
{
    private final PrintStream outputPrint = System.out;
    private static final String FILE_INPUT = "/input.xml";
    private RouteService routeService;

    private void run() throws Exception {
        routeService = new RouteInformation();

        final InputModel inputModel = new XMLInputProvider(outputPrint).read(
                new File(RailRoadService.class.getResource(FILE_INPUT).toURI()));

        final RouteCommandBuilder routesCommandBuilder = new RouteCommandBuilder(routeService);
        routesCommandBuilder.addCommand(GraphBuilder.newInstanceBy(inputModel));
        routesCommandBuilder.addCommand(DistanceBuilder.newInstaceBy(inputModel, outputPrint));

        routesCommandBuilder.runCommands();
    }

    public static void main(String[] args) throws Exception
    {
        if (args.length > 1)
            throw new IllegalArgumentException("Arguments size can't be greater than one");
        new RailRoadService().run();
    }



}
