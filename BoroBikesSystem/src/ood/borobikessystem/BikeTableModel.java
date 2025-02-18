/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobikessystem;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BikeTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Make & Model", "Color", "Age Range", "Material", "Price (£)", "Stock", "Assembled"};
    private final List<Bike> bikes;

    public BikeTableModel(List<Bike> bikes) {
        this.bikes = bikes;
    }

    @Override
    public int getRowCount() {
        return bikes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Bike bike = bikes.get(row);
        return switch (col) {
            case 0 -> bike.getMakeModel();
            case 1 -> bike.getColor();
            case 2 -> bike.getAgeRange();
            case 3 -> bike.getMaterial();
            case 4 -> String.format("%.2f", bike.getPrice());
            case 5 -> bike.getStock();
            case 6 -> bike.isAssembled();
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return (col == 6) ? Boolean.class : String.class;
    }
}
