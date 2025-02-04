package empolyee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){

        JLabel heading = new JLabel("Employee Management");
        heading.setBounds(400,130,400,40);
        heading.setFont(new Font("Verdana" , Font.BOLD,25));
        add(heading);

        JButton addButton = new JButton("Add Employee");
        addButton.setBounds(413,200,300,40);
        addButton.setBackground(new Color(255,79,90,255));
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.setForeground(Color.white);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }

        });
        add(addButton);

        JButton viewButton = new JButton("View Employee");
        viewButton.setBounds(413,250,300,40);
        viewButton.setBackground(new Color(255,79,90,255));
        viewButton.setOpaque(true);
        viewButton.setBorderPainted(false);
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_employee();
                setVisible(false);
            }

        });

        add(viewButton);

        JButton removeButton = new JButton("Remove Employee");
        removeButton.setBounds(413,300,300,40);
        removeButton.setBackground(new Color(255,79,90,255));
        removeButton.setOpaque(true);
        removeButton.setBorderPainted(false);
        removeButton.setForeground(Color.white);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
                setVisible(false);
            }

        });
        add(removeButton);

        setSize(1170,650);
        setLocation(130,50);
        setLayout(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
