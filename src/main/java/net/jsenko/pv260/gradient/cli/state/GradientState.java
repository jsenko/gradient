package net.jsenko.pv260.gradient.cli.state;

import net.jsenko.pv260.gradient.cli.Handler;
import net.jsenko.pv260.gradient.cli.State;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static net.jsenko.pv260.gradient.cli.States.EXIT;

/**
 * @author Jakub Senko
 */
public class GradientState implements State {

    @Override
    public State run(Handler handler, String data) {

        String[] parts = data.split(" +");

        if (parts.length == 4 && "radial".equals(parts[0])) {
            handler.radial(
                    parseInt(parts[1]),
                    parseInt(parts[2]),
                    parseInt(parts[3]));
            return EXIT;
        }

        if (parts.length == 5 && "linear".equals(parts[0])) {
            handler.linear(
                    parseInt(parts[1]),
                    parseInt(parts[2]),
                    parseInt(parts[3]),
                    parseInt(parts[4]));
            return EXIT;
        }

        out.println("Bad input format.");
        return EXIT;
    }
}
