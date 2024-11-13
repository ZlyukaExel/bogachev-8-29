package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class App extends Main {
private DefaultTableModel model;
    private JTextField field;
    private JFrame frame;
    private File inputFile;
    private File outputFile;

    public App() {
        frame = new JFrame("Five in a row!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[]{"Five in a row!"}, 0);
        model.addRow(new Object[]{"Приветствую! Введи путь к файлу с игрой и путь к месту, где хочешь сохранить результат в формате: \"{путь к файлу}\\input.txt {путь к файлу}\\output.txt\""});
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane,BorderLayout.CENTER);

        field = new JTextField();
        frame.add(field,BorderLayout.SOUTH);

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
    }

    private void saveFile() {

    }

    public static void main(String[] args){
        new App();
    }
}
