package net.jsenko.pv260.gradient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.jsenko.pv260.gradient.cli.CLI;
import net.jsenko.pv260.gradient.cli.Handler;

public class Main {


    public static void main(String[] args) {

        new CLI(new Handler()).run();
    }
}
