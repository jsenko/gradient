package net.jsenko.pv260.gradient.cli.state;

import net.jsenko.pv260.gradient.cli.Handler;
import net.jsenko.pv260.gradient.cli.State;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static net.jsenko.pv260.gradient.cli.States.DONE;
import static net.jsenko.pv260.gradient.cli.States.GRADIENT;

/**
 * @author Jakub Senko
 */
public class GradientState implements State {

    @Override
    public State run(Handler handler, String data) {

        String[] parts = data.split(" +");

        try {
            if (parts.length == 4 && "radial".equals(parts[0])) {

                int radius = parseInt(parts[3]);
                if (radius < 0) {
                    out.println("Bad input format. Radius must be non-negative.");
                    return GRADIENT;
                }

                handler.radial(
                        parseInt(parts[1]),
                        parseInt(parts[2]),
                        parseInt(parts[3]));
                return DONE;
            }

            if (parts.length == 5 && "linear".equals(parts[0])) {

                int x1 = parseInt(parts[1]);
                int y1 = parseInt(parts[2]);
                int x2 = parseInt(parts[3]);
                int y2 = parseInt(parts[4]);

                if (x1 == x2 && y1 == y2) {
                    out.println("Bad input format. Points must not be the same.");
                    return GRADIENT;
                }

                handler.linear(
                        parseInt(parts[1]),
                        parseInt(parts[2]),
                        parseInt(parts[3]),
                        parseInt(parts[4]));
                return DONE;
            }

        } catch (NumberFormatException e) {
            out.println("Bad input format. Numbers required.");
            return GRADIENT;
        }

        out.println("Bad input format.\nStart with 'radial' or 'linear'.");
        return GRADIENT;
    }
}
