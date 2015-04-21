package net.jsenko.pv260.gradient.cli.state;

import net.jsenko.pv260.gradient.cli.Handler;
import net.jsenko.pv260.gradient.cli.State;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static net.jsenko.pv260.gradient.cli.States.COLORS;
import static net.jsenko.pv260.gradient.cli.States.DISPLAY_SIZE;
import static net.jsenko.pv260.gradient.cli.States.DONE;

/**
 * @author Jakub Senko
 */
public class DisplaySizeState implements State {

    @Override
    public State run(Handler handler, String data) {

        String[] parts = data.split(" +");

        if (parts.length != 2) {
            out.println("Bad input format. Two arguments required.");
            return DISPLAY_SIZE;
        }

        try {
            handler.displaySize(parseInt(parts[0]), parseInt(parts[1]));
        } catch (NumberFormatException e) {
            out.println("Bad input format. Numbers required.");
            return DISPLAY_SIZE;
        }


        out.println("String of 'colors', starting with the 'lightest':");

        return COLORS;
    }
}
