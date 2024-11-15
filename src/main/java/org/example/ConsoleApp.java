/*package org.example;

import org.apache.commons.cli.*;

import java.io.PrintStream;
import java.util.Locale;

import static org.example.Reader.ReadFile;

/**
 * Демонстрируется работа с библиотекой apache commons-cli
 *
 * @see <a href="https://urvanov.ru/2019/06/08/apache-commons-cli/">Apache Commons CLI</a>
 * @see <a href="https://coderlessons.com/tutorials/java-tekhnologii/izuchite-apache-commons-cli/apache-commons-cli-kratkoe-rukovodstvo">Apache Commons CLI — Краткое руководство</a>
 */
/*public class ConsoleApp {
    public static final String PROGRAM_NAME_IN_HELP = "program -i <in-file> [-o <out-file>])";

    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    public static void main(String[] args) throws Exception {
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("i", "input-file", true, "Input file");
        cmdLineOptions.addOption("o", "output-file", true, "Output file");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;
        try {
            cmdLine = parser.parse(cmdLineOptions, args);
        } catch (Exception e) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }

        if (!cmdLine.hasOption("i"))
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
        System.exit(1);

        String inputFilename = cmdLine.getOptionValue("i");
        int[][] arr2 = ReadFile(inputFilename);

        PrintStream out = (cmdLine.hasOption("o")) ? new PrintStream(cmdLine.getOptionValue("o")) : System.out;
        out.close();
    }
}
*/

