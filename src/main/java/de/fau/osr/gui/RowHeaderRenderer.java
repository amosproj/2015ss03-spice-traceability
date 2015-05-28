package de.fau.osr.gui;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

class RowHeaderRenderer<E> extends JLabel implements ListCellRenderer<E> {

    RowHeaderRenderer(JTable table) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(LEFT);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());

        header.setResizingAllowed(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

