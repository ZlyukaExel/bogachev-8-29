package org.example;

import java.util.MissingFormatArgumentException;

public class Main {
    public static void main(String[] args) {
        //fast check
        /*for (int i = 1; i <= 5; i++) {
            {
                PrintBoardAndWinner(ReadFile("input" + i + ".txt"));
            }
        }*/

        if (args[0].equals("-a")) {
            if (args[1].equals("console"))
                ConsoleApp.main(args);
            else if (args[1].equals("window"))
                new App();
            else
                throw new IllegalArgumentException("Указанный тип приложения не существует!");
        } else
            throw new MissingFormatArgumentException("Тип приложения не указан! -a <app-type>");
    }
}