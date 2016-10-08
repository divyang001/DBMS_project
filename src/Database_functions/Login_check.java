package Database_functions;

import DatabaseConnection.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_check {
    public boolean check(String username,String passwords,String tables){
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String columns=null;
        if(tables=="fac_password")
        {
            columns="faculty_id";

        }
        else {
                columns="id";
        }
        try {
            connection= DbConnect.MakeConnection();
            preparedStatement=connection.prepareStatement("SELECT* FROM " +tables +" WHERE "+  columns+" =? and password=?");
            if(tables=="fac_password")
            {
                int x=Integer.parseInt(username);
                preparedStatement.setInt(1,x);

            }
            else
            {
                preparedStatement.setString(1,username);

            }
            preparedStatement.setString(2,passwords);
            resultSet=preparedStatement.executeQuery();

                    if(resultSet.next()) {

                        if (resultSet.getString(columns).equals(username) && resultSet.getString("password").equals(passwords)) {
                            System.out.print("hello");
                            return true;
                        }
                    }
            }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        finally {
            if(resultSet!=null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;

    }
}
