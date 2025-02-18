/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobikessystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoroBikesController {
    private JFrame frame;
    private JTable table;
    private BikeTableModel tableModel;
    private List<Bike> bikeList;

    public BoroBikesController() {
        frame = new JFrame("Boro Bikes Stock Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        bikeList = new ArrayList<>();
        loadSampleData();

        tableModel = new BikeTableModel(bikeList);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton sellButton = new JButton("Sell Item");
        JButton updateStockButton = new JButton("Update Stock");
        JButton quitButton = new JButton("Quit");

        buttonPanel.add(sellButton);
        buttonPanel.add(updateStockButton);
        buttonPanel.add(quitButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        sellButton.addActionListener(e -> sellStock());
        updateStockButton.addActionListener(e -> updateStock());
        quitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private void loadSampleData() {
        bikeList.add(new Bike("B001", "Trek", "Speedster", "Red", "5-8", "Aluminum", "Lightweight frame", 199.99, 5, true));
        bikeList.add(new Bike("B002", "Giant", "Racer", "Blue", "8-11", "Steel", "Disc brakes", 249.99, 3, false));
        bikeList.add(new Bike("B003", "Scott", "Mountain", "Black", "12-15", "Carbon Fiber", "Hydraulic suspension", 499.99, 2, true));
    }

    private void sellStock() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a bike to sell.");
            return;
        }
        Bike selectedBike = bikeList.get(selectedRow);

        String input = JOptionPane.showInputDialog(frame, "Enter quantity to sell:");
        if (input != null) {
            try {
                int quantity = Integer.parseInt(input);
                if (quantity > 0 && quantity <= selectedBike.getStock()) {
                    selectedBike.updateStock(-quantity);
                    tableModel.fireTableDataChanged();
                    JOptionPane.showMessageDialog(frame, "Sold " + quantity + " bikes of " + selectedBike.getMakeModel());
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid quantity!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        }
    }

    private void updateStock() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a bike to update stock.");
            return;
        }
        Bike selectedBike = bikeList.get(selectedRow);

        String input = JOptionPane.showInputDialog(frame, "Enter quantity to add:");
        if (input != null) {
            try {
                int quantity = Integer.parseInt(input);
                if (quantity > 0) {
                    selectedBike.updateStock(quantity);
                    tableModel.fireTableDataChanged();
                    JOptionPane.showMessageDialog(frame, "Updated stock of " + selectedBike.getMakeModel() + " by " + quantity);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid quantity!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        new BoroBikesController();
    }
}
