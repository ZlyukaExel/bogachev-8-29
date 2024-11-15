package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static org.example.Main.PrintBoardAndWinner;
import static org.example.Reader.ReadFile;
import static org.example.Writer.WriteFile;

public class App {
    private final DefaultTableModel model;
    private final JTextField field;
    private int rows = 5;
    private int columns = 5;

    public App() {
        JFrame frame = new JFrame("Five in a row!");
        frame.setTitle("Five in a row!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        frame.setLayout(new BorderLayout());

        model = new DefaultTableModel(rows, columns);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        field = new JTextField();
        bottomPanel.add(field, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        JButton readButton = new JButton("Load file");
        JButton outputButton = new JButton("Save result");
        JButton addColumnButton = new JButton("Add column");
        JButton addRowButton = new JButton("Add row");

        buttonPanel.add(readButton);
        buttonPanel.add(outputButton);
        buttonPanel.add(addColumnButton);
        buttonPanel.add(addRowButton);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        readButton.addActionListener(_ -> {
            String input = field.getText();
            field.setText("");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    model.setValueAt(null, i, j);
                }
            }

            if (input.isEmpty()) {
                model.setColumnCount(5);
                model.setRowCount(5);
                rows = 5;
                columns = 5;
            } else {
                int[][] board = ReadFile(input);
                rows = board.length;
                columns = board[0].length;
                model.setRowCount(rows);
                model.setColumnCount(columns);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        model.setValueAt(board[i][j], i, j);
                    }
                }
            }
        });


        outputButton.addActionListener(_ -> {
            int[][] outputArray = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    String val = (String) model.getValueAt(i, j);
                    outputArray[i][j] = val == null ? 2 : Integer.parseInt(val);
                }
            }
            //WriteFile(FindWinner(outputArray));
            PrintBoardAndWinner(outputArray);
        });

        addColumnButton.addActionListener(_ -> {
            model.setColumnCount(model.getColumnCount() + 1);
            columns++;
        });

        addRowButton.addActionListener(_ -> {
            model.setRowCount(model.getRowCount() + 1);
            rows++;
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
