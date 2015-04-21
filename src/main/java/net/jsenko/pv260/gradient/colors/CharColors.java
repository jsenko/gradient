package net.jsenko.pv260.gradient.colors;

import static java.util.Objects.requireNonNull;

/**
 * @author Jakub Senko
 */
public class CharColors implements Colors {


    private final String colorChars;

    private static final int MAX_COLORS = 100;


    public CharColors(String colorChars) {
        requireNonNull(colorChars);

        if (colorChars.length() < 2)
            throw new IllegalArgumentException("Min number of colors is 2.");

        if (colorChars.length() > MAX_COLORS)
            throw new IllegalArgumentException("Max number of colors is " + MAX_COLORS + ".");

        this.colorChars = colorChars;
    }

    @Override
    public char color(double value) {
        if (value < 0 || value > 1)
            throw new IllegalArgumentException("Lightness must be within [0, 1] interval.");

        int index = (int) Math.round(value * (colorChars.length() - 1));
        return colorChars.charAt(index);
    }
}
