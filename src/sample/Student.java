package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Student {
    Button button,button2,button3,button4;
    Scene scene1,scene2;

    public void trying(Stage windows,String id)
    {
        Button profile = new Button("PROFILE");
        Button current_sem = new Button("FALL 2016-17");
        Button details = new Button("ACADEMIC DETAILS");
        Button fac = new Button("FIND YOUR FACULTY");
        Button hist = new Button("ACADEMIC HISTORY");
        Button logout=new Button("Log Out");

        javafx.scene.layout.GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        GridPane.setConstraints(profile, 1, 1);
        GridPane.setConstraints(current_sem, 1, 2);
        GridPane.setConstraints(details, 1, 3);
        GridPane.setConstraints(hist, 1, 4);
        GridPane.setConstraints(fac, 1, 5);
        GridPane.setConstraints(logout, 1, 6);
        grid.getChildren().addAll(profile, current_sem, details, hist, fac,logout);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add("/styleSheet/studfac.css");
        windows.setScene(scene);
        windows.show();


        profile.setOnAction(event ->{
            StudentProfile obj=new StudentProfile();
            obj.Profile(windows,id,"from1");
                }

        );
details.setOnAction(event -> {
    StudentAcad obj1=new StudentAcad();
    obj1.Acad(windows,id);


});

        logout.setOnAction(event -> {

            Main obj=new Main();
            obj.login(windows,"stud_password");

        });

    }





}
