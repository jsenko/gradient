package net.jsenko.pv260.gradient.cli.state;

import net.jsenko.pv260.gradient.cli.Handler;
import net.jsenko.pv260.gradient.cli.State;

/**
* @author Jakub Senko
*/
public class DoneState implements State {

    @Override
    public State run(Handler handler, String data) {
        return null;
    }
}
