package ec.edu.juanultimate.conmutadortrenes.command;



import ec.edu.juanultimate.conmutadortrenes.Commuter;
import ec.edu.juanultimate.conmutadortrenes.dominio.trenes.Ciudad;

import java.io.PrintStream;
import java.util.List;


/**
 * Command implementation to process the distance input. A valid line example
 * for this command would be:<br/>
 * <b>Distance: A-D</b><br/>
 * where A and D are vertex names. Additional vertex might be added between A
 * and D but there should be at least two to define a path. Vertex are assumed
 * to be single letters. Note that this class is package private to prevent it
 * from being instantiated from outside. Instances of this class are only
 * created in {@link CommandBuilder}. This requires the client to refer to the
 * returned object by its interface rather than its implementation class, which
 * is generally good practice
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * @see GraphBuilderCommand
 * @see TripsCommand
 * @see ShortestDistanceCommand
 * 
 */
class DistanceCommand extends RouteCommand {
    public DistanceCommand(final String commandLine, final PrintStream stream) {
        super(commandLine, stream);
    }

    @Override
    protected int callCommuter(Commuter commuter, Ciudad start, Ciudad end, List<Ciudad> intermediate) {
        return commuter.routeDistance(start, end, intermediate);
    }

}
