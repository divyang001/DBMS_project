package Database_functions;

import DatabaseConnection.DbConnect;
import models.ParentModel;
import models.StudentModel;
import sample.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by divyang on 7/9/16.
 */
public class StudentDb {
    StudentModel obj=new StudentModel();
    public StudentModel details(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnect.MakeConnection();
            preparedStatement = connection.prepareStatement("SELECT* FROM student WHERE id=? ");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                obj.setName(resultSet.getString("name"));
                obj.setId(resultSet.getString("id"));
                obj.setAddress(resultSet.getString("address"));
                obj.setDob(resultSet.getString("dob"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

return obj;
    }
    public StudentModel acaddetails(String id)
    {    Connection connection = null;
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnect.MakeConnection();
            preparedStatement = connection.prepareStatement("SELECT* FROM academic_details WHERE id=? ");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int branchs;
                int school;
                int programs;
                int teacher;


                obj.setId(resultSet.getString("id"));
                branchs=resultSet.getInt("branch_id");
                school=resultSet.getInt("school_id");
                programs=resultSet.getInt("program_id");
                teacher=resultSet.getInt("Faculty_id");


                PreparedStatement preparedStatement1 = null;
                ResultSet resultSet1 = null;
                connection1 = DbConnect.MakeConnection();
                preparedStatement1 = connection1.prepareStatement("SELECT branch_name FROM branch WHERE branch_id=? ");
                preparedStatement1.setInt(1, branchs);
               resultSet1 = preparedStatement1.executeQuery();
              if(resultSet1.next())
               {
                    obj.setBranch(resultSet1.getString("branch_name"));
                }
               else
                {
                    obj.setBranch("hey");

                }

                preparedStatement1 = connection1.prepareStatement("SELECT * FROM school WHERE school_id=? ");
                preparedStatement1.setInt(1, school);
                resultSet1 = preparedStatement1.executeQuery();
                if(resultSet1.next())
                {
                    obj.setSchool(resultSet1.getString("school_name"));
                }
                else
                {

                }



                preparedStatement1 = connection1.prepareStatement("SELECT program_name FROM program WHERE program_id=? ");
                preparedStatement1.setInt(1, programs);
                resultSet1 = preparedStatement1.executeQuery();
                if(resultSet1.next())
                {
                    obj.setDepartment(resultSet1.getString("program_name"));
                }
                else
                {

                }



                preparedStatement1 = connection1.prepareStatement("SELECT Faculty_name FROM facultyprofile WHERE faculty_id=? ");
                preparedStatement1.setInt(1, teacher);
                resultSet1 = preparedStatement1.executeQuery();
                if(resultSet1.next())
                {
                    obj.setProctor(resultSet1.getString("Faculty_name"));
                }
                else {

                }

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }


    public ParentModel parentdetails(String id)
    {
        ParentModel obj1=new ParentModel();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnect.MakeConnection();
            preparedStatement = connection.prepareStatement("SELECT* FROM parent_info WHERE id=? ");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                obj1.setName(resultSet.getString("parent_name"));
                obj1.setOccupation(resultSet.getString("occupation"));
                obj1.setContact(resultSet.getNString("contact_no"));
                        }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return obj1;
    }





}
