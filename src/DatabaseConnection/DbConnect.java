package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {
    private Statement st;
    private ResultSet rs;

    public static Connection MakeConnection()
    {
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/divyang","root","root");
        }
        catch (Exception e)
        {
            System.out.println("error" +e);
        }
        return  connection;
    }

}
