package ec.edu.juanultimate.conmutadortrenes.command;



import ec.edu.juanultimate.conmutadortrenes.Commuter;
import ec.edu.juanultimate.conmutadortrenes.dominio.trenes.Ciudad;
import ec.edu.juanultimate.conmutadortrenes.expcetion.CaminoNoEncontradoException;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class RouteCommand extends AbstractCommand {

    protected static final String NO_ROUTE_MSG = "NO SUCH ROUTE";
    protected final PrintStream outputStream;

    public RouteCommand(String commandLine, PrintStream outputStream) {
        super(commandLine);
        this.outputStream = outputStream;
    }
    
    protected abstract int callCommuter(Commuter commuter,Ciudad start, Ciudad end, List<Ciudad> intermediate);

    @Override
    public void execute(final Commuter commuter) {
        final String routeLine = getCommandLine().substring(10);
        final String[] nodes = routeLine.split("-");
        final Ciudad[] cities = new Ciudad[nodes.length];
        for(int i=0;i<nodes.length;i++)
            cities[i]= new Ciudad(nodes[i]);
        try {
            outputStream.println(callCommuter(commuter,cities[0], cities[nodes.length - 1], getIntermediateList(cities)));
        } catch (final CaminoNoEncontradoException e) {
            outputStream.println(NO_ROUTE_MSG);
        }
    }

    private List<Ciudad> getIntermediateList(final Ciudad[] cities) {
        final List<Ciudad> intermediateList = new ArrayList<Ciudad>();
        for (int i = 1; i < cities.length - 1; i++) {
            intermediateList.add(cities[i]);
        }
        return intermediateList;
    }

}
