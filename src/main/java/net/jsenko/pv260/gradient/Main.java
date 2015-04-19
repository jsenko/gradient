package net.jsenko.pv260.gradient;

import static net.jsenko.pv260.gradient.Point.point;

public class Main {


    public void run() {
        CharColors charColors = new CharColors(" .,:;xX&@");
        //RadialGradient gradient = new RadialGradient(point(20, 15), 20);
        LinearGradient gradient = new LinearGradient(point(30, 30), Point.ZERO);
        CharColorized colorized = new CharColorized(gradient, charColors);
        GridView<Character> view = new GridView<>(colorized, Point.ZERO, 30, 40);
        RowGridViewIterator<Character> it = new RowGridViewIterator<>(view);
        it.iterate((location, character) -> {
            System.out.print(character);
            if (location.getX() % 30 == 29)
                System.out.println();
        });
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
