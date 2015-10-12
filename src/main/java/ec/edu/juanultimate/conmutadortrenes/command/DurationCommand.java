package ec.edu.juanultimate.conmutadortrenes.command;


import ec.edu.juanultimate.conmutadortrenes.Commuter;
import ec.edu.juanultimate.conmutadortrenes.dominio.trenes.Ciudad;

import java.io.PrintStream;
import java.util.List;

public class DurationCommand extends RouteCommand {

    public DurationCommand(String commandLine, PrintStream outputStream) {
        super(commandLine, outputStream);
    }

    @Override
    protected int callCommuter(Commuter commuter, Ciudad start, Ciudad end, List<Ciudad> intermediate) {
        return commuter.routeDuration(start, end, intermediate);
    }

}
