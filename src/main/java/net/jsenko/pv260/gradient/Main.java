package net.jsenko.pv260.gradient;

import net.jsenko.pv260.gradient.cli.CLI;
import net.jsenko.pv260.gradient.cli.Handler;
import static java.lang.System.in;

public class Main {


    public static void main(String[] args) {

        new CLI(new Handler()).run(in);
    }
}
