package net.jsenko.pv260.gradient.cli.state;

import net.jsenko.pv260.gradient.cli.Handler;
import net.jsenko.pv260.gradient.cli.State;
import static java.lang.System.out;
import static net.jsenko.pv260.gradient.cli.States.COLORS;
import static net.jsenko.pv260.gradient.cli.States.GRADIENT;

/**
 * @author Jakub Senko
 */
public class ColorsState implements State {

    @Override
    public State run(Handler handler, String data) {
        if(data.length() < 2) {
            out.println("Bad input format. At least two colors are required.");
            return COLORS;
        }

        handler.colors(data);
        out.println("Choose one of the gradient options:\n"
                + " - 'radial x y r'\n"
                + " - 'linear x1 y1 x2 y2'");
        return GRADIENT;
    }
}
