package empolyee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname, tfname , taddress , tphone , taadhar , temail , tsalary ,tdesignation;

    JLabel tempid;
    JButton add , back;
    JDateChooser tdob ;

    JComboBox boxeducation;

    AddEmployee(){

        getContentPane().setBackground(new Color(253,76,84,200));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("Verdana" , Font.PLAIN,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF" , Font.PLAIN,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(phone);

        tphone= new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(email);

        temail= new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);

        JLabel education = new JLabel("Higest Degree");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(education);

        String items[] = {"BBA","B.Tech","BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        boxeducation = new JComboBox(items);
        boxeducation.setBounds(600,300,150,30);
        add(boxeducation);

        JLabel aadhar = new JLabel("Aadhar NO");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(aadhar);

        taadhar= new JTextField();
        taadhar.setBounds(600,350,150,30);
        add(taadhar);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(designation);

        tdesignation= new JTextField();
        tdesignation.setBounds(200,350,150,30);
        add(tdesignation);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        add(empid);

        tempid= new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.ITALIC,20));
        tempid.setForeground(Color.BLUE);
        add(tempid);

        add = new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(new Color(255,79,90,255));
        add.setOpaque(true);
        add.setBorderPainted(false);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add.setFont(new Font("SAN_SARIF", Font.BOLD,15));
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.white);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setFont(new Font("SAN_SARIF", Font.BOLD,15));
        back.addActionListener(this);
        back.setForeground(new Color(255,79,90,255));
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) boxeducation.getSelectedItem();
            String desingnation = tdesignation.getText();
            String empid = tempid.getText();

            try{
                Connect c = new Connect();
                String query = "insert into employee values ( '"+name+"' , '"+fname+"' ,'"+dob+"' , " +
                        "'"+salary+"' , '"+address+"' , '"+phone+"' , " +
                        "'"+email+"' ,'"+education+"' , '"+desingnation+"' , " +
                        "'"+aadhar+"' ,'"+empid+"')";

                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Details added successfully");
                setVisible(false);
                new Main_class();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        }else if (e.getSource() == back){
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
