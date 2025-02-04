package empolyee.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login  extends JFrame implements ActionListener {

    JTextField tUsername;
    JTextField tPassword;
    JButton login , back;


    Login(){

        JLabel username = new JLabel("Username");
        username.setBounds( 40 , 20 , 100 , 30);
        add(username);

        tUsername = new JTextField();
        tUsername.setBounds(150, 20 , 150 , 30);
        add(tUsername);

        JLabel password = new JLabel("Password");
        password.setBounds(40 , 70 , 100, 30);
        add(password);

        tPassword = new JPasswordField();
        tPassword.setBounds(150, 70 , 150 , 30);
        add(tPassword);

        login = new JButton("Login");
        login.setBounds(150, 140 , 150, 30);
        login.setBackground(new Color(255,79,90,255));
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(150, 180 , 150, 30);
        back.setBackground(Color.black);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/result_login.jpg"));
        Image i22 = i11.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(360,5,200,200);
        add(imgg);

        setSize(600 , 300);
        setLocation(450 , 200);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            try{
                String username = tUsername.getText();
                String password = tPassword.getText();

                Connect connect = new Connect();

                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet resultSet = connect.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else if(e.getSource() == back){
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
