package net.jsenko.pv260.gradient.colors;

/**
 * @author Jakub Senko
 */
public interface Colors {

    /**
     * Assign one of the discreet colors that correspond
     * to the 'lightness' given by continuous (real) value.
     */
    char color(double value);
}
