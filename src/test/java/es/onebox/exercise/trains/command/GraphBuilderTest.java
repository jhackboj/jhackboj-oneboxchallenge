package es.onebox.exercise.trains.command;

import es.onebox.exercise.trains.facade.RouteInformation;
import es.onebox.exercise.trains.facade.RouteService;
import es.onebox.exercise.trains.file.InputModel;
import es.onebox.exercise.trains.models.Edge;
import es.onebox.exercise.trains.models.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphBuilderTest
{

    @Mock
    private RouteService routeInformation;
    private InputModel inputModel;
    private ManageCommands manageCommands;


    @Before
    public void setUp()
    {
        inputModel = new InputModel("AB5,BC2", new ArrayList<String>()
        {{
            add("A-B-C");
        }});
        manageCommands = GraphBuilder.newInstanceBy(inputModel);
        routeInformation = new RouteInformation();

    }

    @Test
    public void Should_AddGraph_When_ReadInput(){

        manageCommands.make(routeInformation);
        Graph inputGraph = routeInformation.getInputGraph();
        Map<String, List<Edge>> routeGraph = inputGraph.getRouteGraph();
        Assert.assertTrue(routeGraph.containsKey("A"));
        Assert.assertTrue(routeGraph.containsKey("B"));
        Assert.assertTrue(routeGraph.containsKey("C"));

    }


}
