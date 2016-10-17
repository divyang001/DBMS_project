package sample;

import Database_functions.StudentDb;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.ParentModel;
import models.StudentModel;

public class StudentProfile {

    public void Profile(Stage windows,String id, String id2)
    {
        javafx.scene.layout.GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(20);

        StudentDb obj=new StudentDb();
        StudentModel obj1;
        ParentModel obj2;
        obj1=obj.details(id);
        obj2=obj.parentdetails(id);

        Label regno = new Label("Register No: "+obj1.getId());
        grid.setConstraints(regno, 1, 0);

        Label name = new Label("Name: "+obj1.getName());
        grid.setConstraints(name, 1, 1);

        Label dob = new Label("DOB: "+obj1.getDob());
        grid.setConstraints(dob, 1, 2);

        Label num = new Label("Contact: "+obj1.getContact());
        grid.setConstraints(num, 1, 3);

        Label add = new Label("Address :"+obj1.getAddress());
        grid.setConstraints(add, 1, 4);

       Label pinfo = new Label("PARENT'S INFO");
        grid.setConstraints(pinfo, 1, 5);

        Label pname = new Label("Parent Name: "+obj2.getName());
        grid.setConstraints(pname, 1, 6);

        Label poccu = new Label("PARENT Occupation: "+ obj2.getOccupation());
        grid.setConstraints(poccu, 1, 7);

        Label pcon = new Label("Parent ContactNO: "+ obj2.getContact());
        grid.setConstraints(pcon, 1, 8);

        Button back = new Button("BACK");
        grid.setConstraints(back, 1, 9);

        grid.getChildren().addAll(name,regno,dob,num,add,pinfo,pname,poccu,pcon,back);
        Scene scene = new Scene(grid, 600, 600);
        scene.getStylesheets().add("/styleSheet/login.css");
        windows.setScene(scene);
        windows.show();
        back.setOnAction(event -> {

            if(id2.equals("from1"))
            {
                Student obj4=new Student();
                obj4.trying(windows,id);
            }
            else
            {
                Faculty obj5 = new Faculty();
                obj5.MainMenu(windows,id2);

            }

        });



    }







}
