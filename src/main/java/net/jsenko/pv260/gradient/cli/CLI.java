package net.jsenko.pv260.gradient.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;
import static net.jsenko.pv260.gradient.cli.States.DISPLAY_SIZE;

/**
 * @author Jakub Senko
 */
public class CLI {

    private final Handler handler;

    private State state;


    public CLI(Handler handler) {
        this.handler = handler;
        state = DISPLAY_SIZE;
    }


    public boolean read(String data) {
        state = state.run(handler, data);
        if (state == null)
            return false;
        return true;
    }


    public void run() {
        out.println("Size of the display (x y):");

        String input;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            out.print("> ");
            while ((input = br.readLine()) != null) {
                if (!read(input))
                    break;
                out.print("> ");
            }
        } catch (Exception e) {
            out.println("Error: " + e);
        }
    }
}
