package net.jsenko.pv260.gradient.cli;

import net.jsenko.pv260.gradient.cli.state.ColorsState;
import net.jsenko.pv260.gradient.cli.state.DisplaySizeState;
import net.jsenko.pv260.gradient.cli.state.GradientState;

/**
 * @author Jakub Senko
 */
public interface States {

    public static final State DISPLAY_SIZE = new DisplaySizeState();
    public static final State COLORS = new ColorsState();
    public static final State GRADIENT = new GradientState();
    public static final State DONE = null;
}
