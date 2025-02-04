package empolyee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {

    Connection connection;
    public Statement statement;

    public Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement",
                    "root","Vishwa.0019");
            statement = connection.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
