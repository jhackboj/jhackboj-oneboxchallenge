package es.onebox.exercise.trains.file;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;

public class XMLInputProviderTest
{

    private XMLInputProvider xmlInputProvider;
    private File file;

    @Before
    public void init() throws URISyntaxException
    {
        xmlInputProvider = new XMLInputProvider(System.out);
        file = new File(getClass().getResource("/input.xml").toURI());
    }

    @Test
    public void Should_ReadTheXMLFile_When_ExecuteRead() throws Exception
    {
        final InputModel inputModel = xmlInputProvider.read(file);
        Assert.assertEquals(inputModel.getRoutes(), "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Should_Throw_When_FileNotExist() throws Exception
    {
        final InputModel inputModel = xmlInputProvider.read(null);
    }

}
