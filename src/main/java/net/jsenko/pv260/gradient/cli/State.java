package net.jsenko.pv260.gradient.cli;

/**
* @author Jakub Senko
*/
@FunctionalInterface
public interface State {

    State run(Handler handler, String data);
}
