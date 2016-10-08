package Database_functions;

import DatabaseConnection.DbConnect;
import models.FacultyModel;
import models.StudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FacultyDb {
    FacultyModel obj=new FacultyModel();
    public FacultyModel profile(String id)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnect.MakeConnection();
            preparedStatement = connection.prepareStatement("SELECT* FROM facultyprofile WHERE Faculty_id=? ");
            int x=Integer.parseInt(id);
            preparedStatement.setInt(1, x);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                int projectid;
                int school;
                obj.setFaculty_id(resultSet.getInt("Faculty_id"));
                obj.setFaculty_name(resultSet.getString("Faculty_name"));
                obj.setFaculty_mobile(resultSet.getString("Faculty_mobile"));
                obj.setFaculty_special(resultSet.getString("Faculty_special"));
                projectid=resultSet.getInt("project_id");
                school=resultSet.getInt("school_id");


                PreparedStatement preparedStatement1 = null;
                ResultSet resultSet1 = null;
                preparedStatement1 = connection.prepareStatement("SELECT school_name FROM divyang.school WHERE school_id=? ");
                preparedStatement1.setInt(1, school);
                resultSet1 = preparedStatement1.executeQuery();
                if(resultSet1.next())
                {
                    obj.setSchool(resultSet1.getString("school_name"));
                }


                preparedStatement1 = connection.prepareStatement("SELECT project_name FROM divyang.faculty_projects WHERE project_id=? ");
                preparedStatement1.setInt(1, projectid);
                resultSet1 = preparedStatement1.executeQuery();
                if(resultSet1.next()) {
                    obj.setProject(resultSet1.getString("project_name"));
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

    public List<StudentModel> Proctee(String id)
    {
        List<StudentModel> list=new ArrayList<StudentModel>() ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnect.MakeConnection();
            preparedStatement = connection.prepareStatement("SELECT* FROM proctor WHERE Faculty_id=? ");
            int x=Integer.parseInt(id);
            preparedStatement.setInt(1, x);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String studentid;
                studentid=resultSet.getString("id");
                StudentModel obj =new StudentModel();
                StudentDb obj1=new StudentDb();
                obj=obj1.details(studentid);
                list.add(obj);

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
        return  list;
    }




}
