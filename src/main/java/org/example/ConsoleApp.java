package org.example;

import org.apache.commons.cli.*;

import static org.example.Reader.ReadFile;
import static org.example.WinnerFinder.FindWinner;
import static org.example.Writer.WriteFile;

public class ConsoleApp {
    public static final String help = "-i <in-file> [-o <out-file>]";

    public ConsoleApp(String[] args) {
        Options cmdLineOptions = new Options();
        //cmdLineOptions.addOption("a", "app-type", false, "Type of the app to launch");
        cmdLineOptions.addOption("i", "input-file", true, "Input file directory");
        cmdLineOptions.addOption("o", "output-file", true, "Output file directory");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;
        try {
            cmdLine = parser.parse(cmdLineOptions, args);
        } catch (Exception e) {
            new HelpFormatter().printHelp(help, cmdLineOptions);
            System.exit(1);
        }

        if (!cmdLine.hasOption("i")) {
            new HelpFormatter().printHelp(help, cmdLineOptions);
            System.exit(1);
        }

        String inputFilename = cmdLine.getOptionValue("i");
        int[][] array = ReadFile(inputFilename);

        int winner = FindWinner(array);
        System.out.println("The winner is: " + winner);

        if (cmdLine.hasOption("o"))
            WriteFile(cmdLine.getOptionValue("o"), winner);
        System.out.close();
    }
}


