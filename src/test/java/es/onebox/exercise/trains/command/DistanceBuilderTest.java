package es.onebox.exercise.trains.command;

import es.onebox.exercise.trains.facade.RouteService;
import es.onebox.exercise.trains.file.InputModel;
import es.onebox.exercise.trains.models.Route;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class DistanceBuilderTest
{

    @Mock
    private PrintStream output;

    @Mock
    private RouteService routeInformation;

    @Mock
    private ManageCommands manageCommands;

    @Mock
    private Route route;

    @Before
    public void setUp() {
        manageCommands = DistanceBuilder.newInstaceBy(new InputModel("AB5,BC2", new ArrayList<String>(){{
            add("A-B-C");
        }}), output);
    }

    @Test
    public void Should_Print_Result_Correctly() {

        Mockito.when(routeInformation.routeDistance(Route.createRouteBy("A-B-C"))).thenReturn(0);
        manageCommands.make(routeInformation);
        Mockito.verify(output).println("OUTPUT A-B-C: 0");
    }

}
