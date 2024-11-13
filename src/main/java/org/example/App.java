package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class App extends Main {
    private static DefaultTableModel model;
    private JTextField field;
    private JFrame frame;
    private File inputFile;
    private File outputFile;

    public App() {
        frame = new JFrame("Five in a row!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[]{"Five in a row!"}, 0);
        model.addRow(new Object[]{"Приветствую! Введи путь к файлу с игрой и путь к месту, где хочешь сохранить результат в формате: \"{путь к файлу}\\input.txt {путь к файлу}\\output.txt\""});
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        field = new JTextField();
        frame.add(field, BorderLayout.SOUTH);

        frame.setVisible(true);

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = field.getText();
                //PrintBoardAndWinner();
                openFile(input);
                field.setText("");
            }
        });
    }

    private void openFile(String input) {
        model.addRow(new Object[]{input});
        String[] files = input.split(" ");
    }

    public static int[][] ReadFile(String[] files) {
        int[][] res;
        for (String file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                int lineCntr = 0;
                while (line != null) {
                    lineCntr++;//for (String num : line.split(" "))
                }
                res = new int[lineCntr][];

                br.close();
                br = new BufferedReader(new FileReader(file));
            } catch (IOException e) {
                model.addRow(new Object[]{"Error reading file"});
            }
        }
        return res;
    }

    private void saveFile() {

    }

    public static void main(String[] args) {
        new App();
    }
}
