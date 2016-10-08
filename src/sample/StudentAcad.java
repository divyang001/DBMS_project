package sample;

import Database_functions.StudentDb;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.StudentModel;
/**
 * Created by divyang on 7/9/16.
 */
public class StudentAcad {

    public void Acad(Stage windows,String id)
    {
        javafx.scene.layout.GridPane grid = new javafx.scene.layout.GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        StudentModel obj;
        StudentDb obj1=new StudentDb();
        obj=obj1.acaddetails(id);

        Label regno = new Label("RegNO ;"+obj.getId());
        grid.setConstraints(regno, 1, 0);

        Label proctor = new Label("Proctor: "+obj.getProctor());
        grid.setConstraints(proctor, 1, 1);

        Label prog = new Label("Department: "+obj.getDepartment());
        grid.setConstraints(prog, 1, 2);

        Label branch= new Label("Branch: "+obj.getBranch());
        grid.setConstraints(branch, 1, 3);

        Label school = new Label("School: "+obj.getSchool());
        grid.setConstraints(school, 1, 4);

        Button back = new Button("BACK");
        grid.setConstraints(back, 1, 5);

        grid.getChildren().addAll(proctor,regno,prog,branch,school,back);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add("/styleSheet/login.css");
        windows.setScene(scene);
        windows.show();
        back.setOnAction(event -> {
            Student obj2=new Student();
            obj2.trying(windows,id);
        });

    }

}
