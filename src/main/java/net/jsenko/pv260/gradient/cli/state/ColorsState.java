package net.jsenko.pv260.gradient.cli.state;

import net.jsenko.pv260.gradient.cli.Handler;
import net.jsenko.pv260.gradient.cli.State;
import net.jsenko.pv260.gradient.cli.States;
import static java.lang.System.out;

/**
 * @author Jakub Senko
 */
public class ColorsState implements State {

    @Override
    public State run(Handler handler, String data) {
        handler.colors(data);
        out.println("Choose one of the gradient options:\n"
                + " - radial x y r\n"
                + " - linear x1 y1 x2 y2");
        return States.GRADIENT;
    }
}
