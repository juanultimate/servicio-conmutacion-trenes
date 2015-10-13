package ec.edu.juanultimate.conmutadortrenes.command;


import ec.edu.juanultimate.conmutadortrenes.Commuter;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.DefaultAristaDirigida;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.GrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.dominio.trenes.Ciudad;

/**
 * Command implementation to build an input graph. A valid line example for this
 * command would be:<br/>
 * <b>Graph: AB5, BC4, CD8, DC8</b><br/>
 * where AB5 represents and edge between vertex A and B with a cost of 5. There
 * is no upper limit on the amount of edges that can be specified on the line
 * but at least 1 is required. Vertex are assumed to be single letters. Note
 * that this class is package private to prevent it from being instantiated from
 * outside. Instances of this class are only created in {@link CommandBuilder}.
 * This requires the client to refer to the returned object by its interface
 * rather than its implementation class, which is generally good practice
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * @see DistanceCommand
 * @see TripsCommand
 * @see ShortestDistanceCommand
 * 
 */
class GraphBuilderCommand extends AbstractCommand {

    public GraphBuilderCommand(final String commandLine) {
        super(commandLine);
    }

    @Override
    public void execute(final Commuter commuter) {
        final String nodesLine = getCommandLine().substring(7);
        final String[] nodes = nodesLine.split(",");
        for (final String vertexEdgePair : nodes) {
            addNodes(commuter.getAllRoutes(), vertexEdgePair);
        }

    }

    private void addNodes(final GrafoDirigido<Ciudad, DefaultAristaDirigida> graph, final String vertexEdgePair) {
        final String trimmedPair = vertexEdgePair.trim();
        final Ciudad from = new Ciudad(String.valueOf(trimmedPair.charAt(0)));
        final Ciudad to = new Ciudad(String.valueOf(trimmedPair.charAt(1)));
        final int weight = Integer.valueOf(trimmedPair.substring(2));
        graph.agregarVertice(from);
        graph.agregarVertice(to);
        graph.agregarArista(from, to, weight);
    }

}