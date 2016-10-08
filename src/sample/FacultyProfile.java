package sample;


import Database_functions.FacultyDb;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.FacultyModel;

public class FacultyProfile {

    public  void detailing(Stage windows,String id)
    {
        FacultyDb obj = new FacultyDb();
        FacultyModel obj1;
        obj1=obj.profile(id);
        javafx.scene.layout.GridPane grid = new javafx.scene.layout.GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label ids = new Label("ID NUMBER: "+obj1.getFaculty_id());
        grid.setConstraints(ids, 1, 0);

        Label name = new Label("NAME: "+obj1.getFaculty_name());
        grid.setConstraints(name, 1, 1);

        Label num = new Label("CONTACT NUMBER: "+obj1.getFaculty_mobile());
        grid.setConstraints(num, 1, 2);

        Label spe = new Label("SPECIALIZATION: "+obj1.getFaculty_special());
        grid.setConstraints(spe, 1, 3);

        Label pro = new Label("ONGOING PROJECTS: "+obj1.getProject());
        grid.setConstraints(pro, 1, 4);

        Label school = new Label("SCHOOL: "+obj1.getSchool());
        grid.setConstraints(school, 1, 5);

        Button back = new Button("BACK");
        grid.setConstraints(back, 1, 6);

        grid.getChildren().addAll(name,ids,spe,num,school,back,pro);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add("/styleSheet/login.css");
        windows.setScene(scene);
        windows.show();
        back.setOnAction(event -> {
            Faculty obj2=new Faculty();
            obj2.MainMenu(windows,id);
        });









    }





}
