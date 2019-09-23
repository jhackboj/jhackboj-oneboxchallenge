package es.onebox.exercise.trains.file;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.PrintStream;

public class XMLInputProvider implements InputProviderService
{

    private final PrintStream outputPrint;
    private InputModel input;

    public XMLInputProvider(final PrintStream outputPrint)
    {
        this.outputPrint = outputPrint;
    }

    @Override
    public InputModel read(File fileXml) throws Exception
    {
        if (input != null)
            return input;
        JAXBContext jaxbContext = JAXBContext.newInstance(InputModel.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        input = (InputModel) jaxbUnmarshaller.unmarshal(fileXml);
        return input;
    }

}
